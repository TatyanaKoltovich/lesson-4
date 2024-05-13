package Lesson15;

import java.util.ArrayList;

public class MyList<T> {

private ArrayList<T> arrayList;

    public ArrayList<T> getArrayList() {
        return arrayList;
    }

    public void setArrayList(ArrayList<T> arrayList) {
        this.arrayList = arrayList;
    }

    public MyList(ArrayList<T> arrayList) {
        this.arrayList = arrayList;
    }

    public void printList() {
        System.out.println(this.arrayList);
    }

    public void printListOnlyNames() {
        for (int i = 0; i <= this.arrayList.size() - 1; i++) {
            if (this.arrayList.get(i) instanceof Student) {
                System.out.println((i + 1) + ". " + (((Student) this.arrayList.get(i)).getName()));
            }else {
                System.out.println((i + 1) + ". " + (this.arrayList.get(i)));
            }
        }
        if (this.arrayList.size() == 0){
            System.out.println("Список пуст, он не может быть распечатан");
        }
    }
}
