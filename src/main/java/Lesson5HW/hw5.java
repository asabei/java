package Lesson5HW;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class hw5 {
    private static final int INITIAL_SIZE = 1_000_000;
    private static final int OPERATIONS_COUNT = 500_000;

    public static void main(String[] args) {

        List<Integer> arrayList = new ArrayList<>();
        initList(arrayList, INITIAL_SIZE);

        long time1 = System.currentTimeMillis();
        addInMiddle(arrayList, OPERATIONS_COUNT);
        long time2 = System.currentTimeMillis();
        getFromMiddle(arrayList, OPERATIONS_COUNT);
        long time3 = System.currentTimeMillis();
        removeFromMiddle(arrayList, OPERATIONS_COUNT);
        long time4 = System.currentTimeMillis();

        System.out.println("ArrayList results:");
        System.out.println("Add: " + (time2 - time1) + " ms");
        System.out.println("Get: " + (time3 - time2) + " ms");
        System.out.println("Remove: " + (time4 - time3) + " ms\n");

        List<Integer> linkedList = new LinkedList<>();
        initList(linkedList, INITIAL_SIZE);

        time1 = System.currentTimeMillis();
        addInMiddle(linkedList, OPERATIONS_COUNT);
        time2 = System.currentTimeMillis();
        getFromMiddle(linkedList, OPERATIONS_COUNT);
        time3 = System.currentTimeMillis();
        removeFromMiddle(linkedList, OPERATIONS_COUNT);
        time4 = System.currentTimeMillis();

        System.out.println("LinkedList results:");
        System.out.println("Add: " + (time2 - time1) + " ms");
        System.out.println("Get: " + (time3 - time2) + " ms");
        System.out.println("Remove: " + (time4 - time3) + " ms");
    }

    private static void initList(List<Integer> list, int count) {
        for (int i = 0; i < count; i++) {
            list.add(i);
        }
    }

    private static void addInMiddle(List<Integer> list, int count) {
        for (int i = 0; i < count; i++) {
            list.add(list.size() / 2, i);
        }
    }

    private static void getFromMiddle(List<Integer> list, int count) {
        for (int i = 0; i < count; i++) {
            list.get(list.size() / 2);
        }
    }

    private static void removeFromMiddle(List<Integer> list, int count) {
        for (int i = 0; i < count; i++) {
            list.remove(list.size() / 2);
        }
    }

    /*
1. Добавление элементов в середину
ArrayList быстрее в 19 раз (25 071 мс vs 474 980 мс)
LinkedList последовательный обхода до середины списка для каждой вставки
2. Получение элемента из середины
ArrayList быстрее в 192 108 раз (3 мс vs 576 324 мс)
ArrayList - прямой доступ по индексу
LinkedList - последовательный обход
3. Удаление элемента из середины
ArrayList быстрее в 20 раз (24 877 мс vs 487 938 мс)
ArrayList - копирование блоков памяти
LinkedList - сдвиг элементов


     */


}
