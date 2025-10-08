package homework3;

import java.util.List;

public interface BoxAction {
    void addCandy(Candy candy);
    void delete();
    double getWeightBox();
    double getPriceBox();
    void getAllInfo();
    List<Candy>  findMoreSweet(int minSugarContent);
    List<Candy> sortPrice();
    List<Candy> sortSugarContent();
}
