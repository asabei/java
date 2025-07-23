package Annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Accumulator {
    private int capacity;
    private String type;
    @Autowired
    public Accumulator(@Value("60") int capacity, @Value("Standart") String type) {
        this.capacity = capacity;
        this.type = type;
    }

    @Override
    public String toString() {
        return "Accumulator{capacity=" + capacity + ", type='" + type + "'}";
    }
}