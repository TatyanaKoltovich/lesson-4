package Lesson4;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Lesson4_Task1_Random {
    public static void main(String[] args) {

//        Для всех задач исходные условия следующие: пользователь с клавиатуры вводит размер
//        массива (просто целое число). После того, как размер массива задан, заполнить его,
//        используя Math.random().
//        Пройти по массиву, вывести все элементы в прямом и в обратном порядке.

        System.out.println("Введите количество элементов массива");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println("Количество элементов массива равно " + n);
        System.out.println("Элементы массива будут заданы случайным образом...");

        int[] myArray;
        myArray = new int[n];
        int[] myArrayTemp;
        myArrayTemp = new int[n];

        int imax = 0;
        int imin = 0;
        int count_0 = 0;

        boolean incs = true;
        String incs_comment = "";

        for (int i = 0; i < n; i++) {
            myArray[i] = (int) (Math.random() * 10);
        }
        System.out.print("Массив из " + n + " элементов в прямом порядке: ");
        for (int i = 0; i < n; i++) {
            System.out.print(myArray[i] + ", ");
            if ((i + 1) < n) {
                if (myArray[i] >= myArray[i + 1]) {
                    incs = false;
                    incs_comment = "не ";
                }
            }
        }
        System.out.println("");
        System.out.print("Массив из " + n + " элементов в обратном порядке: ");
        for (int i = (n - 1); i >= 0; i--) {
            System.out.print(myArray[i] + ", ");
        }
        int max = myArray[0];
        int min = myArray[0];
        for (int i = 0; i < n; i++) {
            if (max < myArray[i]) {
                max = myArray[i];
                imax = i;
            }
            if (min > myArray[i]) {
                min = myArray[i];
                imin = i;
            }
            if (myArray[i] == 0) {
                count_0 = count_0 + 1;
            }
            myArrayTemp[n - 1 - i] = myArray[i];
            myArrayTemp[i] = myArray[n - 1 - i];
        }
        System.out.println("");
        System.out.print("Максимальный элемент массива: " + max);
        System.out.println(", индекс максимального элемента: " + imax);
        System.out.print("Минимальный элемент массива: " + min);
        System.out.println(", индекс минимального элемента: " + imin);
        if (count_0 == 0) {
            System.out.println("Нулевые элементы в массиве не обнаружены");
        } else {
            System.out.println("Количество нулевых элементов в массиве равно " + count_0);
        }
        System.out.print("Изменили местами элементы в массиве: ");
        for (int i = 0; i < n; i++) {
            System.out.print(myArrayTemp[i] + "  ");
        }
        System.out.println("");
        System.out.println("Исходный массив " + incs_comment + "является возрастающей последовательностью");


    }
}
