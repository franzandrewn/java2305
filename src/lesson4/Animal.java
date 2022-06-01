package lesson4;

public class Animal {
    static int count = 0;

    static void printCount() {
        System.out.println("Текущий счетчик объектов: " + count);
    }

    int id;
    String name = "";
    double weight;
    int age;

    Animal() {
        id = count;
    }

    public Animal(String name, double weight, int age) {
        count++;
        id = count;
        this.name = name;
        this.weight = weight;
        this.age = age;
    }

    void printInfo() {
        System.out.println("Животное с именем " + name +
                ", возрастом " + age +
                " и весом " + weight);
    }

    boolean isOld() {
        if (age > 10) {
            return true;
        } else {
            return false;
        }
    }
}
