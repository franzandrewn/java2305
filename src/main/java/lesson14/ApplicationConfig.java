package lesson14;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

//@Configuration
public class ApplicationConfig {

    @Bean
    @Scope("prototype")
    public PersonTable getPersonTable() {
        return new PersonTable(getDataSource());
    }

    @Bean
    @Scope("singleton")
    public DataSource getDataSource() {
        DataSource ds = new DataSource();
        ds.setUrl("localhost");
        ds.setLogin("admin");
        ds.setPassword("12345");
        return ds;
    }
}
