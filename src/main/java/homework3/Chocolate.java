package homework3;

public class Chocolate extends Candy{
    String parameter;
    public Chocolate(String name, int weight, double price, int sugarContent, String param) {
        super(name, weight, price, sugarContent);
        this.parameter = param;
    }
}