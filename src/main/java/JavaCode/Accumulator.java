package JavaCode;

public class Accumulator {
    private int capacity;
    private String type;

    public Accumulator(int capacity, String type) {
        this.capacity = capacity;
        this.type = type;
    }

    @Override
    public String toString() {
        return "Accumulator{capacity=" + capacity + ", type='" + type + "'}";
    }
}