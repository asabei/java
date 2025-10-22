package Lesson7HW;

import java.util.*;
import java.util.stream.Collectors;

public class CharFr {
    public static List countChar(String str){
        List arr = Arrays.stream(str.replaceAll(" ", "").split(""))
                .collect(Collectors.groupingBy(s -> s, Collectors.counting()))
                .entrySet()
                .stream().sorted(Map.Entry.<String, Long>comparingByKey()
                        .thenComparing(Map.Entry.comparingByValue()))
                .toList();
        return arr;
    }
}
