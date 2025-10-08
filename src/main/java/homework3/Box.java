package homework3;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Box implements BoxAction{
    private List<Candy> candys = new ArrayList<>();

    public List<Candy> getCandys() {
        return candys;
    }

    @Override
    public String toString() {
        return "Box{" +
                "candys=" + candys +
                '}';
    }

    @Override
    public void addCandy(Candy candy){
        candys.add(candy);
    };
    @Override
    public void delete(){
        candys.remove(-1);
    }
    @Override
    public double getWeightBox(){
        return candys.stream()
                .mapToDouble(Candy::getWeight)
                .sum();
    }
    @Override
    public double getPriceBox(){
        return candys.stream()
                .mapToDouble(Candy::getPrice)
                .sum();
    };

    @Override
    public void getAllInfo() {
        candys.stream()
                .map(Candy::toString)
                .forEach(System.out::println);
    }

    public void deleteMinWeight(double weight){
        candys.sort(Comparator.comparingDouble(Candy::getWeight));
        while (getWeightBox() > weight) {
            candys.remove(0);
        }
    }
    public void deleteMinPrice(double weight){
        candys.sort(Comparator.comparingDouble(Candy::getPrice));
        while (getWeightBox() > weight) {
            candys.remove(0);
        }
    }

    public List<Candy> findMoreSweet(int minSugarContent){
        return candys.stream()
                .filter(candy -> candy.getSugarContent() >= minSugarContent)
                .toList();

    }

    public List<Candy> sortPrice(){
        return candys.stream()
                .sorted(Comparator.comparingDouble(Candy::getPrice))
                .toList();
    }

    public List<Candy> sortSugarContent(){
        return candys.stream()
                .sorted(Comparator.comparingInt(Candy::getSugarContent))
                .toList();
    }

}
