package Lesson7.Apple;

public class Main {
    public static void main(String[] args) {
        Apple apple = new Apple();
        System.out.println("default color of apple is " + apple.getColor());
        apple.setColor("green");
        System.out.println("color of apple after change is " + apple.getColor());
    }
}
