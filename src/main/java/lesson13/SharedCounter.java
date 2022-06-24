package lesson13;

public class SharedCounter {
    private int count = 0;


    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void increase() {
        setCount(getCount() + 1);
    }

    public  void syncIncrease() {
        synchronized (this) {
            setCount(getCount() + 1);
        }
    }
}
