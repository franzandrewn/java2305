package lesson4;

import lesson5.Balance;

public class BankBalance extends Balance {
    public BankBalance() {
    }

    public BankBalance(int clientId, String date, double balance, String description) {
        super(clientId, date, balance, description);
    }

    @Override
    public void printInfo() {
//        System.out.println(clientId + " " + date + " " + balance + " " + description);
        System.out.println(date + " " + description);
        super.printInfo();
    }
}
