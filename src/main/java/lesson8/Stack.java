package lesson8;

import java.util.ArrayList;

public class Stack {
    private final ArrayList<Integer> values;

    public Stack() {
        values = new ArrayList<>();
    }

    public void push(Integer i) {
        values.add(i);
    }

    public Integer pop() {
        return values.remove(values.size() - 1);
    }

    public Integer peek() {
        return values.get(values.size() - 1);
    }

    public Integer size() {
        return values.size();
    }

    @Override
    public String toString() {
        return "Stack" + values;
    }
}
