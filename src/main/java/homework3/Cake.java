package homework3;

public class Cake extends Candy {
    String parameter;
    public Cake(String name, int weight, double price, int sugarContent, String param) {
        super(name, weight, price, sugarContent);
        this.parameter = param;
    }
}
