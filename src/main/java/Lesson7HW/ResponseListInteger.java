package Lesson7HW;

import lombok.Data;

import java.util.List;
@Data
public class ResponseListInteger {
    List<Integer> sortedNumbers;

    public ResponseListInteger(List<Integer> sortedNumbers) {
        this.sortedNumbers = sortedNumbers;
    }
}
