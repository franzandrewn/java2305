package lesson11;

import java.io.Serializable;
import java.util.Objects;

public class Person implements Serializable, Comparable<Person> {
    int id;
    String name;
    String password;
    int age;

    Person() {
        name = "";
        age = 0;
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
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return id == person.id
                && age == person.age
                && Objects.equals(name, person.name)
                && Objects.equals(password, person.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, password, age);
    }

    @Override
    public int compareTo(Person o) {
        return this.age - o.age;
    }
}
