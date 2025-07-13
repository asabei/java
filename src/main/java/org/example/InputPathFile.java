package org.example;

import java.util.Scanner;

public class InputPathFile {
    public static String inputPathFile(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите путь к файлу input.txt: ");
        String fileName = scanner.nextLine();
        return fileName;
    }
}
