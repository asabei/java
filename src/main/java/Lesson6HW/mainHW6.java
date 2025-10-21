package Lesson6HW;

import java.util.*;
import java.util.stream.Collectors;

public class mainHW6 {
    public static void main(String[] args) {
        String file = "src/main/java/Lesson6HW/file.txt";
        ArrayList<Person> filetxt = ReadFile.readFile(file);
        Map avgGr = filetxt.stream()
                .collect(Collectors.groupingBy(Person::getFamily, Collectors.averagingDouble(Person::getRes)));
        System.out.println("средний бал у студентов " + avgGr);

        Optional<Map.Entry<String, Double>> maxEntry = avgGr.entrySet()
                .stream()
                .max(Map.Entry.comparingByValue());

        List avgGr1 = filetxt.stream()
                .collect(Collectors.groupingBy(Person::getFamily, Collectors.averagingDouble(Person::getRes)))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() >= maxEntry.get().getValue())
                .toList();

        System.out.println("лучший студент " + avgGr1);

        Map avgLes = filetxt.stream()
                .collect(Collectors.groupingBy(Person::getLesson, Collectors.averagingDouble(Person::getRes)));

        Optional<Map.Entry<String, Double>> minEntry = avgLes.entrySet()
                .stream()
                .min(Map.Entry.comparingByValue());

        List avgLes1 = filetxt.stream()
                .collect(Collectors.groupingBy(Person::getLesson, Collectors.averagingDouble(Person::getRes)))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() <= minEntry.get().getValue())
                .toList();

        System.out.println("самый сложный предмет " + avgLes1);

        List distLes = filetxt.stream()
                .map(les -> les.getLesson())
                .distinct()
                .toList();
        System.out.println("уникальные предметы " + distLes);

        Map avgGr5 = filetxt.stream()
                .collect(Collectors.groupingBy(Person::getFamily, Collectors.averagingDouble(Person::getRes)))
                .entrySet().stream()
                .filter(entry -> entry.getValue() >= 4.50)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        System.out.println("отличники " + avgGr5);

        Map avgGr3 = filetxt.stream()
                .collect(Collectors.groupingBy(Person::getFamily, Collectors.averagingDouble(Person::getRes)))
                .entrySet().stream()
                .filter(entry -> entry.getValue() < 3.00)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        System.out.println("двоечники " + avgGr3);

        List avgGrAll = avgGr.entrySet().stream()
                .sorted(Map.Entry.comparingByValue().reversed())
                .toList();
        System.out.println("рейтинг " + avgGrAll);

    }
}
