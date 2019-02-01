package ratemysigning.thesohankathait.firstassignment;

public class User {
    String name,age;

    public User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public User(String name, String age) {

        this.name = name;
        this.age = age;
    }
}
