package Lesson13;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Lesson13 {
    public static void main(String[] args) {
      task1();
      task2();
    }

    public static void task1() {
//        Создать класс, в котором будет статический метод. Этот метод принимает на вход три
//        параметра: login, password, confirmPassword. Все поля имеют тип данных String. Длина
//        login должна быть меньше 20 символов и не должен содержать пробелы. Если login не
//        соответствует этим требованиям, необходимо выбросить WrongLoginException. Длина
//        password должна быть меньше 20 символов, не должен содержать пробелом и должен
//        содержать хотя бы одну цифру. Также password и confirmPassword должны быть равны.
//                Если password не соответствует этим требованиям, необходимо выбросить
//        WrongPasswordException. WrongPasswordException и WrongLoginException -
//                пользовательские классы исключения с двумя конструкторами – один по умолчанию,
//                второй принимает сообщение исключения и передает его в конструктор класса Exception.
//        Метод возвращает true, если значения верны, false в противном случае.

        System.out.println("Введите логин (длина меньше 20 символов без пробелов):");
        Scanner scanner = new Scanner(System.in);
        String stringLogin = scanner.nextLine();
        System.out.println("Введите пароль (длина меньше 20 символов без пробелов и хотя бы одна цифра):");
        String stringPassword = scanner.nextLine();
        System.out.println("Подтвердите пароль");
        String stringConfirmPassword = scanner.nextLine();

        AddNewUser addNewUser = new AddNewUser(stringLogin, stringPassword, stringConfirmPassword);
        //boolean addUserSuccess = addNewUser.isAddUser();

        if (addNewUser.isAddUser()) {
            System.out.println("user added successfully");
        }
    }

    public static void task2() {
        //Написать try/catch/finally, в котором finally вызван не будет
        try {
            System.out.println("Выполнение опреатора try");
            System.out.println("Введите число с клавиатуры");
            Scanner scanner = new Scanner(System.in);
            int number = scanner.nextInt();
        } catch (InputMismatchException exception) {
            System.out.println("Выполнение опреатора catch");
            System.exit(0);
        } finally {
            System.out.println("Выполнение опреатора finally");
        }
    }
}