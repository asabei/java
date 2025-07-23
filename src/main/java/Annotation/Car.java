package Annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Car {
    private Wheel wheel;
    private Engine engine;
    private Accumulator accumulator;
    private Suspension suspension;
    @Autowired
    public Car(Wheel wheel, Engine engine, Accumulator accumulator, Suspension suspension) {
        this.wheel = wheel;
        this.engine = engine;
        this.accumulator = accumulator;
        this.suspension = suspension;
    }

    @Override
    public String toString() {
        return "Car{\n" +
                "  wheel=" + wheel + ",\n" +
                "  engine=" + engine + ",\n" +
                "  accumulator=" + accumulator + ",\n" +
                "  suspension=" + suspension + "\n" +
                "}";
    }
}
