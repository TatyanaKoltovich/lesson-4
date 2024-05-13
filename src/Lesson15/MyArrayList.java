package Lesson15;

import java.lang.reflect.Array;

public class MyArrayList<T> {
    private T[] elements;

    public MyArrayList(Class<? extends T> myClass) {
        this.elements = (T[]) Array.newInstance(myClass, 0);
    }

//    public MyArrayList(T myClass) {
//        this.elements = (T[]) Array.newInstance(myClass, 0);
//    }
//    public MyArrayList() {
//
//    }

    public T[] getElements() {
        return elements;
    }

    public void setElements(T[] elements) {
        this.elements = elements;
    }

    public void add(Class<? extends T> myClass, T element) {
        T[] newElements = (T[]) Array.newInstance(myClass, this.elements.length + 1);
        for (int i = 0; i < this.elements.length; i++) {
            newElements[i] = this.elements[i];
        }
        newElements[this.elements.length] = element;
        this.elements = newElements;
    }

    public void add(Class<? extends T> myClass, int index, T element) {
        T[] newElements = (T[]) Array.newInstance(myClass, this.elements.length + 1);
        for (int i = 0; i < index; i++) {
            newElements[i] = this.elements[i];
        }
        for (int i = index; i < this.elements.length; i++) {
            newElements[i + 1] = this.elements[i];
        }
        newElements[index] = element;
        this.elements = newElements;
    }

    public void remove(int index) {
        for (int i = index; i < this.elements.length - 1; i++) {
            this.elements[i] = this.elements[i + 1];
        }
        this.elements[this.elements.length - 1] = null;
    }

    public void clear() {
        for (int i = 0; i < this.elements.length - 1; i++) {
            this.elements[i] = null;
        }
    }

    public T get(int index) {
        return this.elements[index];
    }

    public boolean contains(T myObject) {
        for (int i = 0; i < this.elements.length - 1; i++) {
            if (this.elements[i] == myObject) {
                return true;
            }
        }
        return false;
    }

    public void printArraylist() {
        for (int i = 0; i < this.elements.length; i++) {
            //System.out.println(String.valueOf(i) + ". " + this.elements[i].toString());
            System.out.println(String.valueOf(i + 1) + ". " + this.elements[i]);
        }
    }

    public int getLength() {
        return this.elements.length;
    }
}

