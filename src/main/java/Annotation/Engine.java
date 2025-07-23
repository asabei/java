package Annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Engine {
    private Starter starter;
    private SparkPlug sparkPlug;
    private int power;
    @Autowired
    public Engine(Starter starter, SparkPlug sparkPlug, @Value("150") int power) {
        this.starter = starter;
        this.sparkPlug = sparkPlug;
        this.power = power;
    }

    @Override
    public String toString() {
        return "Engine{starter=" + starter + ", sparkPlug=" + sparkPlug + ", power=" + power + "}";
    }
}
