package Lesson8;

public class Rabbit extends Animal {
    public Rabbit(String name) {
        this.name = name;
    }

    @Override
    public void voice() {
        //super.voice();
        System.out.println("Я кролик " + this.name + ", обычно я не разговариваю.");
    }

    @Override
    public void eat(String food) {
        //super.eat();
        switch (food.toUpperCase()) {
            case "GRASS" -> System.out.println("Да, мне нравится " + food + "!");
            case "CARROT"-> System.out.println("Да, мне нравится " + food + "!");

            default -> System.out.println("Нет, мне не нравится " + food);
        }
    }
}