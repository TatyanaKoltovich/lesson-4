package MakeMoneyTransferApp.model;

import MakeMoneyTransferApp.exception.ProcessingExceptions;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TransferOperations {
    public static void transferOperation() throws IOException, ProcessingExceptions {

        Map<String, Account> hashMapAccounts = currentAccounts();
        System.out.println("Выберите операцию:");
        System.out.println("1: вызов операции парсинга файлов перевода из input");
        System.out.println("2: вызов операции вывода списка всех переводов из файла-отчета");
        System.out.println("3: вызов операции вывода списка всех переводов из файла-отчета, фильтр по периоду");
        Scanner scanner = new Scanner(System.in);
        int menu = scanner.nextInt();
        if (menu == 1) {
            //1: вызов операции парсинга файлов перевода из input
            makeTransfer(hashMapAccounts);
        } else if (menu == 2) {
            //2: вызов операции вывода списка всех переводов из файла-отчета
            showReport();
        } else if (menu == 3) {
            //2: вызов операции вывода списка всех переводов из файла-отчета
            showReportWithFilter();
        } else {
            System.out.println("Возможен выбор только операций 1, 2 и 3. Выбранная операция не может быть выполнена");
        }
    }

    private static Map<String, Account> currentAccounts() throws IOException, ProcessingExceptions {
        Map<String, Account> hashMapAccounts = new HashMap<>();

        File fileAccounts = new File("src/MakeMoneyTransferApp/resourses/Accounts.txt");

        if (fileAccounts.exists() == false) {
            throw new ProcessingExceptions("Не найден файл Accounts.txt");
        } else {

            FileReader fr = null;
            try {
                fr = new FileReader(fileAccounts);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
            BufferedReader br = new BufferedReader(fr);
            String line;
            while (true) {
                try {
                    if (!((line = br.readLine()) != null)) break;
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                String[] words = line.split(" ");
                Pattern pattern = Pattern.compile("\\d{5}-\\d{5} \\d");
                Matcher matcher = pattern.matcher(line);

                while (matcher.find()) {
                    Account newAccount = new Account(words[0], Integer.valueOf(words[1]));
                    hashMapAccounts.put(words[0], newAccount);
                }
            }
            br.close();
            fr.close();
        }
        // System.out.println(hashMapAccounts);
        return hashMapAccounts;
    }

    private static void makeTransfer(Map<String, Account> hashMapAccounts) throws IOException {

        File folder = new File("src/MakeMoneyTransferApp/input");
        FilenameFilter filter = new FilenameFilter() {
            public boolean accept(File directory, String fileName) {
                return fileName.endsWith(".txt");
            }
        };
        File[] listOfFiles = folder.listFiles(filter);
        Report stringReport = new Report();

        for (File file : listOfFiles) {

            FileReader fr = null;
            try {
                fr = new FileReader(file);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
            BufferedReader br = new BufferedReader(fr);
            String line;
            while (true) {
                try {
                    if (!((line = br.readLine()) != null)) break;
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                String[] words = line.split(" ");
                Pattern pattern = Pattern.compile("\\d{5}-\\d{5} \\d{5}-\\d{5} \\d");
                Matcher matcher = pattern.matcher(line);

                while (matcher.find()) {
                    boolean allowTransfer = true;
                    //String stringReport = "";
                    String accountNumberOut = words[0];
                    String accountNumberIn = words[1];
                    int amountTransfer = Integer.valueOf(words[2]);
                    if (hashMapAccounts.containsKey(accountNumberOut) == false) {
                        allowTransfer = false;
                        stringReport.setTextReport("Перевод: " + accountNumberOut + "=>" + accountNumberIn + "| " + String.valueOf(amountTransfer) + "| ошибка во время обработки, не найден счет-отправитель");
                    }
                    if (hashMapAccounts.containsKey(accountNumberIn) == false) {
                        allowTransfer = false;
                        stringReport.setTextReport("Перевод: " + accountNumberOut + "=>" + accountNumberIn + "| " + String.valueOf(amountTransfer) + "| ошибка во время обработки, не найден счет-получатель");
                    }
                    if (amountTransfer < 0) {
                        allowTransfer = false;
                        stringReport.setTextReport("Перевод: " + accountNumberOut + "=>" + accountNumberIn + "| " + String.valueOf(amountTransfer) + "| ошибка во время обработки, сумма перевода отрицательная");
                    }
                    if (allowTransfer) {
                        Account accountOut = hashMapAccounts.get(accountNumberOut);
                        Account accountIn = hashMapAccounts.get(accountNumberIn);
                        stringReport.setTextReport(transferAmount(accountIn, accountOut, amountTransfer));
                    }
                }
            }

            br.close();
            fr.close();

            String newName = "src/MakeMoneyTransferApp/archive/" + file.getName().replaceAll(".txt", "") + "_" + stringGetDateNow() + ".txt";
            file.renameTo(new File(newName));
        }
        //System.out.println(hashMapAccounts);

        FileWriter fw = new FileWriter("src/MakeMoneyTransferApp/output/Report.txt", true);
        BufferedWriter br = new BufferedWriter(fw);
        fw.write(stringReport.getTextReport());

        br.close();
        fw.close();

        rewriteFileAccounts(hashMapAccounts);
    }

    private static void rewriteFileAccounts(Map<String, Account> hashMapAccounts) throws IOException {

        FileWriter fw = new FileWriter("src/MakeMoneyTransferApp/resourses/Accounts.txt");
        BufferedWriter br = new BufferedWriter(fw);

        Report reportAccounts = new Report();

        for (Account account: hashMapAccounts.values()) {
            reportAccounts.setTextReportWithoutDates(account.getAccountNumber() + " " + String.valueOf(account.getAmount()));
        }
        fw.write(reportAccounts.getTextReport());
        br.close();
        fw.close();
    }

    private static String getDateNow() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
        String text = dtf.format(LocalDateTime.now());
        return text;
    }

    private static String stringGetDateNow() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("ddMMyyyyHHmmss");
        String text = dtf.format(LocalDateTime.now());
        return text;
    }

    private static void showReport() throws IOException {
        FileReader fr = new FileReader("src/MakeMoneyTransferApp/output/Report.txt");
        BufferedReader br = new BufferedReader(fr);
        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }
        br.close();
        fr.close();
    }

    private static void showReportWithFilter() throws IOException {
        System.out.println("Введите дату начала периода в формате дд.мм.гггг");
        Scanner scanner = new Scanner(System.in);
        LocalDate localDateBegin = LocalDate.parse(scanner.nextLine(), DateTimeFormatter.ofPattern("dd.MM.yyyy"));

        System.out.println("Введите дату окончания периода в формате дд.мм.гггг");
        LocalDate localDateEnd = LocalDate.parse(scanner.nextLine(), DateTimeFormatter.ofPattern("dd.MM.yyyy"));

        FileReader fr = new FileReader("src/MakeMoneyTransferApp/output/Report.txt");
        BufferedReader br = new BufferedReader(fr);
        String line;
        System.out.println("Отчет формируется за период с " + localDateBegin.toString() + " по " + localDateEnd.toString());
        int linesPrinted = 0;
        while ((line = br.readLine()) != null) {
            String[] words = line.split("\\|");
            String stringDate = words[0];

            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
            //DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy");
            LocalDate ldt = LocalDate.from(dtf.parse(words[0]));
            ldt.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));

            if ((ldt.isAfter(localDateBegin) || ldt.equals(localDateBegin)) && (ldt.isBefore(localDateEnd) || ldt.equals(localDateEnd))) {
                System.out.println(line.toString());
                linesPrinted ++;
            }
        }
        if (linesPrinted == 0) {
            System.out.println("В отчете не найдено записей за указанный период");
        }
        br.close();
        fr.close();
    }

    private static String transferAmount(Account accountIn, Account accountOut, int amount) {
        if (accountOut.getAmount() < amount) {
            //return "На счете " + accountOut.getAccountNumber() + " недостаточно средств для перевода" + "\n";
            return "Перевод: " + accountOut.getAccountNumber() + "=>" + accountIn.getAccountNumber() + "| " + accountIn.getAmount().toString() + "| ошибка во время обработки, недостаточно средств для перевода";
        }
        accountIn.setAmount(accountIn.getAmount() + amount);
        accountOut.setAmount(accountOut.getAmount() - amount);
        return "Перевод: " + accountOut.getAccountNumber() + "=>" + accountIn.getAccountNumber() + "| " + accountIn.getAmount().toString() + "| успешно";
    }
}
