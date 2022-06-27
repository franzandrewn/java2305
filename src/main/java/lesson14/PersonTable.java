package lesson14;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PersonTable {
    private DataSource dataSource;

    public PersonTable(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public DataSource getDataSource() {
        return dataSource;
    }

    public void createPerson() {
        dataSource.doOperation("CREATE PERSON");
    }
}
