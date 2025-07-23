package Annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SparkPlug {
    private String type = "Standard";
    @Autowired
    public SparkPlug(@Value("Standart") String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "SparkPlug{type='" + type + "'}";
    }
}
