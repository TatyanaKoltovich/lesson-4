package Lesson14;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
//import java.util.Comparator;


public class Lesson14 {
    public static void main (String[] args) throws IOException {
       //task1();
       task2();
    }

    public static void task1() throws IOException {
//        В задании приложен файл Ромео и Джульетта на английском, вычитать его в приложении.
//        Проанализировать и записать в другой файл самое длинное слово

        File file = new File("src/Lesson14/romeo-and-juliet.txt");
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);

        ArrayList<String> listWords = new ArrayList<>();
        String line;
        Pattern pattern = Pattern.compile("^[A-Za-z]{3,}$");

        while ((line = br.readLine()) != null) {
            String[] words = line.split(" ");

            // listWords.addAll(List.of(words));
            for (int i = 0; i < words.length; i++) {
                Matcher matcher = pattern.matcher(words[i]);
                while (matcher.find()) {
                    listWords.add(words[i]);
                }
            }
        }
        br.close();
        fr.close();
        //Comparator<? super Object> MyComparator;
        Collections.sort(listWords, new MyComparator14());
        System.out.println(listWords.get(0));
        System.out.println(listWords.get(listWords.size() - 1));

        FileWriter fw = new FileWriter("src/Lesson14/fileOut.txt");
        fw.write(listWords.get(listWords.size() - 1));
        fw.close();
    }

    public static void task2() throws IOException {
//        Допустим есть txt файл с номерами документов. Номером документа является строка,
//        состоящая из букв и цифр(без служебных символов). Пусть этот файл содержит каждый
//        номер документа с новой строки и в строке никакой другой информации, только номер
//        документа. Валидный номер документа должен иметь длину 15 символов и начинаться с
//        последовательности docnum(далее любая последовательность букв/цифр) или
//        contract(далее любая последовательность букв/цифр). Написать программу для чтения
//        информации из входного файла - путь к входному файлу должен задаваться через
//        консоль. Программа должна проверять номера документов на валидность. Валидные
//        номера документов следует записать в один файл-отчет. Невалидные номера документов
//        следует записать в другой файл-отчет, но после номеров документов следует добавить
//        информацию о том, почему этот документ не валиден

        System.out.println("Write filename");
        Scanner scanner = new Scanner(System.in);
        String fileName = scanner.nextLine();

        File file = new File(fileName);
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);

        FileWriter fw = new FileWriter("src/Lesson14/fileDocumOut.txt");

        String line;
        Pattern pattern = Pattern.compile("^(docum[A-Za-z\\d]{10})|(contract[A-Za-z\\d]{7})$");

        while ((line = br.readLine()) != null) {
            String[] words = line.split(" ");

            // listWords.addAll(List.of(words));
            for (int i = 0; i < words.length; i++) {
                Matcher matcher = pattern.matcher(words[i]);
                while (matcher.find()) {
                    fw.write("\n" + words[i]);
                }
            }
        }
        br.close();
        fr.close();
        fw.close();
    }
}