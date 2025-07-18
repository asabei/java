package org.example;



import org.example.Gift.Box;
import org.example.Gift.Cake;
import org.example.Gift.Chocolate;

import java.util.*;
import java.util.stream.Collectors;

import static org.example.InputPathFile.inputPathFile;
import static org.example.Print.print;
import static org.example.ReadFile.*;

public class Main {
    public static void main(String[] args) {
        String path = "src/main/resources/text";
        StringBuffer textFile = readFile(path);
        String str = textFile.toString();
        String[] arr = str.split("[\\s\\p{Punct}]+");
        List<String> strWithoutDidits = Arrays.stream(arr).filter(chars -> !chars.matches("\\d+")).toList();
        List<String> lowerCaseStr = strWithoutDidits.stream()
                .map(chars -> chars.toLowerCase())
                .sorted()
                .toList();
        System.out.println("В алфавитном порядке ");
        print(lowerCaseStr);
        Map<String, Double> wordFrequency = lowerCaseStr.stream()
                .collect(Collectors.groupingBy(
                        word -> word,
                        Collectors.collectingAndThen(
                                Collectors.counting(),
                                count -> (double) count * 100 / lowerCaseStr.size()
                )));
        System.out.println("Статистика ");
        wordFrequency.entrySet().stream()
                .sorted(Map.Entry.<String, Double>comparingByValue())
                .forEach(entry -> System.out.println(entry.getKey() + " : " + entry.getValue().floatValue() + "%"));
        List result = wordFrequency.entrySet().stream()
                .filter(value -> Objects.equals(value.getValue(), Collections.max(wordFrequency.values())))
                .toList();
        System.out.println("Слово " + result);




    }
}