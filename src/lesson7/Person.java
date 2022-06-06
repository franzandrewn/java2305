package lesson7;

import java.io.Serializable;
import java.util.Objects;

// Интерфейс Serializable - метка о том, что объекты Person Java
// умеет превращать в набор байт
public class Person implements Serializable {

    String name;
    transient String password;
    int age;

    Person() {
        name = "";
        age = 0;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person(String name, String password, int age) {
        this.name = name;
        this.password = password;
        this.age = age;
    }

    void sayName() {
        System.out.println(name);
    }

    void incAge() {
        age++;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return age == person.age && Objects.equals(name, person.name) && Objects.equals(password, person.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, password, age);
    }

    String turnIntoString() {
        return name + " " + age;
    }
}
