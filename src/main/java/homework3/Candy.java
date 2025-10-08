package homework3;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Data
@AllArgsConstructor
public abstract class Candy {
    String name;
    double weight;
    double price;
    int sugarContent;



//    public Candy(String name, int weight, double price, double sugarContent) {
//        this.name = name;
//        this.weight = weight;
//        this.price = price;
//        this.sugarContent = sugarContent;
//
//    }
}