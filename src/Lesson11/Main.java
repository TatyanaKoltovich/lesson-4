package Lesson11;

import java.util.*;

public class Main {
    public static void main(String[] args) {
//      1. Ввести 3 строки с консоли, найти самую короткую и самую длинную строки. Вывести
//      найденные строки и их длину.
//      2. Ввести 3 строки с консоли, отсортировать, вывести в порядке возрастания с указанием длины строки

        System.out.println("Введите три произвольные строки различной длины");
        Scanner scanner1 = new Scanner(System.in);
        String text = scanner1.nextLine();
        String[] words = text.split(" ");
        Arrays.sort(words);

        List<String> stringList = Arrays.asList(words);
        //stringList.sort();
        stringList.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() > o2.length()) {
                    return 1;
                } else if (o1.length() < o2.length()) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });
      for (String s : stringList) {
            System.out.println(s + " длина строки: " + s.length());
        }
        //Collections.sort(words);
//        for (String word : words) {
//            System.out.println(word);
//        }

        String stringMin = words[0];
        String stringMax = words[0];
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() >= stringMax.length()) {
                stringMax = words[i];
            }
            if (words[i].length() <= stringMin.length()) {
                stringMin = words[i];
            }
        }

        System.out.println("-----------------------------------------------------------------------------");
        System.out.println("Самая короткая строка: " + stringMin + " длина строки " + stringMin.length());
        System.out.println("Самая длинная строка: " + stringMax + " длина строки " + stringMax.length());


        int[] array = new int[words.length];
        HashMap<Integer, String> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            map.put(words[i].length(), words[i]);
            array[i] = words[i].length();
        }
        Arrays.sort(array);
//        System.out.println("-----------------------------------------------------------------------");
//        System.out.println("Строки в порядке возрастания их длины:");
//        for (int i = 0; i < 3; i++) {
//            System.out.println(map.get(array[i]));
//        }

//      3. Ввести 3 строки с консоли. Вывести на консоль те строки, длина которых меньше
//      средней, а также их длину.
        System.out.println("-----------------------------------------------------------------------");
        System.out.println("Вывести те строки, длина которых меньше средней, а также их длину");
        int averageLength = 0;
        for (int i = 0; i < 3; i++) {
            averageLength += array[i];
        }
        averageLength = averageLength / 3;
        System.out.println("Средняя длина строки " + averageLength);

        for (int i = 0; i < 3; i++) {
            if (array[i] < averageLength) {
                System.out.println(map.get(array[i]) + " длина строки " + array[i]);
            }
        }

//      4. Ввести 3 строки с консоли. Найти слово, состоящее только из различных символов.
//      Если таких слов несколько, найти первое из них.
        System.out.println("-----------------------------------------------------------------------");
        System.out.println("Введите несколько слов. Нужно определить слово, состоящее только из различных символов");
        String text1 = scanner1.nextLine();
        String[] words1 = text1.split(" ");
        for (String s : words1) {
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

//      5. Вывести на консоль новую строку, которой задублирована каждая буква из
//      начальной строки. Например, "Hello" -> "HHeelllloo".
        System.out.println("-----------------------------------------------------------------------");
        System.out.println("Вывести на консоль новую строку, которой задублирована каждая буква из начальной строки");
        System.out.println("Введите начальную строку");
        String str = scanner1.next();
        char[] word = str.toCharArray();
        for (char c : word) {
            System.out.print(c + "" + c);
        }

//      Задача *:
//      Дана строка произвольной длины с произвольными словами. Написать программу для
//      проверки является ли любое выбранное слово в строке палиндромом.
        System.out.println("-----------------------------------------------------------------------");
        System.out.println("Введите любую строку из произвольных слов.");
        Scanner scanner = new Scanner(System.in);
        String text2 = scanner.nextLine();
        String[] words2 = text2.split(" ");
        System.out.println("Укажите номер любого слова");
        int num = new Scanner(System.in).nextInt();
        if (words2[num - 1].equals(new StringBuilder(words2[num - 1]).reverse().toString())) {
            System.out.println("Слово " + words2[num - 1] + " полиндром");
        } else System.out.println("Слово " + words2[num - 1] + " не является полиндромом");
    }
}
