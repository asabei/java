package HWFINAL.SERVICE;


import HWFINAL.DTO.Message;
import HWFINAL.DTO.User;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Map;

import static HWFINAL.SERVICE.Logging.writeLog;

@RestController
@RequestMapping("/")
public class KafkaProducer {
    private static final String TOPIC = "finalProject";


    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;


    @PostMapping("/createUser")
    public ResponseEntity<String> createUser(@Valid @RequestBody User user) {
        sendMessage("/createUser", user);
        return ResponseEntity.ok("Запись по (созданию пользователя) успешно добавлена в кафку");
    }
    @PostMapping("/updateUser")
    public ResponseEntity<String> updateUser(@Valid @RequestBody User user) {
        sendMessage("/updateUser", user);
        return ResponseEntity.ok("Запись по (обновлению пользователя) успешно добавлена в кафку");
    }
    @DeleteMapping("/deleteUserByLastName")
    public ResponseEntity<String> deleteUserByLastName(@RequestParam String lastName) {
        sendMessage("/deleteUserByLastName", Map.of("lastName", lastName));
        return ResponseEntity.ok("Запись по (удалению по фамилии) успешно добавлена в кафку");
    }
    @DeleteMapping("/deleteUsers")
    public ResponseEntity<String> deleteUsers() {
        sendMessage("/deleteUsers", "truncate all users");
        return ResponseEntity.ok("Запись по (удалению всех пользователей) успешно добавлена в кафку");
    }
    @GetMapping("/getAllUsers")
    public ResponseEntity<String> getAllUsers() {
        sendMessage("/getAllUsers", "get all users request");

        return ResponseEntity.ok("Запрос на получение всех пользователей отправлен в Kafka.");
    }

    @GetMapping("/getUserByBirthDate")
    public ResponseEntity<String> getUserByBirthDate(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate birthDate) {
        sendMessage("/getUserByBirthDate", Map.of("birthDate", birthDate.toString()));
        return ResponseEntity.ok("Запрос на получение пользователей по дате рождения отправлен в Kafka.");
    }

    @GetMapping("/getDepartments")
    public ResponseEntity<String> getDepartments() {
        sendMessage("/getDepartments", "get departments request");
        return ResponseEntity.ok("Запрос на получение всех департаментов отправлен в Kafka.");
    }

    @GetMapping("/getAmountUsersByDepartmentAndMore5")
    public ResponseEntity<String> getAmountUsersByDepartmentAndMore5() {
        sendMessage("/getAmountUsersByDepartmentAndMore5", "get amount of users by department request");
        return ResponseEntity.ok("Запрос на получение количества пользователей по департаментам отправлен в Kafka.");
    }




    public void sendMessage(String urlRequest, Object kafkaMessage){
        Message message = new Message(urlRequest, kafkaMessage);
        kafkaTemplate.send(TOPIC, message);
        writeLog("Sent message to Kafka");


    }



}
