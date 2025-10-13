package Lesson4HWController;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import java.time.temporal.ChronoUnit;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

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
    public String factorial(@RequestParam("number") String number) {
        try {
            int factor = Integer.parseInt(number);
            return "Факториал числа " + number + " = " + fact(factor);
        } catch (Exception e) {
            return "Ошибка в factorial: " + e.getMessage();
        }
    }

    @GetMapping("/power")
    public String power(@RequestParam("number") String number, @RequestParam("power") String power) {
        try {
            int intNumber = Integer.parseInt(number);
            int intPower = Integer.parseInt(power);
            return number + " в степени " + power + " : " + power(intNumber, intPower);
        } catch (Exception e) {
            return "Ошибка в power: " + e.getMessage();
        }
    }

    @GetMapping("/generate-password")
    public String password(@RequestParam("length") String length){
        try {
            int len = Integer.parseInt(length);
            String symbols = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%";
            Random rnd = new Random();
            StringBuilder pwd = new StringBuilder();

            for (int i = 0; i < len; i++) {
                pwd.append(symbols.charAt(rnd.nextInt(symbols.length())));
            }
            return pwd.toString();
        } catch (Exception e) {
            return "Ошибка в pass: " + e.getMessage();
        }
    }

    @GetMapping("/random-date")
    public String randDate(@RequestParam("startdate") String startDate, @RequestParam("enddate") String endDate) {
        try {
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate newStartDate = LocalDate.parse(startDate, dateFormatter);
            LocalDate newEndDate = LocalDate.parse(endDate, dateFormatter);

            Random random = new Random();
            long daysBetween = ChronoUnit.DAYS.between(newStartDate, newEndDate);
            long randomDays = random.nextLong(daysBetween + 1);

            return newStartDate.plusDays(randomDays).toString();
        } catch (Exception e) {
            return "Ошибка в randDate: " + e.getMessage();
        }
    }

    @GetMapping("/sort-array")
    public String sortArray(@RequestParam("numbers") List<Integer> numbers, @RequestParam("isAsc") boolean isAsc){
        try {
            return (isAsc) ? numbers.stream()
                    .sorted(Comparator.naturalOrder())
                    .toList().toString() : numbers.stream()
                    .sorted(Comparator.reverseOrder())
                    .toList().toString();
        } catch (Exception e) {
            return "Ошибка в sortArray: " + e.getMessage();
        }
    }

    @GetMapping("/substring")
    public String subString(@RequestParam("str") String str, @RequestParam("position") String position, @RequestParam("isFirst") boolean isFirst){
        try {
            int pos = Integer.parseInt(position);
            StringBuilder stringBuilder = new StringBuilder(str);
            return (isFirst) ? stringBuilder.substring(0, pos) : stringBuilder.substring(pos);
        } catch (Exception e) {
            return "Ошибка в subString: " + e.getMessage();
        }
    }

}
