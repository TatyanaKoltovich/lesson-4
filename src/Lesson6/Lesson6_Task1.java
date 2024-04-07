package Lesson6;

import java.util.Scanner;

public class Lesson6_Task1 {
    public static void main(String[] args) {
//        Задача 1:
//        Создать класс CreditCard c полями номер счета, текущая сумма на счету. Добавьте
//        метод, который позволяет начислять сумму на кредитную карточку. Добавьте метод,
//        который позволяет снимать с карточки некоторую сумму. Добавьте метод, который
//        выводит текущую информацию о карточке. Напишите программу, которая создает три
//        объекта класса CreditCard у которых заданы номер счета и начальная сумма.
//                Тестовый сценарий для проверки: Положите деньги на первые две карточки и снимите с
//        третьей. Выведите на экран текущее состояние всех трех карточек.

        CreditCard FirstAccount = new CreditCard("1111", 1000);
        CreditCard SecondAccount = new CreditCard("2222", 2000);
        CreditCard ThirdAccount = new CreditCard("3333", 3000);

        FirstAccount.ShowInfomation();
        SecondAccount.ShowInfomation();
        ThirdAccount.ShowInfomation();

        System.out.println("Введите сумму, которую вы хотите внести на счет 1111: ");
        Scanner scanner = new Scanner(System.in);
        int sum = scanner.nextInt();
        System.out.println(sum);
        FirstAccount.AddAmount(sum);
        System.out.println("На счет внесена сумма " + sum);
        FirstAccount.ShowInfomation();

        System.out.println("Введите сумму, которую вы хотите внести на счет 2222: ");
        Scanner scanner1 = new Scanner(System.in);
        int sum1 = scanner1.nextInt();
        System.out.println(sum1);
        SecondAccount.AddAmount(sum1);
        System.out.println("На счет внесена сумма " + sum1);
        SecondAccount.ShowInfomation();

        System.out.println("Введите сумму, которую вы хотите снять со счета 3333: ");
        Scanner scanner2 = new Scanner(System.in);
        int sum2 = scanner2.nextInt();
        System.out.println("Co счета снята сумма " + sum2);
        ThirdAccount.WhithdrawAmount(sum);
        ThirdAccount.ShowInfomation();
    }
}
