package lesson5;

public final class CircleMath {
    public final static double PI = Math.PI;

    private CircleMath() {
    }

    public static double area(double radius) {
        return PI * radius * radius;
    }

    public static double length(double radius) {
        return 2 * PI * radius;
    }
}
