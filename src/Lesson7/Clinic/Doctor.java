package Lesson7.Clinic;

public class Doctor {
    String nameDoctor;

    public Doctor(String nameDoctor){
        this.nameDoctor = nameDoctor;
    }

    public Doctor() {
    }
    public void treat(String pacientName, int treatmentPlan, String nameDoctor) {
        System.out.println("Для пациента " + pacientName + " назначен врач " + nameDoctor + " для плана лечения №" + treatmentPlan);
        switch (nameDoctor){
            case "surgeon" -> System.out.println("Необходимость операции хирург определит на осмотре.");
            case "dantist" -> System.out.println("На прием к дантисту нужно записаться дополнительно.");
            case "therapist" -> System.out.println("Терапевт назначит дополнительные обследования для уточнения плана лечения.");

        }
    }
}

