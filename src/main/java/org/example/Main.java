package org.example;



import org.example.Gift.Box;
import org.example.Gift.Cake;
import org.example.Gift.Chocolate;

import static org.example.InputPathFile.inputPathFile;
import static org.example.ReadFile.*;

public class Main {
    public static void main(String[] args) {
//        String inputFile = "input.txt";
//
//        while (true){
//            String path = inputPathFile();
//            StringBuffer newString = readFile(path + inputFile);
//            System.out.println(setPerson(newString));
//
//        }

        Box box = new Box();
        box.addCandy(new Chocolate("Snickers", 40, 150, "double"));
        box.addCandy(new Chocolate("Milka", 45, 120, "milk"));
        box.addCandy(new Cake("Brownie", 90, 1150, "brown"));

        box.getAllInfo();
        System.out.println("Общая стоимость: " + box.getPriceBox());
        System.out.println("Общий вес: " + box.getWeightBox());



    }
}