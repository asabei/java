package org.example;

import java.util.List;

public class Print {

    public static void print(List list){
        for (int i = 0; i < list.size(); i++) {
            var a = list.get(i);
            System.out.print(a.toString() + '\n');
        }
    }
}
