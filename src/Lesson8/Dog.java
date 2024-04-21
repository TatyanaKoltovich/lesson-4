package Lesson8;

public class Dog extends Animal{

static String name;

    private Dog() {
    }

    static void voiceDog() {
        //super.voice();
        System.out.println("Я собака " + name + ", я умею лаять. ");
    }

    static void eatDog(String food) {
        //super.eat();
        if (food.equalsIgnoreCase("MEAT")) {
            System.out.println("Да, мне нравится " + food + "!");
        } else
            System.out.println("Нет, мне не нравится " + food);
    }
}
