package Annotation;

import org.springframework.context.ApplicationContext;

import org.springframework.context.support.ClassPathXmlApplicationContext;


public class AnnXMLMain {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("annotationConfig.xml");
        Car car = context.getBean(Car.class);
        System.out.println(car);
    }
}
