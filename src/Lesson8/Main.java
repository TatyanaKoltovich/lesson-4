package Lesson8;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

//        Dog dog = new Dog("Mia");
//        dog.voice();
//        String dogName = Dog.class.getField("name");
//        dogName = "Mia";
        Dog.name = "Mia";
        Dog.voiceDog();
        System.out.println("Угадай, какую еду любит собака?");
        String food = scanner.nextLine();
        Dog.eatDog(food);

        Rabbit rabbit = new Rabbit("Ricardo");
        rabbit.voice();
        System.out.println("Угадай, какую еду любит кролик?");
        String food1 = scanner.nextLine();
        rabbit.eat(food1);

        Tiger tiger = new Tiger("Tigra");
        tiger.voice();
        System.out.println("Угадай, какую еду любит тигр?");
        String food2 = scanner.nextLine();
        tiger.eat(food2);



    }
}
