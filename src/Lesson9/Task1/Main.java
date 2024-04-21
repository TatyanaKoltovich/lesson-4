package Lesson9.Task1;

public class Main {
    public static void main(String[] args) {
        Director director = new Director();
        director.printInfo();

        Worker worker = new Worker();
        worker.printInfo();

        Accountant accountant = new Accountant();
        accountant.printInfo();
    }
}
