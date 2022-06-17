package lesson6;

import java.io.*;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    static void exceptionExample() {
//        System.out.println(5 / 0);
        int[] arr = new int[2];
//        System.out.println(arr[2]);
//        System.out.println(arr[-1]);
    }

    static void exceptionHandling() {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        if (b != 0) {
            System.out.println(a / b);
        } else {
            System.out.println("Введите не 0 (нельзя делить на 0)");
        }

        int[] arr = new int[]{a, b};
        if (a == 1 || a == 0) {
            System.out.println(arr[a]);
        } else {
            System.out.println("a не входит в диапазон");
        }

        if (b == 1 || b == 0) {
            System.out.println(arr[b]);
        } else {
            System.out.println("b не входит в диапазон");
        }
    }

    static void tryCatch() {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        try {
            System.out.println(a / b);
        } catch (ArithmeticException ex) {
            System.out.println("Введите не 0 (нельзя делить на 0)");
        }

        int[] arr = new int[]{a, b};

        try {
            System.out.println(arr[a]);
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("a не входит в диапазон");
        }

        try {
            System.out.println(arr[b]);
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("b не входит в диапазон");
        }
    }

    static void tryCatch2() {
        try {
            Scanner sc = new Scanner(System.in);
            int a = sc.nextInt();
            int b = sc.nextInt();
            System.out.println(a / b);

            int[] arr = new int[]{a, b};
            System.out.println(arr[a]);
            System.out.println(arr[b]);
        } catch (ArithmeticException ex) {
            System.out.println("Введите не 0 (нельзя делить на 0)");
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("Число a или b не входит в диапазон");
        } catch (InputMismatchException ex) {
            System.out.println("Введите целые числа");
        } finally {
            System.out.println("Выполняюсь вне зависимости от любых исключений или правильной работы");
        }
    }

    static void exceptionHierarchy() {
        // Обрабатываемые исключения - исключения, которые мы обязаны обработать (все остальные Exception)
        // Варианты обработки - try..catch или throws
        try {
            FileInputStream in = new FileInputStream(".giignore");
        } catch (FileNotFoundException ex) {
            System.out.println("Файл не найден");
            System.out.println(ex);
            System.out.println(ex.getMessage());
        } catch (Exception e) {
            System.out.println("исключение");
        }
        // Необрабатываемые исключения - исключения, которые мы не обязаны обрабатывать (RuntimeException и все его наследники)
//        System.out.println(5 / 0);
    }

    static void throwsKeyword() throws FileNotFoundException {
        FileInputStream in = new FileInputStream(".giignore");
    }

    static void psvm1() {
        try {
            String settings = loadSettings1();
        } catch (FileNotFoundException e) {
            System.out.println("Файла нет, создайте");
        } catch (IOException e) {
            System.out.println("Ошибка чтения");
        }

//        Сюда не дойдем, если нет файла
    }

    static String loadSettings1() throws IOException {
        FileInputStream in = new FileInputStream("settings.json");
        return String.valueOf(in.read());
    }

    static void psvm2() {
        String settings = loadSettings2();
        if (settings.isEmpty()) {
            createFile();
        }
        // Сюда дойдем, даже если файла нет
    }

    private static String loadSettings2() {
        try {
            FileInputStream in = new FileInputStream("settings.json");
            return String.valueOf(in.read());
        } catch (IOException e) {
            System.out.println("Файла с настройками не было, но я создал");
            return "";
        }
    }

    private static void createFile() {
        try {
            FileOutputStream out = new FileOutputStream("settings.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    static void throwKeyword() throws InputMismatchException {
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();
        if (i < 0) {
            throw new InputMismatchException("Число < 0");
        } else {
            System.out.println(i);
        }
    }

    static void newException() {
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();
        if (i < 0) {
            throw new NegativeInputException("Целое число < 0");
        } else {
            System.out.println(i);
        }
    }

    /*
    Спросить у пользователя две строки (использовать метод next() у Scanner)
    Первая строку сохранить в переменную login, вторую - в переменную password
    В случае если login или password меньше 6 символов или больше 50 -
        бросить RuntimeException с сообщением "Неверная длина логина/пароля"
    Если login содержится в password (у строк есть .indexOf() или .contains()) -
        бросить RuntimeException с сообщением "Логин не может быть внутри пароля"
    Если проблем нет, вывести "Регистрация пользователя с login завершена, ваш пароль: password"
    (пример - метод throwKeyword, можно не указывать throws)
     */
    static void task1() {
        Scanner sc = new Scanner(System.in);
        String login = sc.next();
        String password = sc.next();

        if (login.length() < 6 || login.length() > 50) {
            throw new RuntimeException("Неверная длина логина");
        } else if (password.length() < 6 || password.length() > 50) {
            throw new RuntimeException("Неверная длина пароля");
        } else if (password.indexOf(login) >= 0) {
            throw new RuntimeException("Логин не может быть внутри пароля");
        } else {
            System.out.println("Регистрация пользователя с " + login + " завершена, ваш пароль: " + password);
        }
    }

    static void byteStreams() {
        // Потоки ввода/вывода - набор классов и интерфейсов под считывание или запись данных в источники
        FileInputStream in = null;
        try {
            // Открытие файла - запуск чтения, создание "курсора" в начале файла
            in = new FileInputStream("testfile.txt");

            // После прочтения "курсор" сдвигается на 1 байт дальше
//            System.out.println(in.read());
//            System.out.println(in.read());
//            System.out.println(in.read());
//            System.out.println(in.read());
//            System.out.println(in.read());
//            System.out.println(in.read());
            // Символ с номером -1 - символ конца файла
//            System.out.println(in.read());
//            System.out.println(in.read());

            int i = in.read();
            while (i != -1) {
                System.out.println(i + " " + ((char) i));
                i = in.read();
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден");
        } catch (IOException e) {
            System.out.println("Ошибка чтения/записи");
        } finally {
            // Закрытие источника
            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    static void tryWithResources() {
        try (FileInputStream in = new FileInputStream("testfile.txt");
             FileOutputStream out = new FileOutputStream("testfile_copy.txt");
             SomeResource some = new SomeResource()) {
            int i = in.read();
            while (i != -1) {
                out.write(i);
                i = in.read();
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден");
        } catch (IOException e) {
            System.out.println("Ошибка чтения/записи");
        }
    }

    static void charStreams() {
//        try (FileInputStream in = new FileInputStream("testfile2.txt")) {
//            int i = in.read();
//            while (i != -1) {
//                System.out.println(i + " " + ((char) i));
//                i = in.read();
//            }
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        try (FileReader in = new FileReader("testfile2.txt");
             FileWriter out = new FileWriter("testfile2_copy.txt")) {
            int i = in.read();
            while (i != -1) {
                System.out.println(i + " " + ((char) i));
                out.write(i);
                i = in.read();
            }
        } catch (IOException e) {
            System.out.println("Ошибка ввода/вывода");
        }

        try (FileReader in = new FileReader("testfile2.txt")) {
            char[] chars = new char[4];
            in.read(chars);
            System.out.println(Arrays.toString(chars));
        } catch (IOException e) {
            System.out.println("Ошибка ввода/вывода");
        }
    }

    static void bufferedStreams() {
        try (BufferedInputStream in = new BufferedInputStream(new FileInputStream("testfile.txt"));
             BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream("testfile_copy.txt"));) {
            int i = in.read();
            while (i != -1) {
                out.write(i);
                i = in.read();
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден");
        } catch (IOException e) {
            System.out.println("Ошибка чтения/записи");
        }

        try (BufferedReader in = new BufferedReader(new FileReader("testfile2.txt"));
             BufferedWriter out = new BufferedWriter(new FileWriter("testfile2_copy.txt"))) {
            int i = in.read();
            while (i != -1) {
                System.out.println(i + " " + ((char) i));
                out.write(i);
                i = in.read();
            }
        } catch (IOException e) {
            System.out.println("Ошибка ввода/вывода");
        }
    }

    public static void main(String[] args) {
        // Исключения
        // Пример исключения
//        exceptionExample();
        // Обработка исключений через if
//        exceptionHandling();
        // Обработка исключений с помощью try..catch
//        tryCatch();
//        tryCatch2();
        // Иерархия исключений
//        exceptionHierarchy();
        // Ключевое слово throws
//        try {
//            throwsKeyword();
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
        // Ключевое слово throw
//        try {
//            throwKeyword();
//        } catch (Exception e) {
//            System.out.println("");
//        }
        // Своё исключение
//        newException();
        // task1
//        task1();
        // Потоки ввода/вывода
        // Поток байт (со старым try)
//        byteStreams();
        // Поток байт (с try with resources)
//        tryWithResources();
        // Поток символов
        charStreams();
        // Буферизированные потоки
        bufferedStreams();
    }

}
