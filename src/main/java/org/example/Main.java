package org.example;



import org.example.Gift.Box;
import org.example.Gift.Cake;
import org.example.Gift.Chocolate;

import static org.example.InputPathFile.inputPathFile;
import static org.example.ReadFile.*;

public class Main {
    public static void main(String[] args) {


        Box box = new Box();
        box.addCandy(new Chocolate("Snickers", 40, 150, "double"));
        box.addCandy(new Chocolate("Milka", 45, 120, "milk"));
        box.addCandy(new Cake("Brownie", 90, 1150, "brown"));

        box.getAllInfo();
        System.out.println("Общая стоимость: " + box.getPriceBox());
        System.out.println("Общий вес: " + box.getWeightBox());

        InputPathFile inputPathFile = new InputPathFile();
        int optimizationParam = 0;

        System.out.println("Введите число 1- выбор оптимизиции по весу, 2 - выбор оптимизации по цене ");
        while (true) {
            int optimization = inputPathFile.inputChoiceOptimization();
            if (optimization == 1 || optimization == 2) {
                System.out.println("Спасибо! Вы ввели: " + optimization);
                optimizationParam = optimization;
                break;
            } else {
                System.out.println("Ошибка: введите только 1 или 2");
            }
        }
        System.out.println("Введите вес для оптимизации коробки");
        int optimizationWeight = inputPathFile.inputChoiceOptimization();
        if (optimizationParam == 1) {
            box.deleteMinWeight(optimizationWeight);
        } else {
            box.deleteMinPrice(optimizationWeight);
        }
        System.out.println("\nПосле оптимизации:");
        box.getAllInfo();
        System.out.println("Общая стоимость: " + box.getPriceBox());
        System.out.println("Общий вес: " + box.getWeightBox());

    }
}