package lesson4;

public class Dog extends Animal {
    // Новое поле в Dog относительно Animal
    double tailLength;

    public Dog(String name, double weight, int age) {
        super(name, weight, age);
    }

    // Конструктор, заполняющий все поля Dog
    public Dog(String name, double weight, int age, double tailLength) {
        // Используем конструктор нашего предка для заполнения общих полей
        super(name, weight, age);
        // Вручную заполняем новое поле
        this.tailLength = tailLength;
    }

    public Dog() {
    }

    // Новый метод в Dog относительно Animal
    void printTail() {
        System.out.println("Мой хвост " + tailLength + " длины");
    }

    // переопределение метода - при вызове из объекта Dog, сработает этот код
    void printInfo() {
//        super.printInfo();
        System.out.println("Животное с именем " + name +
                ", возрастом " + age +
                ", весом " + weight + " и длиной хвоста " + tailLength);
    }
}
