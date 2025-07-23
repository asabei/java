package Annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Starter {
    private String model = "Standard";
    @Autowired
    public Starter(@Value("Standart") String model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return "Starter{model='" + model + "'}";
    }

}
