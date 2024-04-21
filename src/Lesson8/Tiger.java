package Lesson8;

public class Tiger extends Animal{
    public Tiger(String name) {
        this.name = name;
    }
    @Override
    public void voice() {
        //super.voice();
        System.out.println("Я тигр " + this.name + ". Я умею рычать. ");
    }

    @Override
    public void eat(String food) {
        if (food.equalsIgnoreCase("MEAT")) {
            System.out.println("Да, мне нравится " + food + "!");
        } else
            System.out.println("Нет, мне не нравится " + food);
    }
}
