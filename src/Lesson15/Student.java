package Lesson15;

import java.util.*;

public class Student {
    private String name;
    private String groupe;
    private int course;
    private Map<String, Integer> hashMapSubjectGrades;

    private String status;


    public Student(String name, String groupe, int course) {
        this.name = name;
        this.groupe = groupe;
        this.course = course;
        this.status = "studies";

        Map<String, Integer> hashMap = new HashMap<>();
        this.hashMapSubjectGrades = hashMap;

        hashMap.put("math", 0);
        hashMap.put("language", 0);
        hashMap.put("physics", 0);
        hashMap.put("chemistry", 0);
        hashMap.put("psychology", 0);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGroupe() {
        return groupe;
    }

    public void setGroupe(String groupe) {
        this.groupe = groupe;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public Map<String, Integer> getHashMap() {
        return hashMapSubjectGrades;
    }

    public void setHashMap(HashMap<String, Integer> hashMap) {
        this.hashMapSubjectGrades = hashMap;
    }

    public void addGrade(String subject, Integer grade){
        this.hashMapSubjectGrades.put(subject, grade);
        //this.hashMapSabjectGrades.get(subject)
    }

    public float calculateAverageGrade(Student student) {
        float averageGrade;
        int sum = 0;
        for (Map.Entry<String, Integer> item : this.hashMapSubjectGrades.entrySet()) {
            sum = sum + item.getValue();
        }
        //averageGrade = Float.valueOf(Integer.toString(sum)) / (this.hashMapSubjectGrades.size());
        averageGrade = Float.valueOf(Integer.toString(sum)) / (this.hashMapSubjectGrades.size());
        return averageGrade;
    }

    public void expelleStudent(Student student){
        this.status = "expelled";
        this.course = 0;
    }

    public void transferToNextCourse(Student student){
        this.course ++;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", groupe='" + groupe + '\'' +
                ", course=" + course +
                ", SabjectGrades=" + hashMapSubjectGrades +
                ", status='" + status + '\'' +
                '}';
    }
}
