package lesson11;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class PersonDAO {
    private static final String sqlToAddPerson = "INSERT INTO persons(name, age, password) VALUES (?,?,?)";
    private static final String sqlToChangePerson = "UPDATE persons SET name=?, age=?, password=? WHERE personid=?";
    private static final String sqlToDeletePerson = "DELETE FROM persons WHERE personid=?";
    private static final String sqlToGetAllPersons = "SELECT * FROM persons";
    private static final String sqlToGetPersonById = "SELECT * FROM persons WHERE personid=?";

    private final Connection connection;
    private final Statement statement;

    private final PreparedStatement addPerson;
    private final PreparedStatement changePerson;
    private final PreparedStatement deletePerson;
    private final PreparedStatement getAllPersons;
    private final PreparedStatement getPersonById;

    public PersonDAO(Connection connection) throws SQLException{
        this.connection = connection;
        statement = connection.createStatement();

        addPerson = connection.prepareStatement(sqlToAddPerson);
        changePerson = connection.prepareStatement(sqlToChangePerson);
        deletePerson = connection.prepareStatement(sqlToDeletePerson);
        getAllPersons = connection.prepareStatement(sqlToGetAllPersons);
        getPersonById = connection.prepareStatement(sqlToGetPersonById);
    }

    // CRUD - Create, Read, Update, Delete
    public int addPerson(Person person) throws SQLException{
        addPerson.setString(1, person.name);
        addPerson.setInt(2, person.age);
        addPerson.setString(3, person.password);
        addPerson.executeUpdate();
        ResultSet rs = statement.executeQuery("SELECT personid FROM persons ORDER BY personid DESC LIMIT 1");
        return rs.getInt("personid");
    }

    public boolean changePerson(int id, Person changedPerson) throws SQLException {
        getPersonById.setInt(1, id);
        ResultSet rs = getPersonById.executeQuery();
        if (rs.next()) {
            changePerson.setString(1, changedPerson.name);
            changePerson.setInt(2, changedPerson.age);
            changePerson.setString(3, changedPerson.password);
            changePerson.setInt(4, changedPerson.id);
            changePerson.executeUpdate();
            return true;
        }
        return false;
    }

    public boolean deletePerson(int id) throws SQLException {
        getPersonById.setInt(1, id);
        ResultSet rs = getPersonById.executeQuery();
        if (rs.next()) {
            deletePerson.setInt(1, id);
            deletePerson.executeUpdate();
            return true;
        }
        return false;
    }

    public List<Person> getAllPersons() throws SQLException {
        List<Person> result = new LinkedList<>();
        ResultSet rs = getAllPersons.executeQuery();
        while (rs.next()) {
            Person temp = new Person(
                    rs.getString("name"),
                    rs.getString("password"),
                    rs.getInt("age")
            );
            temp.id = rs.getInt("personid");
            result.add(temp);
        }
        return result;
    }

    public Person getPersonById(int id) throws SQLException {
        Person result = null;
        getPersonById.setInt(1, id);
        ResultSet rs = getPersonById.executeQuery();
        if (rs.next()) {
            result = new Person(
                    rs.getString("name"),
                    rs.getString("password"),
                    rs.getInt("age")
            );
            result.id = rs.getInt("personid");
        }
        return result;
    }

    public void incrementAge(int id) throws SQLException {
        Person p = getPersonById(id);
        if (p != null) {
            p.incAge();
            changePerson(id, p);
        }
    }
}
