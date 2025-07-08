package org.example;

import java.io.*;

public class ReadFile {

    public static StringBuffer readFile(String path) {
        StringBuffer inputString = new StringBuffer();
        try {
            BufferedReader inputLine = new BufferedReader(new FileReader(path));
            String line;
            while ((line = inputLine.readLine()) != null) {
                inputString.append(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return inputString;
    }

    public static StringBuffer changeCharacter(StringBuffer stringBuffer){

        String vowels = "аеёиоуыэюяАЕЁИОУЫЭЮЯ";
        for (int i = 0; i < stringBuffer.length(); i++) {
            char stringChar = stringBuffer.charAt(i);
            if (vowels.indexOf(stringChar) != -1){
                stringBuffer.setCharAt(i, 'а');
            } else {
                if (vowels.indexOf(stringChar) == -1 && Character.isLetter(stringChar)) {
                    stringBuffer.setCharAt(i, 'м');
                }
            }
        }
        return stringBuffer;
    }

    public static void countCharacter(StringBuffer stringBuffer){

        String vowels = "аеёиоуыэюяАЕЁИОУЫЭЮЯ";
        int a = 0;
        int b = 0;
        for (int i = 0; i < stringBuffer.length(); i++) {
            char stringChar = stringBuffer.charAt(i);
            if (vowels.indexOf(stringChar) != -1){
                a++;
            } else {
                if (vowels.indexOf(stringChar) == -1 && Character.isLetter(stringChar)) {
                    b++;
                }
            }
        }
        System.out.println("Гласных " + a);
        System.out.println("Согласных " + b);
    }
}
