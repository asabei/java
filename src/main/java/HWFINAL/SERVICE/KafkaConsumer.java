package HWFINAL.SERVICE;

import HWFINAL.DTO.Message;
import HWFINAL.DTO.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import jakarta.annotation.PostConstruct;
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

    @PostConstruct
    public void initDb() {
        String dropTableUs = "DROP TABLE IF EXISTS Users";
        jdbcTemplate.execute(dropTableUs);
        writeLog(dropTableUs);
        String dropTableDep = "DROP TABLE IF EXISTS Department";
        jdbcTemplate.execute(dropTableDep);
        writeLog(dropTableDep);
        String createDepartment = "CREATE TABLE IF NOT EXISTS Department (\n" +
                "    id SERIAL PRIMARY KEY,\n" +
                "    NameDepartment TEXT NOT NULL\n" +
                ");";
        String createUsers = "CREATE TABLE IF NOT EXISTS Users (\n" +
                "    id SERIAL PRIMARY KEY,\n" +
                "    FirstName TEXT NOT NULL,\n" +
                "    LastName TEXT NOT NULL,\n" +
                "    birthDay DATE,\n" +
                "    DepartmentId INT,\n" +
                "    CONSTRAINT fk_department FOREIGN KEY (DepartmentId) REFERENCES Department(id),\n" +
                "    CONSTRAINT unique_first_last_name UNIQUE (FirstName, LastName)\n" +
                ");";

        jdbcTemplate.execute(createDepartment);
        jdbcTemplate.execute(createUsers);
        writeLog(createDepartment);
        writeLog(createUsers);


        String insertDep = "INSERT INTO Department (NameDepartment) VALUES \n" +
                "('IT'),\n" +
                "('HR'),\n" +
                "('Finance'),\n" +
                "('Marketing'),\n" +
                "('Sales'),\n" +
                "('Engineering'),\n" +
                "('Support'),\n" +
                "('Research'),\n" +
                "('Legal'),\n" +
                "('Administration');";
        jdbcTemplate.execute(insertDep);
        writeLog("INSERT INTO Department");

        String insertUsers = "INSERT INTO Users (FirstName, LastName, birthDay, DepartmentId) VALUES \n" +
                "('John', 'Doe', '1990-01-15', 1),\n" +
                "('Jane', 'Smith', '1985-03-20', 2),\n" +
                "('Mike', 'Johnson', '1992-07-10', 1),\n" +
                "('Sarah', 'Williams', '1988-11-05', 3),\n" +
                "('Tom', 'Brown', '1991-02-28', 1),\n" +
                "('Emma', 'Davis', '1987-09-12', 2),\n" +
                "('Chris', 'Miller', '1993-04-18', 1),\n" +
                "('Lisa', 'Wilson', '1989-06-25', 4),\n" +
                "('David', 'Taylor', '1990-12-08', 1),\n" +
                "('Anna', 'Anderson', '1986-08-14', 5);";
        jdbcTemplate.execute(insertUsers);
        writeLog("INSERT INTO Users");
    }

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
