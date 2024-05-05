import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Lesson12 {
    public static void main(String[] args) {
        task1();
        task2();
    }

    public static void task1() {
//        Вывести в консоль из строки которую пользователь вводит с клавиатуры все
//        аббревиатуры. Аббревиатурой будем считать слово от 2 до 6 символов, состоящее
//        только из прописных букв, без чисел

        System.out.println("Введите произвольное количество слов с клавиатуры, в том числе аббревиатуры");
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        Pattern pattern = Pattern.compile("(^?|\\s)([A-Z]{2,6})");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find())
            System.out.println(matcher.group().trim());
    }

    public static void task2() {
//        Программа на вход получает произвольный текст. В этом тексте может быть номер
//        документа(один или несколько), емейл и номер телефона. Номер документа в формате:
//        xxxx-xxxx-xx, где x - это любая цифра; номер телефона в формате: +(xx)xxxxxxx. Документ
//        может содержать не всю информацию, т.е. например, может не содержать номер
//        телефона, или другое. Необходимо найти эту информацию и вывести в консоль в
//        формате:
//        email: teachmeskills@gmail.com
//        document number: 1423-1512-51
//        и т.д

        System.out.println("Введите произвольный текст, текст должен содержать номер документа, телефон и e-mail");
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        Pattern patternDoc = Pattern.compile("(^?|\\s)([0-9]{4})-([0-9]{4}-([0-9]{2}))");
        Pattern patternPhone = Pattern.compile("(^?|\\s)\\+{1}\\({1}([0-9]{2}\\){1}([0-9]{7}))");
        Pattern patternMail = Pattern.compile("(^?|\\s?)([A-Za-z0-9]{0,}[\\-]{0,1}[A-Za-z0-9]{0,}[_]{0,1}[A-Za-z0-9]{0,}[.]{0,1}[A-Za-z0-9]{0,})@([A-Za-z]{0,}[.]{1}[A-Za-z]{2,20})");

        Matcher matcherDoc = patternDoc.matcher(text);
        while (matcherDoc.find())
            System.out.println("Документ: " + matcherDoc.group().trim());

        Matcher matcherPhone = patternPhone.matcher(text);
        while (matcherPhone.find())
            System.out.println("Номер телефона: " + matcherPhone.group().trim());

        Matcher matcherMail = patternMail.matcher(text);
        while (matcherMail.find())
            System.out.println("e-mail: " + matcherMail.group().trim());
    }
}
