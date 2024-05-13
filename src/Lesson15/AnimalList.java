package Lesson15;

import java.util.ArrayList;

public class AnimalList {

    private ArrayList<String> animalList;

    public AnimalList() {
        this.animalList = new ArrayList<>();
    }

    public ArrayList<String> getAnimalList() {
        return animalList;
    }

    public void setAnimalList(ArrayList<String> animalList) {
        this.animalList = animalList;
    }

    public void addAnimalName(String animalName) {
        this.animalList.add(0, animalName);
    }

    public void deleteOneAnimal() {
        this.animalList.remove(this.animalList.size() - 1);
    }
}
