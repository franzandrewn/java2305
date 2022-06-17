package lesson5;

public abstract class ChessFigure implements Printable{
    int x;
    int y;
    boolean isWhite;

    public ChessFigure() {
    }

    public ChessFigure(int x, int y, boolean isWhite) {
        this.x = x;
        this.y = y;
        this.isWhite = isWhite;
    }

    @Override
    public String toString() {
        return "ChessFigure{" +
                "x=" + x +
                ", y=" + y +
                ", isWhite=" + isWhite +
                '}';
    }

    abstract void move(int newX, int newY);
}
