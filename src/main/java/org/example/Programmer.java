package org.example;

import lombok.Data;

@Data
public class Programmer {
    String name;
    int age;
    boolean isHasTask;
    int tiredness;
    boolean isKnowJawa;

    public Programmer(String name, int age, boolean isHasTask, int tiredness, boolean isKnowJawa) {
        this.name = name;
        this.age = age;
        this.isHasTask = isHasTask;
        this.tiredness = tiredness;
        this.isKnowJawa = isKnowJawa;
    };

    public void goWork() {
        if (isHasTask) {
            System.out.println(this.name + " работате над задачей.");
            this.tiredness += 1;
        } else {
            System.out.println(this.name + " не имеет активных задач и пошел ее получать.");
            getTask();
        }
    };

    public void getTask() {
        this.isHasTask = true;
    };

    public void finishTask() {
        this.isHasTask = false;
    };

    public void goSleep() {
        System.out.println(this.name + " идет спать.");
    };

    public void teachJava(Programmer anotherProgrammer) {
        if (anotherProgrammer.isKnowJawa) {
            System.out.println(anotherProgrammer.name + " уже знает Java.");
        } else if (this.isKnowJawa) {
            anotherProgrammer.isKnowJawa = true;
            System.out.println(this.name + " обучил " + anotherProgrammer.name + " языку Java.");
        } else {
            System.out.println(this.name + " не знает Java и не может обучить " + anotherProgrammer.name + ".");
        }
    }
};