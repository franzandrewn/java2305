package lesson7;

public class Boat {
    String owner;
    int seats;
    double volume;
    private Engine engine;

    public Boat(String owner, int seats, double volume) {
        this.owner = owner;
        this.seats = seats;
        this.volume = volume;
        this.engine = new Engine();
    }

    public void turnBoatOn() {
        engine.turnOn();
    }

    public void turnBoatOff() {
        engine.turnOff();
    }

    public boolean isBoatOn() {
        return engine.isEngineOn();
    }

    public void move() {
        if (isBoatOn()) {
            System.out.println("Плыву");
        } else {
            System.out.println("Надо включить двигатель");
        }
    }
}
