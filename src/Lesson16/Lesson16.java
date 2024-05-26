package Lesson16;

import java.awt.*;
import java.util.*;

public class Lesson16 {
    public static void main(String[] args) {
        //task1();
        //task2();
        task3();
    }

    public static void task1() {
//        На вход поступает массив строк, верните Map<String, Boolean>, где каждая отдельная
//        строка является ключом, и ее значение равно true, если эта строка встречается в массиве
//        2 или более раз
        System.out.println("Введите через пробел массив символов, некоторые символы должны повториться");
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        String[] words = text.split(" ");

        Map<String, Boolean> hashMap = new HashMap<>();
        for (String word : words) {
            if (hashMap.containsKey(word)) {
                hashMap.put(word, true);
            } else {
                hashMap.put(word, false);
            }
        }
        System.out.println(hashMap);
    }

    public static void task2() {
//        На вход поступает массив непустых строк, создайте и верните Map<String,
//        String> следующим образом: для каждой строки добавьте ее первый символ в
//        качестве ключа с последним символом в качестве значения
        System.out.println("Введите несколько слов через пробел");
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        String[] words = text.split(" ");

        Map<Character, Character> hashMap = new HashMap<>();
        for (String word : words) {
            char[] chars = word.toCharArray();
            hashMap.put(chars[0], chars[chars.length - 1]);
        }
        System.out.println(hashMap);
    }

    public static void task3(){
//        Задана строка, которая может иметь внутри себя скобки. Скобкой считается
//        любой из следующих символов — «(«, «)», «[«, «]», «{«, «}». Проверить
//        сбалансированность расстановки скобок в этой строке. Набор скобок считается
//        сбалансированной парой, если открывающая скобка "(", "[" и "{" стоит слева от
//        соответствующей закрывающей скобки ")", "]" и "} ", соответственно. Строка,
//        содержащая пары скобок, не сбалансирована, если набор заключенных в нее
//        скобок не совпадает
        System.out.println("((()))" + " brackets is valid: " + isValidBrackets("((()))"));
        System.out.println("((())[{)]" + " brackets is valid: " + isValidBrackets("((())[{)]"));
    }

    private static boolean isValidBrackets(String input) {
        Map<Character, Character> brackets = new HashMap<>();
        brackets.put(')', '(');
        brackets.put(']', '[');
        brackets.put('}', '{');

        Deque<Character> stack = new LinkedList<>();
        for (char c : input.toCharArray()) {
            if (brackets.containsValue(c)) {
                stack.push(c);
            } else if (brackets.containsKey(c)) {
                if (stack.isEmpty() || stack.pop() != brackets.get(c)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
