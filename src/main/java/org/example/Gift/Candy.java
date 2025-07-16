package org.example.Gift;

public abstract class Candy {
    String name;
    double weight;
    double price;
    String param;

    public Candy(String name, int weight, double price, String param) {
        this.name = name;
        this.weight = weight;
        this.price = price;
        this.param = param;
    }

    public String getName() {
        return name;
    }


    public double getWeight() {
        return weight;
    }


    public double getPrice() {
        return price;
    }


    public String getParam() {
        return param;
    }


    public String getInfo() {
        return "Candy{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                ", price=" + price +
                ", param='" + param + '\'' +
                '}';
    }

}
