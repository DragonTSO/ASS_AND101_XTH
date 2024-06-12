package fpoly.hoangdhph19515.asmmob101_hoangdhph19515.Models;

public class Department {
    private int Avata;
    private String Name;

    public Department(int avata, String name) {
        Avata = avata;
        Name = name;
    }

    public Department() {
    }

    public int getAvata() {
        return Avata;
    }

    public void setAvata(int avata) {
        Avata = avata;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}
