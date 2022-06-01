package lesson4;

import java.util.Arrays;

public class Main {
    static int max(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            System.out.println("Новое число " + arr[i] + ", сравниваю с старым максимумом " + max);
            if (arr[i] > max) {
                max = arr[i];
                System.out.println("Обновляю максимум");
            }
        }
        return max;
    }

    static int min(int[] arr) {
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            System.out.println("Новое число " + arr[i] + ", сравниваю с старым минимумом " + min);
            if (arr[i] < min) {
                min = arr[i];
                System.out.println("Обновляю минимум");
            }
        }
        return min;
    }

    static int maxIndex(int[] arr) {
        int max = arr[0];
        int maxIndex = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    static void arrayAlgorithms() {
        int[] ints = new int[]{1, 5, -2, 6, 10, -80, 100, 1};
        System.out.println("Максимум = " + max(ints));
        System.out.println("Минимум = " + min(ints));
        System.out.println("Индекс максимума = " + maxIndex(ints));
    }

    static void noOOP() {
        String andrewName = "Andrew";
        int andrewAge = 23;
        int[] andrewGrades = new int[]{4, 5, 2, 3, 4};

        String[] names = new String[]{"Andrew", "Vasya"};
        int[] age = new int[]{23, 25};
        int[][] grades = new int[][]{new int[]{3, 2, 4, 5}, new int[]{2, 4, 6, 7, 4, 3}};

        System.out.println(names[0] + " " + age[0] + " " + Arrays.toString(grades[0]));
    }

    static void oop() {
        // Создание переменной класса Person
        // Переменная класса - объект
        Person andrew = new Person();
//        System.out.println(andrew);
//        System.out.println(andrew.name);
//        System.out.println(andrew.age);

        andrew.name = "Andrew";
        andrew.age = 23;
//        System.out.println(andrew.name);
//        System.out.println(andrew.age);

        andrew.sayName();
        andrew.incAge();
//        System.out.println(andrew.age);
//        System.out.println(andrew.turnIntoString());

        Person vasya = new Person();
        vasya.name = "Vasya";
        vasya.age = 25;
        System.out.println(vasya.turnIntoString());
    }

    static void constructors() {
        Person andrew = new Person("Andrew", 23);
        andrew.sayName();
        andrew.incAge();
        System.out.println(andrew.turnIntoString());

        Person someGuy = new Person();
        System.out.println(someGuy.turnIntoString());
    }

    // task1
    /*
    Создать класс Animal
    У него 3 поля:
        строка с именем (name)
        дробное число вес (weight)
        целое число с возрастом (age)
     */

    // task2
    /*
    Определить 2 метода внутри Animal:
        Метод printInfo без входных или выходных данных, выводящий все три поля на экран в формате
            "Животное с именем имя_животного, возрастом возраст_животного и весом вес_животного"
        Метод isOld без входных данных, возвращает boolean
            В случае если возраст > 10, вернуть true, иначе вернуть false
     */

    // task3
    /*
    Создать два конструктора внутри Animal: один пустой, заполняющий имя пустой строкой,
    другой принимает три аргумента таких же типов как и у полей с именами n, w, a
    name заполняется из n, weight из w, age из a
     */

    static void task123() {
        Animal barsik = new Animal("Barsik", 5.1, 6);
        barsik.printInfo();
        System.out.println(barsik.isOld());
        System.out.println(barsik.name);
    }

    static void finalKeyword() {
        final int i;
        i = 5;
        System.out.println(i * 2);
//        i = 10;
        final int j = 5;
//        j = 10;

        FinalExample fe1 = new FinalExample();
        System.out.println(fe1.number);
//        fe1.number = 5;

        FinalExample fe2 = new FinalExample(10);
        System.out.println(fe2.number);
//        fe2.number = 11;
    }

    static void staticKeyword() {
        // Статические поля/методы относятся к классу, а не к конкретным объектам
        Animal.printCount();
        Animal barsik = new Animal("Barsik", 5.1, 6);
        Animal.printCount();
        System.out.println(barsik.id);
        Animal vasilisa = new Animal("vasilisa", 5, 7);
        Animal.printCount();
        System.out.println(vasilisa.id);
    }

    static void abstraction() {
        // Абстракция
        // 1. Абстракция - набор полей и методов класса определяется предметной областью
        // 2. Абстракция - пользователю не важно знать как устроен объект для того чтобы с ним работать
    }

    static void extendsKeyword() {
        // Наследование - возможность создать класс на основе другого класса
        Dog d = new Dog("Шарик", 10, 8, 0.5);
        d.printInfo();
        d.printTail();
    }

    // task4
    /*
    Создать класс Parrot, который наследуется от Animal
    У него будет 1 дополнительное поле: ширина крыльев в дробном числе (wingWidth)
    Создать два конструктора: 1 пустой, другой под все поля
    Переопределить метод printInfo(), чтобы он выводил в добавок информацию про крылья
    Добавить новый метод saySomething(), который выводит в консоль "name не дурак"
     */

    public static void main(String[] args) {
        // Максимум и минимум в массиве
//        arrayAlgorithms();

        // ООП
//        noOOP();
//        oop();

        // Конструкторы
//        constructors();

//        task123();

//        finalKeyword();

//        staticKeyword();

        extendsKeyword();
    }
}
