package Lesson7.Clinic;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Введите имя пациента: ");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();

        System.out.println("Введите возраст пациента:");
        int age = scanner.nextInt();

        System.out.println("Введите номер плана лечения (1,2 или любой другой номер):");
        int treatmentPlan = scanner.nextInt();

        Patient patient1 = new Patient(name, age, treatmentPlan);

        Therapist therapist = new Therapist("therapist", 7);
        System.out.println("Пациент " + patient1.name + ": первичный прием у терапевта, участок №" + therapist.plotNumber);

        therapist.chooseDoctor(patient1.name, patient1.treatmentPlan);
    }
}
