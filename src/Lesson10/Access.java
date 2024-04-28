package Lesson10;

public class Access implements Cloneable{
    private String name;

    public Access(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "Access{" +
                "name='" + name + '\'' +
                '}';
    }
}
