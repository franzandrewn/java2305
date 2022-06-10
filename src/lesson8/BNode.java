package lesson8;

public class BNode {
    String value;

    BNode left;
    BNode right;

    public BNode(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "BNode{" +
                "value='" + value + '\'' +
                '}';
    }
}
