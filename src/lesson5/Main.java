package lesson5;

import lesson4.Animal;

import java.util.Arrays;
import java.util.Scanner;
import java.net.*;

public class Main {
    static void polymorphism() {
        // Полиморфизм - возможность работы метода с разными наборами аргументов
        // 1. "Истинный" полиморфизм - один код для разных наборов аргументов
        // 2. "Мнимый" полиморфизм (ad-hoc) - код для каждого набора аргументов
        // 2.1. Приведение типов
//        System.out.println(add(1, 4));
//        System.out.println(add(2.4, 2.5));
        // 2.2. Перегрузка методов - наличие нескольких методов с одинаковым именем (но разными наборами аргументов)
        System.out.println(add(1, 2));
        System.out.println(add(1.1, 2.2));
        System.out.println(add("1a", "bc"));
    }

    // Сигнатура - имя метода + набор аргументов
    static int add(int x, int y) {
        System.out.println("int");
        return x + y;
    }

    static double add(double x, double y) {
        System.out.println("double");
        return x + y;
    }

    static String add(String x, String y) {
        System.out.println("String");
        return x.concat(y);
    }

    static void packages() {
        // Package (пакет) - директория с Java файлами или подпакетами, позволяет структурированно хранить код\
        Animal a = new Animal("Barsik", 3, 4);
    }

    static void encapsulation() {
        // Инкапсуляция
        // 1. Наличие в языке возможности объединить определение данных и действия над данными в одну "капсулу"
        // 2. Возможность ограничивать взаимодействие одних частей программы с другими частями программы
        Balance b = new Balance();
//        b.clientId = 2; // clientId имеет private модификатор доступа, поэтому нигде кроме Balance упомянут быть не может
        b.date = "2022-06-01"; // protected доступен внутри пакета
        b.balance = 10000; // default доступен внутри пакета
        b.description = "Новый счет"; // public Доступен внутри пакета
        // Модификаторы доступа
        // public - открыто всем
        // protected - открыто внутри пакета и наследникам (вне зависимости от пакета)
        // default - открыто внутри пакета
        // private - доступно только самому классу
    }

    static void object() {
        Balance b = new Balance(1, "2022-06-1", 10000, "Новый счет");

        System.out.println(b);
        String bOut = "b is " + b;
        System.out.println(bOut);

        Balance b2 = new Balance(1, "2022-06-02", 10001, "Второй счет");
        System.out.println(b == b2);
        System.out.println(b.equals(b2));

        System.out.println(b.hashCode());
        System.out.println(b2.hashCode());

        Balance b3 = new Balance(1, "2022-06-1", 10000, "Новый счет");
        System.out.println(b3.hashCode());

        System.out.println(Balance.class);
        System.out.println(b.getClass().getName());
        System.out.println(b.getClass().getSimpleName());
//        System.out.println(Arrays.toString(Balance.class.getConstructors()));
//        System.out.println(Arrays.toString(Balance.class.getFields()));
    }

    static void finalContinue() {
    }

    static void abstractKeyword() {
        // abstract - модификатор для классов/методов
        // abstract класс - у класса нельзя создать объект
//        ChessFigure cf = new ChessFigure();
        // abstract метод (внутри abstract класс) - метод без реализации (без {}), который наследники ОБЯЗАНЫ переопределить
        ChessFigure cf1 = new Queen();
        cf1.move(1, 1);
    }

    static void interfaces() {
        // Интерфейс - структурная единица, которая описывает поведение
        // Возможно множественная реализация интерфейсов
        // Абстрактный класс vs Интерфейсы - невозможно множественное наследование
        // У классов не связанных иерархией наследования возможно наличие похожего поведения
        Swimming swimming1 = new Duck();
        Swimming swimming2 = new Ship();
        swimming1.swim();
        swimming2.swim();
        objectSwim(swimming1);
        objectSwim(swimming2);
//        swimming1.name = "1";
//        swimming2.speed = 2.5;
    }

    static void objectSwim(Swimming swimming) {
        swimming.swim();
    }

    /*
    Создать final класс CircleMath
    Внутри private пустой конструктор
    Константа со значением PI (public static final)
    Статические методы, видные отовсюду (public):
    Вычисление длины окружности length (принимает дробное число radius, возвращает дробное число по формуле 2 * PI * radius)
    Вычисление площади окружности area (принимает дробное число radius, возвращает дробное число по формуле PI * radius * radius)
     */
    static void task1() {
        System.out.println(CircleMath.area(2));
        System.out.println(CircleMath.length(3));
    }

    public static void main(String[] args) {
//        polymorphism();
//        packages();
//        encapsulation();
//        object();
//        abstractKeyword();
//        interfaces();
        task1();
    }
}
