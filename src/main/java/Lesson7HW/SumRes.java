package Lesson7HW;

import lombok.Data;

@Data
public class SumRes {
    int sum;

    public SumRes(int sum) {
        this.sum = sum;
    }
}
