package Lesson9.Task2;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Triangle triangle1 = new Triangle(2, 3, 5);
        int p1 = (int) triangle1.calculatePerimeter();

        Triangle triangle2 = new Triangle(3, 6, 7);
        int p2 = (int) triangle2.calculatePerimeter();

        Rectangle rectangle1 = new Rectangle(5, 6);
        int p3 = (int) rectangle1.calculatePerimeter();

        Rectangle rectangle2 = new Rectangle(2, 5);
        int p4 = (int) rectangle2.calculatePerimeter();

        Circle circle= new Circle(6);
        double p5 = circle.calculatePerimeter();

        double[] myArray = {p1, p2, p3, p4, p5};
        double totalSum = Arrays.stream(myArray).sum();
        System.out.println(p1 + " + " + p2 + " + " + p3 + " + " + p4 + " + " + p5 + " = " + totalSum);

    }
}
