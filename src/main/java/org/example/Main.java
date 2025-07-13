package org.example;

import org.example.pojo.Person;

import static org.example.InputPathFile.inputPathFile;
import static org.example.ReadFile.*;

public class Main {
    public static void main(String[] args) {
        //String path = "src/main/resources/";
        String nameInputFile = "file.txt";
        String nameOutputFile = "output.txt";
        String inputFile = "input.txt";


//        StringBuffer changeChar = changeCharacter(readFile(path + nameInputFile));
//        writeFile(changeChar, path + nameOutputFile);
//        countCharacter(readFile(path + nameOutputFile));
        while (true){
            String path = inputPathFile();
            StringBuffer newString = readFile(path + inputFile);
            System.out.println(setPerson(newString));

        }




    }
}