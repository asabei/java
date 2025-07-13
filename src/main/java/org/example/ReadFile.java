package org.example;

import org.example.pojo.Person;

import java.io.*;
import java.sql.Array;
import java.util.*;

public class ReadFile {

    public static StringBuffer readFile(String path) {
        StringBuffer inputString = new StringBuffer();
        try {
            BufferedReader inputLine = new BufferedReader(new FileReader(path));
            String line;
            while ((line = inputLine.readLine()) != null) {
                inputString.append(line + "\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return inputString;
    }

    public static StringBuffer changeCharacter(StringBuffer stringBuffer) {

        String vowels = "аеёиоуыэюяАЕЁИОУЫЭЮЯ";
        String noVowels = "бвгджзйклмнпрстфхцчшщБВГДЖЗЙКЛМНПРСТФХЦЧШЩ";
        for (int i = 0; i < stringBuffer.length(); i++) {
            char c = stringBuffer.charAt(i);
            if (vowels.indexOf(c) != -1) {
                stringBuffer.setCharAt(i, 'а');
            } else if (noVowels.indexOf(c) != -1) {
                stringBuffer.setCharAt(i, 'м');
            }
        }
        return stringBuffer;
    }

    public static void countCharacter(StringBuffer stringBuffer) {

        String vowels = "аеёиоуыэюяАЕЁИОУЫЭЮЯ";
        String noVowels = "бвгджзйклмнпрстфхцчшщБВГДЖЗЙКЛМНПРСТФХЦЧШЩ";
        int a = 0;
        int b = 0;
        for (int i = 0; i < stringBuffer.length(); i++) {
            char c = stringBuffer.charAt(i);
            if (vowels.indexOf(c) != -1) {
                a++;
            } else if (noVowels.indexOf(c) != -1) {
                b++;
            }
        }
        System.out.println("Гласных " + a);
        System.out.println("Согласных " + b);


    }

    public static Person setPerson(StringBuffer stringBuffer) {
        Person person = new Person();
        String string = stringBuffer.toString();
        for (String part : string.split(",")) {
            String[] keyValue = part.split("=");
            if (keyValue.length >= 2) {
                String key = keyValue[0].trim();
                String value = keyValue[1].trim();

                switch (key) {
                    case "name":
                        person.setName(value);
                        break;
                    case "surname":
                        person.setSurname(value);
                        break;
                    case "age":
                        person.setAge(Integer.parseInt(value));
                        break;
                }


            }
        }
        return person;
    }
}