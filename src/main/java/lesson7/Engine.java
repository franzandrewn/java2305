package lesson7;

public class Engine {
    private boolean isOn;

    public Engine() {
        isOn = false;
    }

    public void turnOn() {
        isOn = true;
    }

    public void turnOff() {
        isOn = false;
    }

    public boolean isEngineOn() {
        return isOn;
    }
}
