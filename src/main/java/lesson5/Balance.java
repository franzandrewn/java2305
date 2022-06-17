package lesson5;


import java.util.Objects;

public class Balance implements Printable, Hashable {
    private int clientId;
    protected String date;
    double balance;
    public String description;

    public Balance() {
    }

    public Balance(int clientId, String date, double balance, String description) {
        this.clientId = clientId;
        this.date = date;
        this.balance = balance;
        this.description = description;
    }

    public void printInfo() {
        // взаимодействие с любыми модификаторами
        System.out.println(clientId + " " + date + " " + balance + " " + description);
    }

    public int getClientId() {
        // проверка аутентификации
        return clientId;
    }

    public void setClientId(int clientId) {
        // проверка аутентификации
        this.clientId = clientId;
    }

    @Override
    public String toString() {
        return "Balance{" +
                "clientId=" + clientId +
                ", date='" + date + '\'' +
                ", balance=" + balance +
                ", description='" + description + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Balance)) return false;
        Balance balance1 = (Balance) o;
        return clientId == balance1.clientId
                && Double.compare(balance1.balance, balance) == 0
                && Objects.equals(date, balance1.date)
                && Objects.equals(description, balance1.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clientId, date, balance, description);
    }

    @Override
    public void print() {
        System.out.println("Balance{" +
                "clientId=" + clientId +
                ", date='" + date + '\'' +
                ", balance=" + balance +
                ", description='" + description + '\'' +
                '}');
    }

    @Override
    public long turnIntoHash() {
        return this.hashCode();
    }
}
