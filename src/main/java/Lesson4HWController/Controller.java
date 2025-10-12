package Lesson4HWController;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;

@RestController
public class Controller {

    @GetMapping("/day-of-week")
    public String dayOfWeek(@RequestParam("date") String date){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate dateOfWeek = LocalDate.parse(date, dateTimeFormatter);
        DayOfWeek dayOfWeekString = dateOfWeek.getDayOfWeek();

        return switch (dayOfWeekString) {
            case MONDAY -> Days.MONDAY.getRussianName();
            case TUESDAY -> Days.TUESDAY.getRussianName();
            case WEDNESDAY -> Days.WEDNESDAY.getRussianName();
            case THURSDAY -> Days.THURSDAY.getRussianName();
            case FRIDAY -> Days.FRIDAY.getRussianName();
            case SATURDAY -> Days.SATURDAY.getRussianName();
            case SUNDAY -> Days.SUNDAY.getRussianName();

        };
    }
    public static int fact(int n) {
        if ( n == 1 )
            return 1;
        int factorial = fact(n-1)*n;
        return factorial;
    }
    public static int power(int number, int exponent) {
        if (exponent == 0)
            return 1;
        return number * power(number, exponent - 1);
    }
    @GetMapping("/factorial")
    public String factorial(@RequestParam("number") String number){
        int factor = Integer.parseInt(number);
        return "Факториал числа " + number + " = " + fact(factor);
    }

    @GetMapping("/power")
    public String power(@RequestParam("number") String number, @RequestParam("power") String power){
        int intNumber = Integer.parseInt(number);
        int intPower = Integer.parseInt(power);
        return number + " в степени " + power + " : " + power(intNumber, intPower);

    }

    @GetMapping("/generate-password")
    public String password(@RequestParam("length") String length){
        int lengthPassword = Integer.parseInt(length);

        return "Случайный пароль " + pass;
    }
}
