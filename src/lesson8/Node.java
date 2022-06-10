package lesson8;

import java.util.LinkedList;

public class Node {
    String value;

    LinkedList<Node> children;

    public Node(String value) {
        this.value = value;
        children = new LinkedList<>();
    }

    @Override
    public String toString() {
        return "Node{" +
                "value='" + value + "'}";
    }
}
