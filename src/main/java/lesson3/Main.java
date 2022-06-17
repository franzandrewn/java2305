package lesson3;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    // синтаксис определения метода:
    // тип_возвращаемого_значения имя_метода(перечисление_входных_данных) {блок_кода}
    static void askAndPrint() {
        Scanner sc = new Scanner(System.in);
        int y = sc.nextInt();
        System.out.println(y * y);
    }

    public static void main(String[] args) {
        // Оператор continue - пропуск оставшегося кода в теле цикла, возврат к проверке условия
        int q = 7;
        while (q >= 0) {
            if (q == 4) {
                q--;
                continue;
            }
            System.out.println(q);
            q--;
        }
        q = 7;
        while (q >= 0) {
            if (q != 4) {
                System.out.println(q);
            }
            q--;
        }
        // Оператор break - пропуск оставшегося кода в теле цикла, переход к коду после цикла
        int w = 7;
        while (w >= 0) {
            if (w == 4) {
                w--;
                break;
            }
            System.out.println(w);
            w--;
        }
        w = 7;
        while (w > 4) {
            System.out.println(w);
            w--;
        }
        System.out.println("Команда после 4");

        // break с вводом пользователя
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите положительное число");
        int posInt;
        while (true) {
            posInt = sc.nextInt();
            if (posInt > 0) {
                break;
            } else {
                System.out.println("неверное число, введите положительное");
            }
        }

        System.out.println("Введите число не ноль");
        int notNull = sc.nextInt();
        while (notNull == 0) {
            System.out.println("Вы ввели ноль, введите не ноль");
            notNull = sc.nextInt();
        }

        // for..each - для каждого элемента
        double[] doubles = new double[]{1, 2, 4, 5, -10.2};
        System.out.println("Basic for");
        for (int i = 0; i < doubles.length; i++) {
            System.out.println(doubles[i]);
        }

        System.out.println("For each");
        for (double d: doubles) {
            System.out.println(d);
        }
        System.out.println(Arrays.toString(doubles));

        // Тернарный оператор
        // Синтаксический сахар - возможность языка "красиво"/"кратко" написать то, что было "некрасиво"/"некратко"
        int x = sc.nextInt();
        if (x < 0) {
            x = -x;
        }
        x = x < 0 ? -x : x;
        System.out.println(x);

        x = sc.nextInt();
        x = x < 0 ? -1 : 1;
        System.out.println(x);

        // Math - тип данных, содержащий в себе математические константы и операции
        System.out.println(Math.PI);
        System.out.println(Math.E);

        System.out.println(Math.abs(5));
        System.out.println(Math.abs(-5));

        System.out.println(Math.max(2, 123));
        System.out.println(Math.min(2, 123));

        // Возведение в степень: первое число - основание, второе - показатель степени
        System.out.println(Math.pow(2, 5));
        System.out.println(Math.pow(Math.PI, 2));

        System.out.println(Math.sqrt(2));
        System.out.println(Math.pow(2, 0.5));

        // Тригонометрические
        System.out.println(Math.sin(0));
        System.out.println(Math.cos(0));

        // Логарифмические
        System.out.println(Math.exp(1));
        System.out.println(Math.log(Math.E));
        System.out.println(Math.log10(100));

        System.out.println("round");
        System.out.println(Math.round(1.4));
        System.out.println(Math.round(1.5));
        System.out.println(Math.round(1.9));

        System.out.println("floor");
        System.out.println(Math.floor(1.4));
        System.out.println(Math.floor(1.5));
        System.out.println(Math.floor(1.9));

        System.out.println("ceil");
        System.out.println(Math.ceil(1.4));
        System.out.println(Math.ceil(1.5));
        System.out.println(Math.ceil(1.9));

        // Взятие случайного дробного числа от 0 (включая) до 1 (не включая)
        double random = Math.random();
        System.out.println(random);

        // Взятие случайного дробного числа от 0 (включая) до 3 (не включая)
        System.out.println(3 * random);

        // Взятие случайного целого числа от 0 (включая) до 3 (не включая)
        System.out.println((int) (3 * random));

        // Случайное число от -50 до 50
        // "Правильная" работа со случайными величинами через ThreadLocalRandom
        // https://stackoverflow.com/questions/363681/how-do-i-generate-random-integers-within-a-specific-range-in-java
        System.out.println(((int) (101 * random)) - 50);

        // Arrays
        int[] arrInt = new int[]{5, 2, 3, -100, 7, 6};
        System.out.println(arrInt + " " + Arrays.toString(arrInt));

        int[] arrInt2 = new int[]{5, 2, 3, -100, 7, 6};
        System.out.println(arrInt2 + " " + Arrays.toString(arrInt2));

        // Сравнение массивов на равенство
        System.out.println(arrInt == arrInt2);
        System.out.println(Arrays.equals(arrInt, arrInt2));

        Arrays.sort(arrInt);
        System.out.println("arrInt = " + Arrays.toString(arrInt));

        Arrays.sort(arrInt2, 1, 4);
        System.out.println("arrInt2 = " + Arrays.toString(arrInt2));

        // Поиск элемента в отсортированном массиве
        System.out.println(Arrays.binarySearch(arrInt, 3));
        System.out.println(Arrays.binarySearch(arrInt, 4));

        // Подпрограммы (метод в Java) - именованные части кода
        // с возможностью принять входные данные, сделать над ними действия и выдать результат
        // Запуск подпрограммы (вызов метода) - упоминание имени метода с круглыми скобочками в которых набор входных значений
        askAndPrint();
        askAndPrint();

        // в момент вызова метода в круглых скобочках нужно перечислить значения для аргументов
        // (столько же и такого же типа как в определении метода)
        // Метод, принимающий целое число и выводящий в консоль куб этого числа
        printCube(2);
        printCube(5);
//        printCube(2.5);

        printAdd(1 + 0.5, -1.51);
        printAdd(1, 5);
        x = sc.nextInt();
        double y = sc.nextDouble();
        printAdd(x, y);

        System.out.println(add(5, 10));
        System.out.println(add(-1, 10000));
        // возвращаемое значение можно использовать дальше где угодно (вывод, в переменных, в вычислениях)
        int sum5and10 = add(5, 10);

        // Область видимости (scope)
        // Все переменные созданные в блоке кода относятся только к этому блоку кода и не видны извне / во вложенных блоках кода
        int k = 10;
        scopeExample();
        System.out.println(k);

        if (true) {
            k = 12;
            int j = 13;
            System.out.println(j);
        }
        System.out.println(k);

        // Запуск методов из методов
        a();

        // Передача аргументов по значению и по ссылке (by valye / by reference)
        int p = 13;
        System.out.println("p до изменения: " + p);
        changeInt(p);
        System.out.println("p после изменения: " + p);

        int[] pArr = new int[]{13};
        System.out.println("pArr до изменения: " + Arrays.toString(pArr));
        changeArr(pArr);
        System.out.println("pArr после изменения: " + Arrays.toString(pArr));

        // Алгоритмы с массивами
        int[] ints = new int[]{1, 4, 6, -10};
        int indexOf4 = search(ints, 4);
        System.out.println("четверка на " + indexOf4 + " индексе");
        int indexOf5 = search(ints, 5);
        System.out.println("пятерка на " + indexOf5 + " индексе");
    }

    static int search(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }

    static void changeArr(int[] arr) {
        arr[0] = 100;
    }

    static void changeInt(int number) {
        number = 100;
    }

    // внутри круглых скобочек - набор параметров (аргументов)
    static void printCube(int x) {
        System.out.println(x * x * x);
    }

    static void printAdd(double first, double second) {
        System.out.println(first + second);
    }

    // тип возвращаемого значение - любой тип Java
    static int add(int x, int y) {
        // внутри блока кода обязательно надо что-нибудь вернуть через ключевое return
        return x + y;
    }

    static void scopeExample() {
//        k = 11;
        int k = 11;
    }

    static void a() {
        System.out.println("before b");
        int x = 1;
        b();
        System.out.println("after b");
    }

    static void b() {
        System.out.println("before c");
        int x = 100;
        c();
        System.out.println("after c");
    }

    static void c() {
        double x = 1.00001;
        System.out.println("c");
    }
}
