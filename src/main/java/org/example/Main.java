package org.example;



import static org.example.InputPathFile.inputPathFile;
import static org.example.ReadFile.*;

public class Main {
    public static void main(String[] args) {
        String inputFile = "input.txt";

        while (true){
            String path = inputPathFile();
            StringBuffer newString = readFile(path + inputFile);
            System.out.println(setPerson(newString));

        }




    }
}