package lesson8;

import java.util.ArrayList;

public class Queue {
    private final ArrayList<Integer> values;

    public Queue() {
        values = new ArrayList<>();
    }

    public void queue(Integer i) {
        values.add(i);
    }

    public Integer dequeue() {
        return values.remove(0);
    }

    public Integer peek() {
        return values.get(0);
    }

    public Integer size() {
        return values.size();
    }

    @Override
    public String toString() {
        return "Queue" + values;
    }
}
