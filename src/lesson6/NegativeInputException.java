package lesson6;

public class NegativeInputException extends RuntimeException {
    public NegativeInputException(String message) {
        super(message);
    }

    public NegativeInputException() {
    }
}
