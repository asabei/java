package Lesson6HW;

import lombok.Data;

@Data
public class Person {
    String family;
    String lesson;
    int res;

    public Person(String family, String lesson, int res) {
        this.family = family;
        this.lesson = lesson;
        this.res = res;
    }
}
