package Controller;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

@SpringBootApplication
@RestController
@RequestMapping("/app/v1")
public class MainController {

    @GetMapping("/getRequest")
    public ResponseEntity<String> getRequest(
            @RequestParam int id,
            @RequestParam String name) throws InterruptedException {


        if (id <= 10) {
            System.err.println("Ошибка: id должен быть больше 10");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

        if (name == null || name.length() <= 5) {
            System.err.println("Ошибка: длина name должна быть больше 5");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }


        if (id > 10 && id < 50) {
            TimeUnit.MILLISECONDS.sleep(1000);
        } else {
            TimeUnit.MILLISECONDS.sleep(500);
        }

        try {
            String content = new String(Files.readAllBytes(Paths.get("getAnswer.txt")));
            content = content.replace("{name}", name);
            return ResponseEntity.ok(content);
        } catch (IOException e) {
            System.err.println("Ошибка answer" + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/postRequest")
    public ResponseEntity<String> postRequest(@RequestBody UserRequest userRequest) {

        if (!StringUtils.hasText(userRequest.getName()) ||
                !StringUtils.hasText(userRequest.getSurname()) ||
                userRequest.getAge() == null) {

            System.err.println("Ошибка: не все поля");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }


        try {
            String content = new String(Files.readAllBytes(Paths.get("postAnswer.txt")));
            content = content.replace("{name}", userRequest.getName())
                    .replace("{surname}", userRequest.getSurname())
                    .replace("{age}", userRequest.getAge().toString());
            return ResponseEntity.ok(content);
        } catch (IOException e) {
            System.err.println("Ошибка " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


}