package lesson11;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    static void orm() {
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:person.db")) {
            PersonDAO personDAO = new PersonDAO(connection);

//            Person p = new Person("Vasiliy", "123qwe1", 25);
//            p.id = personDAO.addPerson(p);
//            System.out.println(p);

//            System.out.println(personDAO.getAllPersons());
//
//            System.out.println(personDAO.getPersonById(1));
//            System.out.println(personDAO.getPersonById(3));
//            System.out.println(personDAO.getPersonById(4));
//
//            System.out.println(personDAO.deletePerson(4));
//            System.out.println(personDAO.deletePerson(3));
//            System.out.println(personDAO.getPersonById(3));

//            System.out.println(personDAO.changePerson(3, new Person("a", "b", 3)));
//            System.out.println(personDAO.changePerson(2, new Person("Vasiliy", "qwezxc", 24)));
//            System.out.println(personDAO.getPersonById(2));
//            System.out.println(personDAO.getAllPersons());

            System.out.println(personDAO.getAllPersons());
            personDAO.incrementAge(1);
            System.out.println(personDAO.getAllPersons());
        } catch (SQLException throwables) {
            System.out.println(throwables.getMessage());
        }
    }

    /*
    Создать подключение к базе данных "songs.db"
    Создать таблицу songs с тремя столбцами:
        id - целое число primary key,
        name - текстовый столбец не нулевой
        date - номер года
    Создать в таблице две строки с любым содержимым
    Запросить все строки, вывести в формате
    "Аудиотрек #1 с названием "Highway to Hell" выпущен в 1975 году"
     */
    static void task1() {

    }

    static void assertions() {
        assert 1==2;
    }

    static void streamAPI() {
        List<Integer> list = new LinkedList<>();
        list.add(5);
        list.add(7);
        list.add(2);
        list.add(-1);
        list.add(7);
        list.add(10);
        list.add(0);
        List<Integer> list2 = list.stream()
                .filter(x -> x > 0)
                .distinct()
                .map(x -> x + 2)
                .sorted()
                .collect(Collectors.toList());

        int sum = list.stream()
                .filter(x -> x > 0)
                .distinct()
                .map(x -> x + 2)
                .sorted()
                .reduce(0, (acc, elem) -> acc = acc + elem);
        System.out.println(list2);
        System.out.println(sum);
    }

    public static void main(String[] args) {
        orm();
        task1();
        assertions();
        streamAPI();
    }
}
