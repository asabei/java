package XML;

public class Engine {
    private Starter starter;
    private SparkPlug sparkPlug;
    private int power;

    public Engine(Starter starter, SparkPlug sparkPlug, int power) {
        this.starter = starter;
        this.sparkPlug = sparkPlug;
        this.power = power;
    }

    @Override
    public String toString() {
        return "Engine{starter=" + starter + ", sparkPlug=" + sparkPlug + ", power=" + power + "}";
    }
}
