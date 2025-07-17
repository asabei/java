package org.example.Gift;

public class Cake extends Candy {
    String parameter;
    public Cake(String name, int weight, double price, String param) {
        super(name, weight, price);
        this.parameter = param;
    }
}
