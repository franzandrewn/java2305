package lesson9;

public class PhoneNumber {
    String type;
    String number;

    @Override
    public String toString() {
        return "PhoneNumber{" +
                "type='" + type + '\'' +
                ", number='" + number + '\'' +
                '}';
    }

    public PhoneNumber(String type, String number) {
        this.type = type;
        this.number = number;
    }
}
