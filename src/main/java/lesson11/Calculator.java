package lesson11;

public class Calculator {
    public Calculator() {
    }

    public int mul(int x, int y) {
        int res = 0;
        int posY = Math.abs(y);
        for (int i = 0; i < posY; i++) {
            res += x;
        }
        if (y < 0) {
            return -res;
        } else {
            return res;
        }
    }

    public int div(int x, int y) {
        return x / y;
    }
}
