package Lesson7HW;

import lombok.Data;

import java.util.List;
import java.util.Map;
@Data
public class TextOrd {
    private List<Map.Entry<String, Long>> data;

    public TextOrd(){};

    public TextOrd(List<Map.Entry<String, Long>> data) {
        this.data = data;
    }
}
