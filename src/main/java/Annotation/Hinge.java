package Annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Hinge {
    private String material = "Standard";
    @Autowired
    public Hinge(@Value("Standart") String material) {
        this.material = material;
    }

    @Override
    public String toString() {
        return "Hinge{material='" + material + "'}";
    }
}
