package Annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Wheel {
    private String type;
    @Autowired
    public Wheel(@Value("Standard")String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Wheel{type='" + type + "'}";
    }
}
