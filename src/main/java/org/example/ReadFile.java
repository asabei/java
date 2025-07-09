package org.example;

import java.io.*;
import java.util.Arrays;

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

    public static StringBuffer changeCharacter(StringBuffer stringBuffer){

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

    public static void countCharacter(StringBuffer stringBuffer){

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
}
