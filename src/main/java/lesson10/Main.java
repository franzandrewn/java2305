package lesson10;

import java.sql.*;

public class Main {
    static void jdbcExample() {
        String url = "jdbc:sqlite:test.db";
        try (Connection conn = DriverManager.getConnection(url)) {
//            System.out.println(conn);
            Statement statement = conn.createStatement();

            statement.executeUpdate("CREATE TABLE IF NOT EXISTS persons(" +
                    "name TEXT UNIQUE, " +
                    "age INTEGER" +
                    ");");

            // Добавление строк в таблицу
//            statement.executeUpdate("INSERT INTO persons(name, age) VALUES ('Andrew', 23);");
//            statement.executeUpdate("INSERT INTO persons(name, age) VALUES ('Viktoria', 23);");
//            statement.executeUpdate("INSERT INTO persons(name, age) VALUES ('Vasiliy', 25);");

            // Удаление строк из таблицы
//            statement.executeUpdate("DELETE FROM persons");

            // Запрос данных из бд
            ResultSet rs;
            // Взятие всех строк
            rs = statement.executeQuery("SELECT name, age FROM persons;");
            // Взятие строк с сортировкой по имени (убывание) и возрасту (возрастание)
            rs = statement.executeQuery("SELECT name, age FROM persons ORDER BY name DESC, age ASC;");
            // Взятие строк с фильтрацие по возрасту<24 и имени, начинающегося с V
            rs = statement.executeQuery("SELECT name, age FROM persons WHERE age<24 AND name LIKE 'V%';");
            while (rs.next()) {
                System.out.printf("Person with name %s, age %d\n",
                        rs.getString("name"),
                        rs.getInt("age"));
            }
        } catch (SQLException throwables) {
            System.out.println("Sql исключение: " + throwables.getMessage());
        }
    }

    static void references() {
        String url = "jdbc:sqlite:references.db";
        try (Connection conn = DriverManager.getConnection(url)) {
//            System.out.println(conn);
            Statement statement = conn.createStatement();

            statement.executeUpdate("CREATE TABLE IF NOT EXISTS authors(" +
                    "authorid INTEGER PRIMARY KEY, " +
                    "name TEXT NOT NULL, " +
                    "age INTEGER" +
                    ");");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS books(" +
                    "bookid INTEGER PRIMARY KEY, " +
                    "name TEXT NOT NULL, " +
                    "author INTEGER NOT NULL," +
                    "FOREIGN KEY(author) REFERENCES authors(authorid)" +
                    ");");

            statement.executeUpdate("INSERT INTO authors(name, age) VALUES ('A', 55);");
            statement.executeUpdate("INSERT INTO authors(name, age) VALUES ('B', 43);");

            ResultSet rs;
            rs = statement.executeQuery("SELECT authorid, name, age FROM authors;");
            while (rs.next()) {
                System.out.printf("Author #%d with name %s, age %d\n",
                        rs.getInt("authorid"),
                        rs.getString("name"),
                        rs.getInt("age"));
            }

//            statement.executeUpdate("INSERT INTO books(name, author) VALUES ('BookA', 1);");
//            statement.executeUpdate("INSERT INTO books(name, author) VALUES ('BookB', 1);");
//            statement.executeUpdate("INSERT INTO books(name, author) VALUES ('BookC', 2);");
            rs = statement.executeQuery("SELECT bookid, name, author FROM books;");
//            while (rs.next()) {
//                System.out.printf("Book #%d with name %s, from author #%d\n",
//                        rs.getInt("bookid"),
//                        rs.getString("name"),
//                        rs.getInt("author"));
//            }

            rs = statement.executeQuery("SELECT " +
                    "b.bookid AS bookid, " +
                    "b.name AS bookname, " +
                    "b.author AS authorid, " +
                    "a.name AS authorname, " +
                    "a.age AS authorage" +
                    " FROM books AS b JOIN authors AS a ON b.author=a.authorid;");
//            while (rs.next()) {
//                System.out.printf("Book #%d with name %s, from author #%d: name %s, age %d\n",
//                        rs.getInt("bookid"),
//                        rs.getString("bookname"),
//                        rs.getInt("authorid"),
//                        rs.getString("authorname"),
//                        rs.getInt("authorage"));
//            }

//            rs = statement.executeQuery("SELECT * FROM books AS b WHERE EXISTS (" +
//                    "SELECT 1 FROM authors AS a WHERE a.authorid=b.author AND a.age<55);");
            rs = statement.executeQuery("SELECT * FROM books AS b WHERE b.author IN (" +
                    "SELECT authorid FROM authors AS a WHERE a.age<55);");
//            while (rs.next()) {
//                System.out.printf("Book #%d with name %s, from author #%d\n",
//                        rs.getInt("bookid"),
//                        rs.getString("name"),
//                        rs.getInt("author"));
//            }

            Author c = new Author(3, "C", 34);
//            statement.executeUpdate("INSERT INTO authors(authorid, name, age) VALUES (" + c.id + ",'" + c.name + "', " + c.age + ");");
            Author d = new Author(4, "D", 20);
            PreparedStatement statementToInsertAuthor = conn.prepareStatement("INSERT INTO authors(authorid, name, age) VALUES (?, ?, ?);");
            statementToInsertAuthor.setInt(1, d.id);
            statementToInsertAuthor.setString(2, d.name);
            statementToInsertAuthor.setInt(3, d.age);
            statementToInsertAuthor.executeUpdate();

            rs = statement.executeQuery("SELECT * FROM authors");
            while (rs.next()) {
                System.out.printf("Author #%d with name %s, age %d\n",
                        rs.getInt("authorid"),
                        rs.getString("name"),
                        rs.getInt("age"));
            }

            PreparedStatement statementToFilterAuthorsByAge = conn.prepareStatement("SELECT * FROM authors WHERE age<?;");
            System.out.println("Authors with age < 40");
            statementToFilterAuthorsByAge.setInt(1, 40);
            rs = statementToFilterAuthorsByAge.executeQuery();
            while (rs.next()) {
                System.out.printf("Author #%d with name %s, age %d\n",
                        rs.getInt("authorid"),
                        rs.getString("name"),
                        rs.getInt("age"));
            }

            System.out.println("Authors with age < 30");
            statementToFilterAuthorsByAge.setInt(1, 30);
            rs = statementToFilterAuthorsByAge.executeQuery();
            while (rs.next()) {
                System.out.printf("Author #%d with name %s, age %d\n",
                        rs.getInt("authorid"),
                        rs.getString("name"),
                        rs.getInt("age"));
            }
        } catch (SQLException throwables) {
            System.out.println("Sql исключение: " + throwables.getMessage());
        }
    }

    public static void main(String[] args) {
//        jdbcExample();
        references();
    }
}
