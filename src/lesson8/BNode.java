package lesson8;

public class BNode<T> {
    T value;

    BNode<T> left;
    BNode<T> right;

    public BNode(T value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "BNode{" +
                "value='" + value + '\'' +
                '}';
    }
}
