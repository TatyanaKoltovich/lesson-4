package Lesson10;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {

        Access access1 = new Access("full access");
        User user1 = new User("Stiv", "12345", access1);

        Access access2 = new Access("limited access");
        User user2 = new User("Stiv", "12347 ", access2);
        if (user1.equals(user2)) {
            System.out.println("user1=user2");
        }else {System.out.println("user1!=user2");}

        System.out.println(user1.hashCode());
        System.out.println(user2.hashCode());

        //User user3 = user1.clone();
        User user3 = (User) user1.clone();
        System.out.println(user1);
        System.out.println(user3);
        Access access3 = new Access("administrative access");
        user3.setAccess(access3);
        System.out.println(user1);
        System.out.println(user3);
    }
}
