package Lesson9.Task2;

public class Circle extends Figure{
    int radius;

    public Circle(int radius) {
        this.radius = radius;
    }
    @Override
    double calculatePerimeter() {
        return 2 * Math.PI * this.radius;
    }
}
