package homework3;

import java.util.Scanner;

public class InputChoise {
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
