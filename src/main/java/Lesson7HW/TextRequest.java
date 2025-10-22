package Lesson7HW;

import lombok.Data;

@Data
public class TextRequest {
    String text;

    public TextRequest() {}

    public TextRequest(String text) {
        this.text = text;
    }
}
