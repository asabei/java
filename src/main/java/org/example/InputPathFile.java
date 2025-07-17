package org.example;

import java.util.Scanner;

public class InputPathFile {
    public static String inputPathFile(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите путь к файлу input.txt: ");
        String fileName = scanner.nextLine();
        return fileName;
    }

    public int inputChoiceOptimization() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.print("Введите целое число ");
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: введите целое число ");
            }
        }
    }

}
