package lesson2;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // ввод пользователя
        // Scanner - тип данных, позволяющий спрашивать значения разных типов у пользователя
        // System.in - переменная отвечающая за ввод пользователя в консоли
        // Во время создания Scanner создается курсор, который стоит в начале ввода пользователя
        Scanner sc = new Scanner(System.in);
        // nextИмя_примитивного_типа - действия, считывающее из консоли слово и превращающее в значения правильного типа
        System.out.println("Введите целое число, я выведу число на 1 больше");
        System.out.println(sc.nextInt() + 1);
        System.out.println("Введите дробное число, я его повторю");
        // После действия nextИмя_примитивного_типа, курсор остается в конце значения
        double d = sc.nextDouble();
        System.out.println(d);

        sc.nextLine(); // Нужна на случай сочетания next действий с nextLine()
        // nextLine считывает все символа начиная с курсора и заканчивая новой строкой
        String s = sc.nextLine();
        System.out.println("Ваша строка: " + s);
        System.out.println("Пустая ли строка: " + s.isEmpty());

        // Логические операторы
        System.out.println("Введите номер дня недели");
        int day = sc.nextInt();
        if (day > 7) {
            System.out.println("Неверный номер");
        }
        if (day < 1) {
            System.out.println("Неверный номер");
        }
        if ((day >= 1) && (day <= 7)) {
            System.out.println("Номер дня недели получен");
        } else {
            System.out.println("Неверный номер");
        }

        // Логическое отрицание (НЕ, NOT) - "переворачивает" значение, т.е. true -> false, false -> true
        System.out.println("Логическое отрицание");
        System.out.println(!true);
        System.out.println(!false);
        // Логическое умножение (И, AND) - результат истина только если оба элемента истина
        System.out.println("Логическое умножение");
        System.out.println(false && false);
        System.out.println(false && true);
        System.out.println(true && false);
        System.out.println(true && true);
        // Логическое сложение (ИЛИ, OR) - результат ложь только если оба элемента ложь
        System.out.println("Логическое сложение");
        System.out.println(false || false);
        System.out.println(false || true);
        System.out.println(true || false);
        System.out.println(true || true);

        // task1
        /*
        Спросить у пользователя целое число
        Если число находится в диапазоне 1-100, вывести "+", в обратном случае вывести "-"
         */
        int x = sc.nextInt();
		// Альтернативное написение - (1 <= x && x <= 100)
        if (x >= 1 && x <= 100) {
            System.out.println("+");
        } else {
            System.out.println("-");
        }

        // Вложенный if
        x = sc.nextInt();
        if (x > 0) {
            System.out.println("+");
        }
        if (x < 0) {
            System.out.println("-");
        }
        if (x == 0) {
            System.out.println("0");
        }

        if (x > 0) {
            System.out.println("+");
        } else {
            if (x < 0) {
                System.out.println("-");
            } else {
                System.out.println("0");
            }
        }

        // else if
        if (x > 0) {
            System.out.println("+");
        } else if (x < 0) {
            System.out.println("-");
        } else {
            System.out.println("0");
        }

        if (day == 1) {
            System.out.println("Понедельник");
        } else if (day == 2) {
            System.out.println("Вторник");
        } else if (day == 3) {
            System.out.println("Среда");
        } else if (day == 4) {
            System.out.println("Четверг");
        } else if (day == 5) {
            System.out.println("Пятница");
        } else if (day == 6) {
            System.out.println("Суббота");
        } else if (day == 7) {
            System.out.println("Воскресенье");
        } else {
            System.out.println("Неверный день");
        }

        // switch
        switch (day) {
            case 1:
                System.out.println("Понедельник");
                break;
            case 2:
                System.out.println("Вторник");
                break;
            case 3:
                System.out.println("Среда");
                break;
            case 4:
                System.out.println("Четверг");
                break;
            case 5:
                System.out.println("Пятница");
                break;
            case 6:
                System.out.println("Суббота");
                break;
            case 7:
                System.out.println("Воскресенье");
                break;
            default:
                System.out.println("неверный день");
        }

        // Массивы - упорядоченный набор элементов одного типа неизменной длины
        // Создание массивов: int[] - тип данных (массив целых чисел int), ints - имя массива
        int[] ints;
		// Инициализация массива
		// 1 способ: по количеству элементов
        ints = new int[5];
        System.out.println(Arrays.toString(ints));
		// 2 способ: по значениям элементов
        ints = new int[]{4, 6, 9, -1000};
		// Узнать длину массива
        System.out.println(ints.length);
		// Получить значение по индексу
        System.out.println(ints[3]);
        System.out.println(ints[0]);
		// Поменять элемент по его индексу
        ints[0] = 1000;
        System.out.println(ints[0]);
		// Вывод в консоль
        System.out.println(ints);
        System.out.println(Arrays.toString(ints));
        String[] strs = new String[10];
        System.out.println(Arrays.toString(strs));

        // Циклы - возможность повтора блока кода какое-то количество раз
        // Цикл while (пока) - цикл с неизвестным количеством повторений
        int i = 5;
        while (i > 0) {
            System.out.println(i);
            i = i - 1;
        }
        System.out.println("Окончание цикла");
        System.out.println("i = " + i);

        String qwe = "5";
        while (!qwe.isEmpty()) {
            qwe = qwe + "qweasdlkjfasdjlkfhasdjlkjhkasdfjhlkfjhlkasdflkasdflkadflkasdfjlkashflkasjhflkasjhdflkasjhdf";
        }
        // Цикл for  - цикл с известным количеством повторений
        for (int j = 5; j > 0; j = j - 1) {
            System.out.println(j);
        }

        // Работа с массивами с помощью циклов
        int[] arrInt = new int[]{4, 5, 10, -10, -2, 58};
        for (int j = 0; j < arrInt.length; j = j + 1) {
            System.out.println(j + " " + arrInt[j]);
        }
        int[] arrInt2 = new int[100];
        for (int j = 0; j < arrInt2.length; j = j + 1) {
            arrInt2[j] = j + 1;
        }
        System.out.println(Arrays.toString(arrInt2));
        int len = sc.nextInt();
        int[] arrInt3 = new int[len];
        for (int j = 0; j < arrInt3.length; j = j + 1) {
            arrInt3[j] = j + 1;
        }
        System.out.println(Arrays.toString(arrInt3));

        System.out.println("Введите количество элементов");
        int n = sc.nextInt();
        if (n <= 0) {
            System.out.println("Неверный ввод, повторите запуск");
        } else {
            double[] doubles = new double[n];
            for (int j = 0; j < doubles.length; j = j + 1) {
                System.out.println("Введите " + (j + 1) + " число");
                doubles[j] = sc.nextDouble();
            }
            System.out.println("Ваши элементы " + Arrays.toString(doubles));
        }

        // Сокращенные действия с переменными
        int a = 13;
        a = a + 4;
        a += 4;
        System.out.println(a);
        a = a - 4;
        a -= 4;
        System.out.println(a);
        a = a * 2;
        a *= 2;
        System.out.println(a);
        a = a / 2;
        a /= 2;
        System.out.println(a);
        a = a % 10;
        a %= 10;
        System.out.println(a);
        a++;
        System.out.println(a);
        a--;
        System.out.println(a);
		// Разница между постфиксной и префиксной записью
        a = 0;
        int b = a++;
        System.out.println(b);
        a = 0;
        b = ++a;
        System.out.println(b);

        // task2
        /*
        Создать массив целых чисел int из 6 каких-нибудь значений
        С помощью цикла for выведите все числа на экран по одному в строке
         */
        System.out.println("task2");
        int[] integers = new int[]{5, 1, 2, 3, 54, 100};
        for (int j = 0; j < integers.length; j++) {
            System.out.println(integers[j]);
        }

        // task3
        /*
        С помощью цикла for все четные элементы увеличить на 1
        (Число n четное, если условие n % 2 == 0 имеет значение true)
         */
        System.out.println("task3");
        for (int j = 0; j < integers.length; j++) {
            int temp = integers[j];
            if (integers[j] % 2 == 0) {
                System.out.println(temp + 1);
                integers[j] += 1;
            }
        }
        System.out.println(Arrays.toString(integers));
    }
}
