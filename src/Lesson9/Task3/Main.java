package Lesson9.Task3;

public class Main {
    public static void main (String[] args) throws CloneNotSupportedException {
        User user = new User("tushkanchyk", "333");
        System.out.println("User1: name " + user.getName() + ", password " + user.getPassword());

        User clone = user.clone();
        System.out.println("User2, before changes: name " + clone.getName() + ", password " + clone.getPassword());
        clone.setName("mouse");
        clone.setPassword("555");
        System.out.println("User2, after changes: name " + clone.getName() + ", password " + clone.getPassword());
    }
}
