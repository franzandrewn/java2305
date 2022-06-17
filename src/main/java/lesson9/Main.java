package lesson9;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lesson7.Person;

import java.lang.reflect.Modifier;
import java.util.*;

public class Main {
    static void patterns() {
        // Паттерны проектирования - решения часто встречаемых проблем в ООП (и не только)
    }

    static void singletonExample() {
        Singleton singleton1 = Singleton.getInstance("first singleton");
        System.out.println(singleton1.value);

        Singleton singleton2 = Singleton.getInstance("second singleton");
        System.out.println(singleton2.value);
    }

    static void decoratorExample() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Нужны ли оповещения VK");
        boolean vkNeeded = sc.nextBoolean();
        System.out.println("Нужны ли оповещения SMS");
        boolean smsNeeded = sc.nextBoolean();

        Notifier notifier = new EmailNotifier();
        if (vkNeeded) {
            notifier = new VkNotifier(notifier);
        }
        if (smsNeeded) {
            notifier = new SmsNotifier(notifier);
        }

        notifier.sendNotify();
    }

    static void iteratorExample() {
        // Итератор - объект для обхода структуры данных в определнном порядке
        LinkedList<Integer> list = new LinkedList<>();
        list.add(4);
        list.add(1);
        list.add(6);
        list.add(-1);
        list.add(10);
        list.add(11);
        list.add(8);
        list.add(4);
        list.add(5);

        Iterator<Integer> iterator = list.listIterator();
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());

        System.out.println("List:");
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        HashSet<Integer> set = new HashSet<>();
        set.add(4);
        set.add(1);
        set.add(-100);

        iterator = set.iterator();
        System.out.println("Set:");
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    static void gson() {

//        System.out.println(gson.toJson(1));            // ==> 1
//        System.out.println(gson.toJson("abcd"));       // ==> "abcd"
//        System.out.println(gson.toJson(10L)); // ==> 10
//        int[] values = { 1 };
//        System.out.println(gson.toJson(values));
//
//        int one = gson.fromJson("1", int.class);
//        Integer i = gson.fromJson("1", Integer.class);
//        Long l = gson.fromJson("1", Long.class);
//        Boolean b = gson.fromJson("false", Boolean.class);
//        String str = gson.fromJson("\"abc\"", String.class);
//        String[] anotherStr = gson.fromJson("[\"abc\"]", String[].class);
//        System.out.println(one);
//        System.out.println(i);
//        System.out.println(l);
//        System.out.println(b);
//        System.out.println(str);
//        System.out.println(Arrays.toString(anotherStr));

        // Сериализация
        Gson gson = new Gson();
        Person person = new Person("Andrew", 23);
        String personJson = gson.toJson(person);
        System.out.println(personJson);

        // Десериализация
        Person person2 = gson.fromJson(personJson, Person.class);
        System.out.println(person);
        System.out.println(person2);
        System.out.println(person==person2);

        Human john = new Human("John",
                "Smith",
                true,
                27,
                new Address("21 2nd Street",
                        "New York",
                        "NY",
                        "10021-3100"
                ),
                new PhoneNumber[]{
                        new PhoneNumber("home", "212 555-1234"),
                        new PhoneNumber("office", "646 555-4567")
                },
                new Human[0],
                null);

        Gson prettyGson = new GsonBuilder().setPrettyPrinting().serializeNulls().create();
        String johnJson = prettyGson.toJson(john);
        System.out.println("John with pretty printing Gson:\n" + johnJson);

        Human human = gson.fromJson("{\"firstName\":\"John\",\"lastName\":\"Smith\",\"isAlive\":true,\"age\":27,\"address\":{\"streetAddress\":\"21 2nd Street\",\"city\":\"New York\",\"state\":\"NY\",\"postalCode\":\"10021-3100\"},\"phoneNumbers\":[{\"type\":\"home\",\"number\":\"212 555-1234\"},{\"type\":\"office\",\"number\":\"646 555-4567\"}],\"children\":[]}", Human.class);
        System.out.println("Deserialized john: " + human);

        Gson exposeGson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
        System.out.println("Only exposed fields John:\n" + exposeGson.toJson(john));

        Gson blackListGson = new GsonBuilder().excludeFieldsWithModifiers(Modifier.PRIVATE, Modifier.TRANSIENT).create();
        System.out.println("John without private, transient fields: \n" + blackListGson.toJson(john));
//        System.out.println("asb".compareTo("asa"));
    }

    /*
    Взять Gson как библиотеку для проекта:
    найти страницу github у gson, пройти по ссылке скачивания jar, скачать jar
    в настройках проекта (Project Structure -> Libraries) добавить этот файл как библиотеку
    Объект любого класса превратить в строку с JSON и вывести её на экран
    Восстановить объект из строки JSON в новую переменную
    Вывести первоначальный и восстановленный объект (желательно добавить в класс toString())
     */
    static void task1() {

    }

    static void objectExample() {
        Address a1 = new Address("a", "b", "c", "d");
        Address a2 = new Address("a", "b", "c", "d");

        System.out.println(a1 == a2);
        System.out.println(a1.equals(a2));

        System.out.println(a1.hashCode());
        System.out.println(a2.hashCode());

    }

    public static void main(String[] args) {
//        singletonExample();
//        decoratorExample();
//        iteratorExample();
//        gson();
        objectExample();
    }
}
