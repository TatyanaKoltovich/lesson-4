package Lesson9.Task2;

public class Triangle extends Figure{
    int side1;
    int side2;
    int side3;
    public Triangle(int side1, int side2, int side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    @Override
    double calculatePerimeter() {
        return this.side1 + this.side2 + this.side3;
    }
}
