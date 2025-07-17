package org.example.Gift;

public abstract class Candy {
    String name;
    double weight;
    double price;


    public Candy(String name, int weight, double price) {
        this.name = name;
        this.weight = weight;
        this.price = price;

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





    public String getInfo() {
        return "Candy{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                ", price=" + price +
                '}';
    }

}
