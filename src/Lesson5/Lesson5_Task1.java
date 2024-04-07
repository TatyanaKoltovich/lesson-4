package Lesson5;

import java.util.Scanner;

public class Lesson5_Task1 {
    public static void main(String[] args) {
//        Задача 1:
//        1.1 Создать двумерный массив, заполнить его случайными числами.
//        1.2 Добавить к каждому значению число, которое пользователь будет вводить с консоли.
//        1.3 Найти сумму всех получившихся элементов и вывести в консоль

        System.out.println("Введите число, на которое будет увеличен каждый элемент массива");
        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();

        int a = 2;
        int b = 3;
        int s = 0;
        int[][] myArray = new int[a][b];

        System.out.println("Исходный массив: ");
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                myArray[i][j] = (int) (Math.random() * 20);
                System.out.print(myArray[i][j] + " ");
            }
            System.out.println(" ");
        }
        System.out.println("Измененный массив: ");
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                myArray[i][j] = myArray[i][j] + k;

                System.out.print(myArray[i][j] + " ");
                s = s + myArray[i][j];
            }
            System.out.println(" ");
        }
        System.out.println("Сумма всех элементов измененного массива равна " + s);
    }
}
