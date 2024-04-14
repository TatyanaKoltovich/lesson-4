package Lesson7.Clinic;

public class Therapist extends Doctor{
    public int plotNumber;

public Therapist(String nameDoctor, int plotNumber){
    this.nameDoctor = nameDoctor;
    this.plotNumber = plotNumber;
}
    public void chooseDoctor(String patientName, int treatmentPlan) {

        Doctor doctor1 = new Doctor("surgeon");
        Doctor doctor2 = new Doctor("dantist");
        Doctor doctor3 = new Doctor("therapist");

        switch (treatmentPlan) {
            case 1 -> doctor1.treat(patientName, treatmentPlan, doctor1.nameDoctor);
            case 2 -> doctor2.treat(patientName, treatmentPlan, doctor2.nameDoctor);
            default -> doctor3.treat(patientName, treatmentPlan, doctor3.nameDoctor);
        }
    }
}
