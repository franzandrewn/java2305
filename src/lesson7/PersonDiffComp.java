package lesson7;

import java.io.Serializable;
import java.util.Objects;

// Интерфейс Serializable - метка о том, что объекты Person Java
// умеет превращать в набор байт
public class PersonDiffComp implements Serializable {

    String name;
    int age;

    void sayName() {
        System.out.println(name);
    }

    void incAge() {
        age++;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PersonDiffComp)) return false;
        PersonDiffComp that = (PersonDiffComp) o;
        return age == that.age && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        return "PersonDiffComp{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public PersonDiffComp() {
    }

    public PersonDiffComp(String name, int age) {
        this.name = name;
        this.age = age;
    }

    String turnIntoString() {
        return name + " " + age;
    }
}
