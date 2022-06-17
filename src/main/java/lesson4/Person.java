package lesson4;

// Класс - это собственный составный тип данных
public class Person {
    // Состояние - набор полей (характеристик)
    String name;
    int age;

    // Конструктор - специальный метод,
    // запускающийся в момент создания объекта
    Person() {
        name = "";
        age = 0;
    }

    Person(String n, int a) {
        name = n;
        age = a;
    }

    // Поведение - набор методов
    void sayName() {
        System.out.println(name);
    }

    void incAge() {
        age++;
    }

    String turnIntoString() {
        return name + " " + age;
    }
}
