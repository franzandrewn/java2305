package lesson5;

public class Queen extends ChessFigure {

    public Queen() {
    }

    public Queen(int x, int y, boolean isWhite) {
        super(x, y, isWhite);
    }

    @Override
    void move(int newX, int newY) {
        System.out.println("Королева ходит");
    }

    @Override
    public void print() {
        System.out.println("Я королева");
    }
}
