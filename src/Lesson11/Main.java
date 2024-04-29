package Lesson11;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        1. Ввести 3 строки с консоли, найти самую короткую и самую длинную строки. Вывести
//        найденные строки и их длину.
//        2. Ввести 3 строки с консоли. Упорядочить и вывести строки в порядке возрастания
//        значений их длины.
//        3. Ввести 3 строки с консоли. Вывести на консоль те строки, длина которых меньше
//        средней, а также их длину.
//        4. Ввести 3 строки с консоли. Найти слово, состоящее только из различных символов.
//        Если таких слов несколько, найти первое из них.
//        5. Вывести на консоль новую строку, которой задублирована каждая буква из
//        начальной строки. Например, "Hello" -> "HHeelllloo".
//        Задача *:
//        Дана строка произвольной длины с произвольными словами. Написать программу для
//        проверки является ли любое выбранное слово в строке палиндромом.

        System.out.println("Введите три произвольные строки различной длины");
        Scanner scanner1 = new Scanner(System.in);
        String stringFirst = scanner1.next();
        String stringSecond = scanner1.next();
        String stringThird = scanner1.next();

        HashMap<Integer, String> map = new HashMap<>();
        map.put(stringFirst.length(), stringFirst);
        map.put(stringSecond.length(), stringSecond);
        map.put(stringThird.length(), stringThird);

        int[] array = {stringFirst.length(), stringSecond.length(), stringThird.length()};
        Arrays.sort(array);

        System.out.println("Самая короткая строка: " + map.get(array[0]) + " длина строки " + array[0]);
        System.out.println("Самая длинная строка: " + map.get(array[2]) + " длина строки " + array[2]);
        System.out.println("-----------------------------------------------------------------------");
        System.out.println("Строки в порядке возрастания их длины:");
        for (int i = 0; i < 3; i++) {
            System.out.println(map.get(array[i]));
        }
        System.out.println("Вывести те строки, длина которых меньше средней, а также их длину");
        int averageLength = 0;
        for (int i = 0; i < 3; i++) {
           averageLength += array[i];
        }
        averageLength = averageLength/3;
        System.out.println("Средняя длина строки " + averageLength);

        for (int i = 0; i < 3; i++) {
            if (array[i] < averageLength) {
                System.out.println(map.get(array[i]) + " длина строки " + array[i]);
            }
        }

//        4. Ввести 3 строки с консоли. Найти слово, состоящее только из различных символов.
//        Если таких слов несколько, найти первое из них.
        System.out.println("Введите несколько слов. Нужно определить слово, состоящее только из различных символов");
        String text = scanner1.nextLine();
        String[] words = text.split(" ");
        for (String s : words) {
            char[] word = s.toCharArray();
            ArrayList<Character> arrayList = new ArrayList<>();
            for (char c : word) {
                int foundIndex = arrayList.indexOf(c);
                if (foundIndex == -1) {
                    arrayList.add(c);
                }
            }
            if (word.length == arrayList.size()) {
                System.out.println("В этом слове все буквы разные: " + s);
            }
        }
//        5. Вывести на консоль новую строку, которой задублирована каждая буква из
//        начальной строки. Например, "Hello" -> "HHeelllloo".
        System.out.println("Вывести на консоль новую строку, которой задублирована каждая буква из начальной строки");
        System.out.println("Введите начальную строку");
        String str = scanner1.next();
        char[] word = str.toCharArray();
        for (char c : word) {
            System.out.print(c + "" + c);
        }

//        Задача *:
//        Дана строка произвольной длины с произвольными словами. Написать программу для
//        проверки является ли любое выбранное слово в строке палиндромом.
        System.out.println("Введите любую строку из произвольных слов.");
        Scanner scanner = new Scanner(System.in);
        String text1 = scanner.nextLine();
        String[] words1 = text1.split(" ");
        System.out.println("Укажите номер любого слова");
        int num = new Scanner(System.in).nextInt();
        if (words1[num-1].equals(new StringBuilder(words1[num-1]).reverse().toString())) {
            System.out.println("Слово " + words1[num-1] + " полиндром");
        }else System.out.println("Слово " + words1[num-1] + " не является полиндромом");
    }
}
