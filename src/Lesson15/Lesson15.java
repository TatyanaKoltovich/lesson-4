package Lesson15;

import java.lang.reflect.Array;
import java.util.*;

public class Lesson15 {
    public static void main(String[] args) {
        //task1();
        //task2();
        task3();
//        task4();
    }

    public static void task1() {
//        Пользователь вводит набор чисел в виде одной строки с клавиатуры. Например: "1, 2, 3,
//        4, 4, 5". Избавиться от повторяющихся элементов в строке. Вывести результат на экран.
//        При решении использовать коллекции
        System.out.println("Введите набор числе с клавиатуры одной строкой через запятую");
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        String[] array = text.split(", ");
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();
        for (int i = 0; i < array.length - 1; i++) {
            boolean add = linkedHashSet.add(array[i]);
        }
        System.out.println(linkedHashSet);
    }

    public static void task2(){
//        Создать класс, который будет хранить в себе коллекцию с названиями животных.
//        Реализовать методы удаления и добавления животных по следующим правилам:
//        добавляется всегда в начало коллекции, а удаляется всегда из конца. Показать работу
//        объекта этого класса в main методе другого класса

        AnimalList animalList = new AnimalList();
        //animalList.getAnimalList();
        System.out.println(animalList);
        System.out.println("Adding elements to our array list");
        animalList.addAnimalName("Tiger");
        System.out.println(animalList.getAnimalList());
        animalList.addAnimalName("Cat");
        System.out.println(animalList.getAnimalList());
        animalList.addAnimalName("Frog");
        System.out.println(animalList.getAnimalList());
        animalList.addAnimalName("Dog");
        System.out.println(animalList.getAnimalList());
        System.out.println("Delete one elemaent");
        animalList.deleteOneAnimal();
        System.out.println(animalList.getAnimalList());
    }

    public static void task3(){
//        Создать класс Student, содержащий следующие характеристики – имя, группа, курс,
//        оценки по предметам. Создать коллекцию, содержащую объекты класса Student.
//        Написать метод, который удаляет студентов со средним баллом <3. Если средний
//        балл>=3, студент переводится на следующий курс. Дополнительно написать метод
//        printStudents(List<Student> students, int course), который получает список студентов и
//        номер курса. А также печатает на консоль имена тех студентов из списка, которые
//        обучаются на данном курсе

        Student student1 = new Student("Петров Иван", "11a", 1);
        Student student2 = new Student("Иванов Станислав", "11a", 1);
        Student student3 = new Student("Котов Роман", "11b", 1);

        student1.addGrade("math", 5);
        student1.addGrade("language", 5);
        student1.addGrade("physics", 5);
        student1.addGrade("chemistry", 5);
        student1.addGrade("psychology", 5);

        student2.addGrade("math", 4);
        student2.addGrade("language", 4);
        student2.addGrade("physics", 4);
        student2.addGrade("chemistry", 3);
        student2.addGrade("psychology", 4);

        student3.addGrade("math", 2);
        student3.addGrade("language", 3);
        student3.addGrade("physics", 2);
        student3.addGrade("chemistry", 3);
        student3.addGrade("psychology", 2);

        List<Student> studentArrayList = new ArrayList<>();
        studentArrayList.add(student1);
        studentArrayList.add(student2);
        studentArrayList.add(student3);

        System.out.println("Список студентов: ");
        System.out.println(studentArrayList);

        System.out.println("Расчет средней оценки и перевод на следующий курс.....");
        for (int i = 0; i < studentArrayList.size(); i++) {
            float averageGrade = studentArrayList.get(i).calculateAverageGrade(studentArrayList.get(i));
            if (averageGrade >= (float) 3) {
                studentArrayList.get(i).tranferToNextCourse(studentArrayList.get(i));
            } else {
                studentArrayList.remove(studentArrayList.get(i));
            }
        }
        System.out.println("Введите номер курса для формирования списка студентов");
        Scanner scanner = new Scanner(System.in);
        int numberCourse = scanner.nextInt();
        printStudents(studentArrayList, numberCourse);
    }

    public static void printStudents(List<Student> studentArrayList, int numberCourse) {
        ArrayList<Student> listToPrint = new ArrayList<>();
        for (int i = 0; i < studentArrayList.size(); i++) {
            int a = 1;
            if (studentArrayList.get(i).getCourse() == numberCourse) {
                listToPrint.add(studentArrayList.get(i));
            }
        }
        MyList<Student> studentsMyList = new MyList<>(listToPrint);
        //studentsMyList.printList();
        studentsMyList.printListOnlyNames();
    }

    public static void task4() {
//        Представим, что в Java нет коллекции типа ArrayList. Создать свой класс, симулирующий
//        работу класса динамической коллекции - т.е. создать свою кастомную коллекцию. В
//        основе коллекции будет массив. Кастомная коллекция должна хранить элементы разных
//        классов(т.е. это generic)

    }
}
