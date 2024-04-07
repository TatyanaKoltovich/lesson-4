package Lesson5;

public class Lesson5_Task2 {
    public static void main(String[] args) {
//        Задача 2:
//        Создать программу для раскраски шахматной доски с помощью цикла. Создать
//        двумерный массив String 8х8. С помощью циклов задать элементам массива значения
//        B(Black) или W(White). При выводе результат работы программы должен быть
//        следующим:
//        W B W B W B W B
//        B W B W B W B W
//        W B W B W B W B
//        B W B W B W B W
//        W B W B W B W B
//        B W B W B W B W
//        W B W B W B W B
//        B W B W B W B W

        String[][] myArray = new String[8][8];
        for (int i = 0; i < 8; i++) {

            for (int j = 0; j < 8; j++) {
                if ((i + j) % 2 == 0) {
                    myArray[i][j] = "W";
                } else {
                    myArray[i][j] = "B";
                }
                System.out.print(myArray[i][j] + " ");
            }
            System.out.println(" ");
        }
    }
}
