package org.example;

import static org.example.ReadFile.*;
import static org.example.WriteFile.writeFile;

public class Main {
    public static void main(String[] args) {
        String path = "src/main/resources/";
        String nameInputFile = "file.txt";
        String nameOutputFile = "output.txt";
        StringBuffer changeChar = changeCharacter(readFile(path + nameInputFile));
        writeFile(changeChar, path + nameOutputFile);
        countCharacter(readFile(path + nameOutputFile));



    }
}