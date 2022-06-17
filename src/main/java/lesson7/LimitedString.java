package lesson7;

public class LimitedString {
    private String value;

    public LimitedString(String value) {
        this.value = value;
    }

    public int length() {
        return value.length();
    }

    @Override
    public String toString() {
        return value;
    }
}
