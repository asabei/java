package org.example.pojo;

import lombok.Data;

@Data
public class Person {
    private String name;
    private String surname;
    private int age;

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setAge(int age) {
        this.age = age;
    }
    @Override
    public String toString() {
        return "{\n" +
                "  \"name\": \"" + name + "\",\n" +
                "  \"surname\": \"" + surname + "\",\n" +
                "  \"age\": " + age + "\n" +
                "}";
    }
}
