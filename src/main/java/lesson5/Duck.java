package lesson5;

public class Duck implements Swimming, Walking{
    String name;

    @Override
    public void swim() {
        System.out.println("Плыву, кря");
    }

    @Override
    public void walk() {
        System.out.println("Шагаю, кря");
    }
}
