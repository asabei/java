package Lesson7HW;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ResponseDate {
    LocalDate randomDate;

    public ResponseDate(LocalDate randomDate) {
        this.randomDate = randomDate;
    }
}
