package org.example;



import org.example.Gift.Box;
import org.example.Gift.Cake;
import org.example.Gift.Chocolate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.example.InputPathFile.inputPathFile;
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
        System.out.println("В алфавитном порядке " + lowerCaseStr);
        Map<String, Long> wordFrequency = lowerCaseStr.stream()
                .collect(Collectors.groupingBy(
                        word -> word,
                        Collectors.counting()
                ));
        System.out.println("Статистика " + wordFrequency);
        List result = wordFrequency.entrySet().stream()
                .filter(value -> value.getValue() == Collections.max(wordFrequency.values()))
                .toList();
        System.out.println("Слово " + result);




    }
}