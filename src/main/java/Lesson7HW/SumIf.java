package Lesson7HW;

import lombok.Data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class SumIf {
    Integer[] numbers;;
    Boolean[] conditions;

    public SumIf(){};

    public static Map<Integer, Boolean> createMap(Integer[] num, Boolean[] cond){
        Map<Integer, Boolean> map = new HashMap<>();
        for (int i = 0; i < num.length; i++) {
            map.put(num[i], cond[i]);
        }
        return map;


    }


}
