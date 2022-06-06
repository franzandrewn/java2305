package lesson7;

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {

    static void scanner() {
        try (Scanner sc = new Scanner(new FileInputStream("numbers.txt"))) {
            int i = sc.nextInt();
            double d = sc.nextDouble();
            long l = sc.nextLong();
            System.out.println(i + " " + d + " " + l);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        try (Scanner sc = new Scanner(new FileInputStream("words.txt"))) {
            while (sc.hasNext()) {
//                System.out.println(sc.next());
                if (sc.hasNextInt()) {
                    System.out.println("int " + sc.nextInt());
                } else if (sc.hasNextDouble()) {
                    System.out.println("double " + sc.nextDouble());
                } else if (sc.hasNextLong()) {
                    System.out.println("long " + sc.nextLong());
                } else {
                    System.out.println(sc.next());
                }
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    static void formatting() {
        Person p = new Person("Andrew", 23);
        System.out.println("Человек с именем " + p.name + " и возрастом " + p.age);

        // Форматированный вывод - задание формы вывода + данных, которые надо в эту форму подставить
        // %s - строка, %d - число, %f - дробное число
        System.out.printf("Человек с именем %s, возрастом %d\n", p.name, p.age);

        System.out.printf("%f\n", Math.PI);
        System.out.printf("%f\n", Math.E);

        System.out.printf("%f, %1$+20.10f, %1$.2f \n", Math.PI);

        String example = String.format(Locale.US, "%f", Math.PI);
        System.out.println(example);
        example = String.format("%td %1$tB %1$tY", new Date());
        System.out.println(example);
        example = String.format(Locale.US, "%td %1$tB %1$tY", new Date());
        System.out.println(example);
        example = String.format("%tF", new Date());
        System.out.println(example);
        example = String.format(Locale.forLanguageTag("ru"), "%tc", new Date());
        System.out.println(example);
        example = String.format(Locale.forLanguageTag("ru"), "%ta %1$tb %1$td %1$tT %1$tZ %1$tY", new Date());
        System.out.println(example);
    }

    static void objectStreams() {
        // Сериализация - превращение объекта в набор байт/символов
        // Десериализация - восстановление объекта из набора байт/символов
        Person p = new Person("Andrew", "123asd", 23);
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("andrew.txt"))) {
            // Сериализация объекта в поток байт
            out.writeObject(p);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        Person p2 = new Person();
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("andrew.txt"))) {
            p2 = (Person) in.readObject();
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }

        System.out.println(p + " hashcode: " + p.hashCode());
        System.out.println(p2 + " hashcode: " + p2.hashCode());

        System.out.println(p == p2);
        System.out.println(p.equals(p2));
    }

    static void aggregation() {
        // Агрегация - хранения в одном объекте ссылки на другой объект
        Boat b = new Boat("Andrew", 4, 5);
        b.move();
        b.turnBoatOn();
        b.move();

        // Агрегация - альтернатива наследованию, т.е. возможность расширить объекты класса без наследования
        LimitedString str = new LimitedString("123");
        System.out.println(str);
        System.out.println(str.length());
    }


    static void arrayLists() {
        double[] doubleArr = new double[]{1, 2, 3};

        // Списки - набор упорядоченных элементов одного и того же типа, который может меняться по длине
        ArrayList<Double> doubleList = new ArrayList<>();
        System.out.println(doubleList);
        // Добавление в конец списка
        doubleList.add(1.0);
        doubleList.add(2.0);
        doubleList.add(3.0);
        System.out.println("После добавления 1,2,3 в конец: " + doubleList);
        System.out.println("Длина после добавления 1,2,3 в конец: " + doubleList.size());

        // add(index, element) - добавление element на определенный индекс
        doubleList.add(1, 4.0);
        System.out.println("После добавления 4 на индекс 1: " + doubleList);

        // Удаление по индексу
        doubleList.remove(1);
        System.out.println("После удаления с индекса 1: " + doubleList);

        // Удалить по значению
        doubleList.remove(2.0);
        System.out.println("После удаления первого встреченного элемента 2.0: " + doubleList);

        // Взять значение по индексу
        System.out.println("Элемент на индексе 1: " + doubleList.get(1));

        // изменить значение по индексу
        doubleList.set(1, -3.1);
        System.out.println("Элемент на индексе 1 после set(): " + doubleList.get(1));

        // Проверить пуст ли список
        System.out.println("'Список пуст' = " +  doubleList.isEmpty());

        // Узнать есть ли элемент в списке
        System.out.println("'-3.1 есть в списке' = " + doubleList.contains(-3.1));
        // На каком индексе находится элемент в списке
        System.out.println("-3.1 на индексе: " + doubleList.indexOf(-3.1));
        System.out.println("Последний -3.1 на индексе: " + doubleList.lastIndexOf(-3.1));
        System.out.println("0 на индексе: " + doubleList.indexOf(0));

        ArrayList<Integer> intList = new ArrayList<>();
        intList.add(1);
        intList.add(2);
        intList.add(3);
        intList.add(4);
        intList.add(5);

        System.out.println("intList до удаления по индексу 2: " + intList);
        intList.remove(2);
        System.out.println("intList после удаления по индексу 2: " + intList);

        System.out.println("intList до удаления по значению 2: " + intList);
        intList.remove(Integer.valueOf(2));
        System.out.println("intList после удаления по значению 2: " + intList);

        System.out.println("Элемент 4 на индексе: " + intList.indexOf(4));

        System.out.println("Подсписок с 1 индекса до 3 индекса: " + intList.subList(1,3));

        ArrayList<Person> persons = new ArrayList<>();
        persons.add(new Person("Andrew", 23));
        persons.add(new Person("Vasya", "123", 25));
        System.out.println(persons);
    }

    static void linkedLists() {
        // Списки - набор упорядоченных элементов одного и того же типа, который может меняться по длине
        LinkedList<Double> doubleList = new LinkedList<>();
        System.out.println(doubleList);
        // Добавление в конец списка
        doubleList.add(1.0);
        doubleList.add(2.0);
        doubleList.add(3.0);
        System.out.println("После добавления 1,2,3 в конец: " + doubleList);
        System.out.println("Длина после добавления 1,2,3 в конец: " + doubleList.size());

        // add(index, element) - добавление element на определенный индекс
        doubleList.add(1, 4.0);
        System.out.println("После добавления 4 на индекс 1: " + doubleList);

        // Удаление по индексу
        doubleList.remove(1);
        System.out.println("После удаления с индекса 1: " + doubleList);

        // Удалить по значению
        doubleList.remove(2.0);
        System.out.println("После удаления первого встреченного элемента 2.0: " + doubleList);

        // Взять значение по индексу
        System.out.println("Элемент на индексе 1: " + doubleList.get(1));

        // изменить значение по индексу
        doubleList.set(1, -3.1);
        System.out.println("Элемент на индексе 1 после set(): " + doubleList.get(1));

        // Проверить пуст ли список
        System.out.println("'Список пуст' = " +  doubleList.isEmpty());

        // Узнать есть ли элемент в списке
        System.out.println("'-3.1 есть в списке' = " + doubleList.contains(-3.1));
        // На каком индексе находится элемент в списке
        System.out.println("-3.1 на индексе: " + doubleList.indexOf(-3.1));
        System.out.println("Последний -3.1 на индексе: " + doubleList.lastIndexOf(-3.1));
        System.out.println("0 на индексе: " + doubleList.indexOf(0));

        LinkedList<Integer> intList = new LinkedList<>();
        intList.add(1);
        intList.add(2);
        intList.add(3);
        intList.add(4);
        intList.add(5);

        System.out.println("intList до удаления по индексу 2: " + intList);
        intList.remove(2);
        System.out.println("intList после удаления по индексу 2: " + intList);

        System.out.println("intList до удаления по значению 2: " + intList);
        intList.remove(Integer.valueOf(2));
        System.out.println("intList после удаления по значению 2: " + intList);

        System.out.println("Элемент 4 на индексе: " + intList.indexOf(4));

        System.out.println("Подсписок с 1 индекса до 3 индекса: " + intList.subList(1,3));

        LinkedList<Person> persons = new LinkedList<>();
        persons.add(new Person("Andrew", 23));
        persons.add(new Person("Vasya", "123", 25));
        System.out.println(persons);
    }

    /*
    Спросить у пользователя целое число n
    Создать пустой список (ArrayList или LinkedList)
    С помощью цикла спросить у пользователя n дробных чисел и добавить их в список
    Вывести список на экран

    Поменять значениями первый и последний элемент
    Вывести список на экран

    Вывести информацию о том, есть ли внутри списка 0.0
     */
    static void task1() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        LinkedList<Double> list = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            double d = sc.nextDouble();
            list.add(d);
        }
        System.out.println(list);


        int length = list.size();
        double first = list.get(0);
        double last = list.get(length - 1);

        list.set(0, last);
        list.set(length - 1, first);
        System.out.println(list);

        System.out.println(list.contains(0.0));
    }

    public static void main(String[] args) {
        // Сканер
//        scanner();
        // Форматированный вывод
//        formatting();
        // Потоки ввода/вывода объектов (Java сериализация)
//        objectStreams();
        // Агрегация
//        aggregation();
        // Java Collection Framework - набор интерфейсов, абстрактных классов и классов для хранения большого количества элементов
        // Список на основе массивов
//        arrayLists();
        // Связанный список (на основе узлов)
//        linkedLists();
        // task1
        task1();
    }
}
