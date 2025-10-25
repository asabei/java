package Lesson7HW;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class main7HW {
    public static void main(String[] args) {
        //LogerService.writeLog("Событие", "wedddddd");
        System.out.println(LogerService.readLog());
        SpringApplication.run(main7HW.class, args);
    }
}
