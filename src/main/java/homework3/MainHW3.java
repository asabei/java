package homework3;

public class MainHW3 {
    public static void main(String[] args) {
        Box box = new Box();
        box.addCandy(new Chocolate("Snickers", 40, 150, 54,"double"));
        box.addCandy(new Chocolate("Milka", 45, 120, 73, "milk"));
        box.addCandy(new Cake("Brownie", 90, 1150, 25,"brown"));

        box.getAllInfo();
        System.out.println("Общая стоимость: " + box.getPriceBox());
        System.out.println("Общий вес: " + box.getWeightBox());
        System.out.println("Отсортированные по цене: " + box.sortPrice());
        System.out.println("Отсортированные по проценту сахара: " + box.sortSugarContent());

        InputChoise inputChoise = new InputChoise();
        System.out.println("Введите минимальное содержание сахара");
        int minSugarContent = inputChoise.inputChoiceOptimization();
        System.out.println(box.findMoreSweet(minSugarContent));
        int optimizationParam = 0;

        System.out.println("Введите число 1- выбор оптимизиции по весу, 2 - выбор оптимизации по цене ");
        while (true) {
            int optimization = inputChoise.inputChoiceOptimization();
            if (optimization == 1 || optimization == 2) {
                System.out.println("Спасибо! Вы ввели: " + optimization);
                optimizationParam = optimization;
                break;
            } else {
                System.out.println("Ошибка: введите только 1 или 2");
            }
        }
        System.out.println("Введите вес для оптимизации коробки");
        int optimizationWeight = inputChoise.inputChoiceOptimization();
        if (optimizationParam == 1) {
            box.deleteMinWeight(optimizationWeight);
        } else {
            box.deleteMinPrice(optimizationWeight);
        }
        System.out.println("\nПосле оптимизации:");
        box.getAllInfo();
        System.out.println("Общая стоимость: " + box.getPriceBox());
        System.out.println("Общий вес: " + box.getWeightBox());


    }



}
