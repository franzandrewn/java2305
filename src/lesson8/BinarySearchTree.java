package lesson8;

public class BinarySearchTree {
    private BNode<Integer> root;

    public BinarySearchTree() {
        root = null;
    }

    private BNode<Integer> addRecursive(BNode<Integer> current, int value) {
        if (current == null) {
            return new BNode<>(value);
        }

        if (value < current.value) {
            current.left = addRecursive(current.left, value);
        } else if (value > current.value) {
            current.right = addRecursive(current.right, value);
        } else {
            return current;
        }
        return current;
    }

    public void add(Integer value) {
        root = addRecursive(root, value);
    }

    private boolean containsValueRecursive(BNode<Integer> current, int value) {
        if (current == null) {
            return false;
        }
        if (value == current.value) {
            return true;
        }
        return value < current.value
                ? containsValueRecursive(current.left, value)
                : containsValueRecursive(current.right, value);
    }

    public boolean containsValue(int value) {
        return containsValueRecursive(root, value);
    }

    public BNode<Integer> getRoot() {
        return root;
    }
}
