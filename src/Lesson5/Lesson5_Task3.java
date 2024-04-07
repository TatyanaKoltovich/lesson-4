package Lesson5;

import java.util.Scanner;

public class Lesson5_Task3 {
    public static void main(String[] args) {
//        Задача *:
//        Даны числа n и m. Создайте массив A[n][m] и заполните его змейкой (см. пример).
//                Формат входных данных:
//        Программа получает на вход два числа n и m.
//                Формат выходных данных:
//        Программа должна вывести полученный массив, отводя на вывод каждого числа ровно 3
//        символа.

        System.out.println("Введите размерность массива n:");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        System.out.println("Введите размерность массива m:");
        int m = scanner.nextInt();
       // boolean directOrder = true;
        int[][] myArray = new int[n][m];
        int k = 1;

        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                for (int j = 0; j < m; j++) {
                    myArray[i][j] = k;
                    k = k + 1;
                }
            } else {
                for (int j = (m - 1); j >= 0; j--) {
                    myArray[i][j] = k;
                    k = k + 1;
                }
            }
            System.out.println(" ");
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                String strTemp = "";
                String str = String.valueOf(myArray[i][j]);
                if (str.length() < 3) {
                    for (int l = str.length(); l < 3; l++) {
                       strTemp = strTemp + " ";
                    }
                }
                System.out.print(myArray[i][j] + strTemp);
            }
            System.out.println(" ");
        }




    }
}
