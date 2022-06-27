package lesson14;

import org.springframework.stereotype.Component;

@Component
public class DataSource {
    private String url;
    private String login;
    private String password;

    public DataSource() {
        this.setUrl("localhost");
        this.setLogin("admin");
        this.setPassword("12345");
    }

    public DataSource(String url, String login, String password) {
        this.url = url;
        this.login = login;
        this.password = password;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void doOperation(String sql) {
        System.out.println("Operation '" + sql + "' successful");
    }
}
