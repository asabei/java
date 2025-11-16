package HWFINAL.SERVICE;

import HWFINAL.DTO.Message;
import HWFINAL.DTO.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.logging.Logger;

import static HWFINAL.SERVICE.Logging.writeLog;


@Service
public class KafkaConsumer {
   // private static final Logger logger = (Logger) LoggerFactory.getLogger(KafkaConsumer.class);
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    @Autowired
    private JdbcTemplate jdbcTemplate;


    private final ObjectMapper objectMapper = new ObjectMapper().registerModule(new JavaTimeModule());

    @KafkaListener(topics = "finalProject", groupId = "group")
    public void consume(Message kafkaMessage) {
        String urlRequest = kafkaMessage.getUrlRequest();
        Object message = kafkaMessage.getMessage();
        String logText = String.format("DataTime: %s /urlRequest: %s: {%s}", LocalDateTime.now().format(formatter), urlRequest, message.toString());
        writeLog(logText);

        try {
            switch (urlRequest) {
                case "/createUser":
                    User userToCreate = objectMapper.convertValue(message, User.class);
                    jdbcTemplate.update("INSERT INTO Users (FirstName, LastName, birthDay, DepartmentId) VALUES (?, ?, ?, ?)",
                            userToCreate.getFirstName(), userToCreate.getLastName(), userToCreate.getBirthDay(), userToCreate.getDepartmentId());
                    writeLog("Пользователь успешно создан в БД:");
                    break;

                case "/updateUser":
                    User userToUpdate = objectMapper.convertValue(message, User.class);
                    jdbcTemplate.update("UPDATE Users SET birthDay = ?, DepartmentId = ? WHERE FirstName = ? AND LastName = ?",
                            userToUpdate.getBirthDay(), userToUpdate.getDepartmentId(), userToUpdate.getFirstName(), userToUpdate.getLastName());
                    writeLog("Пользователь успешно обновлен в БД");
                    break;

                case "/deleteUserByLastName":
                    Map<String, String> params = objectMapper.convertValue(message, Map.class);
                    String lastName = params.get("lastName");
                    int deletedRows = jdbcTemplate.update("DELETE FROM Users WHERE LastName = ?", lastName);
                    writeLog("Из БД удалено пользователей с фамилией .");
                    break;

                case "/deleteUsers":
                    jdbcTemplate.update("TRUNCATE TABLE Users RESTART IDENTITY");
                    writeLog("Таблица Users была полностью очищена.");
                    break;

                default:

                    writeLog("Получено информационное событие (без изменения БД)");
                    break;
            }
        } catch (Exception e) {
            writeLog("!!! Ошибка при выполнении запроса к БД для ");
        }
    }
}
