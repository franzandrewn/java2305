package lesson5;

public class Ship implements Swimming{
    double speed;

    @Override
    public void swim() {
        System.out.println("Плыву, конец связи");
    }
}
