package org.example;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.Random;

@RestController
public class Lesson2HWController {

    @GetMapping("/current-datetime")
    public String currentTime(){
        LocalDateTime curTime = LocalDateTime.now();
        return "Текущее время " + curTime;
    }

    @GetMapping("/current-season")
    public String currentSeason(){
        int currentMonth = LocalDateTime.now().getMonthValue();
        return switch (currentMonth) {
            case 12, 1, 2 -> Seasons.WINTER.getRussianName();
            case 3, 4, 5 -> Seasons.SPRING.getRussianName();
            case 6, 7, 8 -> Seasons.SUMMER.getRussianName();
            case 9, 10, 11 -> Seasons.AUTUMN.getRussianName();

            default -> throw new IllegalStateException("Unexpected value: " + currentMonth);
        };
    }

    @GetMapping("/future-date")
    public String futureDate() {
        Random random = new Random();
        LocalDate curDate = LocalDate.now();
        int randDay = random.nextInt(30) + 1;
        Period period = Period.ofDays(randDay);
        LocalDate newDate = curDate.plus(period);
        return "Случайная дата в будущем " + newDate;
    };
}
