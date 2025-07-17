package org.example.Gift;

public class Chocolate extends Candy{
    String parameter;
    public Chocolate(String name, int weight, double price, String param) {
        super(name, weight, price);
        this.parameter = param;
    }
}
