package JavaCode;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class AppConfig {

    @Bean
    public Wheel wheel() {
        return new Wheel("Standart");
    }

    @Bean
    public Starter starter() {
        return new Starter("Standart");
    }

    @Bean
    public SparkPlug sparkPlug() {
        return new SparkPlug("Standart");
    }

    @Bean
    public Engine engine() {
        return new Engine(starter(), sparkPlug(), 150);
    }

    @Bean
    public Accumulator accumulator() {
        return new Accumulator(60, "Standart");
    }

    @Bean
    public Hinge hinge() {
        return new Hinge("Standart");
    }

    @Bean
    public Differential differential() {
        return new Differential("Standart");
    }

    @Bean
    public Suspension suspension() {
        return new Suspension(hinge(), differential());
    }

    @Bean
    public Car car() {
        return new Car(wheel(), engine(), accumulator(), suspension());
    }
}


