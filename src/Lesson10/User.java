package Lesson10;

import java.util.Objects;

public class User implements Cloneable{
   private String name;
   private String password;
   private Access access;

    public User(String name, String password, Access access) {
        this.name = name;
        this.password = password;
        this.access = access;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Access getAccess() {
        return access;
    }

    public void setAccess(Access access) {
        this.access = access;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User user)) return false;
        return getName().equals(user.getName()) && getPassword().equals(user.getPassword());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getPassword());
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        User userCloned = (User) super.clone();
        Access accessCloned = (Access) userCloned.getAccess().clone();
        userCloned.setAccess(accessCloned);
        return userCloned;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", access=" + access +
                '}';
    }
}
