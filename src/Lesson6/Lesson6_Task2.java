package Lesson6;

import java.util.Scanner;

public class Lesson6_Task2 {
    public static void main(String[] args) {
//        Задача *:
//        Создать класс, описывающий банкомат. Набор купюр, находящихся в банкомате, должен
//        задаваться тремя свойствами: количеством купюр номиналом 20, 50 и 100. Сделать
//        метод для добавления денег в банкомат. Сделать функцию, снимающую деньги, которая
//        принимает сумму денег, а возвращает булевое значение - успешность выполнения
//        операции. При снятии денег, функция должна распечатывать каким количеством купюр
//        какого номинала выдаётся сумма. Создать конструктор с тремя параметрами -
//        количеством купюр каждого номинала.
        Atm myAtm = new Atm(5, 3, 2);
        myAtm.ShowInfomation();

        System.out.println("Введите сумму, которую вы хотите внести на счет: ");
        Scanner scanner = new Scanner(System.in);
        int sum = scanner.nextInt();
        myAtm.AddAmount(sum);
        myAtm.ShowInfomation();

        System.out.println("Введите сумму, которую вы хотите снять со счета: ");
        Scanner scanner2 = new Scanner(System.in);
        int sum2 = scanner2.nextInt();


        boolean sucsess = myAtm.WithdrawAmount(sum2);
        if (sucsess == true) {
            System.out.println("Операция завершена успешно");
        } else {
            System.out.println("Операцию не удалось завершить успешно");
        }

    }


}
