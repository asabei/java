package Lesson7HW;

import lombok.Data;

@Data
public class SumInt {
    Integer sum;

    public SumInt(Integer sum) {
        this.sum = sum;
    }
}
