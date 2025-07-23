package Annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Differential {
    private String type = "Standard";
    @Autowired
    public Differential(@Value("Standart") String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Differential{type='" + type + "'}";
    }
}
