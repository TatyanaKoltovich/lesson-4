package Lesson9.Task2;

public class Rectangle extends Figure{
    int side1;
    int side2;

    public Rectangle(int side1, int side2) {
        this.side1 = side1;
        this.side2 = side2;
    }
    @Override
    double calculatePerimeter() {
      return 2 * (this.side1 + this.side2);
    }
}
