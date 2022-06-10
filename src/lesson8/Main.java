package lesson8;

import java.util.*;

public class Main {
    static void sets() {
        // Множество - набор уникальных элементов
        // HashSet - множество без определенного порядка
        HashSet<String> stringSet = new HashSet<>();

        System.out.println(stringSet);
        stringSet.add("asd");
        System.out.println(stringSet);
        stringSet.add("123");
        stringSet.add("zxc");
        System.out.println(stringSet);

        stringSet.add("123");
        System.out.println(stringSet);

        stringSet.remove("asd");
        System.out.println(stringSet);

        System.out.println(stringSet.size());
        System.out.println(stringSet.isEmpty());
        System.out.println(stringSet.contains("zxc"));
        stringSet.clear();

        HashSet<Integer> hashIntSet = new HashSet<>();
        hashIntSet.add(50);
        hashIntSet.add(1);
        hashIntSet.add(3);
        hashIntSet.add(-59);
        System.out.println("HashSet<Integer>: " + hashIntSet);

        // LinkedHashSet - множество, хранящее порядок добавления
        LinkedHashSet<Integer> linkedHashIntSet = new LinkedHashSet<>();
        linkedHashIntSet.add(50);
        linkedHashIntSet.add(1);
        linkedHashIntSet.add(3);
        linkedHashIntSet.add(-59);
        System.out.println("LinkedHashSet<Integer>: " + linkedHashIntSet);

        // TreeSet - множество, хранящее элементы в порядке возрастания
        TreeSet<Integer> treeIntSet = new TreeSet<>();
        treeIntSet.add(50);
        treeIntSet.add(1);
        treeIntSet.add(3);
        treeIntSet.add(-59);
        System.out.println("TreeSet<Integer>: " + treeIntSet);
    }

    static void maps() {
        // Словарь - хранение набора пар элементов вида "Ключ - значение"
        HashMap<Integer, String> hashMap = new HashMap<>();

        System.out.println(hashMap);
        hashMap.put(50, "fifty");
        System.out.println(hashMap);
        hashMap.put(1, "one");
        hashMap.put(3, "three");
        hashMap.put(-59, "minus fifty nine");
        System.out.println(hashMap);

        System.out.println(hashMap.remove(-59));
        System.out.println(hashMap);

        System.out.println(hashMap.remove(3, "four"));
        System.out.println(hashMap);
        System.out.println(hashMap.remove(3, "three"));
        System.out.println(hashMap);

        System.out.println(hashMap.size());
        System.out.println(hashMap.isEmpty());
//        hashMap.clear();

        System.out.println(hashMap.keySet());
        System.out.println(hashMap.values());
        System.out.println(hashMap.entrySet());

        System.out.println(hashMap.containsKey(1));
        System.out.println(hashMap.containsValue("one"));

        System.out.println(hashMap.get(50));
        System.out.println(hashMap.replace(50, "пятьдесят"));
        System.out.println(hashMap);

        HashMap<String, String> settings = new HashMap<>();
        settings.put("volume", "0.8");
        settings.put("resolution", "1920x1080");
        System.out.println(settings);

        // Хранится порядок добавления пар
        LinkedHashMap<Integer, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(50, "fifty");
        linkedHashMap.put(1, "one");
        linkedHashMap.put(3, "three");
        linkedHashMap.put(-59, "minus fifty nine");
        System.out.println(linkedHashMap);

        // Пары отсортированы по возрастанию ключей
        TreeMap<Integer, String> treeMap = new TreeMap<>();
        treeMap.put(50, "fifty");
        treeMap.put(1, "one");
        treeMap.put(3, "three");
        treeMap.put(-59, "minus fifty nine");
        System.out.println(treeMap);

        printAllValues(hashMap);
        printAllValues(linkedHashMap);
        printAllValues(treeMap);
    }

    static void printAllValues(Map<Integer, String> map) {
        System.out.println(map.values());
    }

    static void stack() {
        // Стек - структура данных, работающая по принципу FILO (First In - Last Out)
        Stack stack = new Stack();
        System.out.println(stack);
        stack.push(1);
        stack.push(-3);
        stack.push(4);
        System.out.println(stack);
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack);
    }

    static void queue() {
        // Очередь - структура данных, работающая по принципу FIFO (First In - First Out)
        Queue queue = new Queue();
        System.out.println(queue);
        queue.queue(1);
        queue.queue(-3);
        queue.queue(4);
        System.out.println(queue);
        System.out.println(queue.peek());
        System.out.println(queue.dequeue());
        System.out.println(queue);
    }

    static void linkedListAsDeque() {
        // Двусторонняя очередь - структура данных, сочетающая очередь и стек
        LinkedList<Integer> deque = new LinkedList<>();
        deque.addLast(1);
        deque.addFirst(0);
        deque.addFirst(1000);
        System.out.println(deque);

        deque.removeLast();
        System.out.println(deque);
        deque.removeFirst();
        System.out.println(deque);
    }

    static void forEach() {
        LinkedList<Integer> intList = new LinkedList<>();
        intList.addLast(1);
        intList.addFirst(0);
        intList.addFirst(1000);

        for (Integer item : intList) {
            System.out.println(item);
        }

        HashSet<Integer> hashIntSet = new HashSet<>();
        hashIntSet.add(50);
        hashIntSet.add(1);
        hashIntSet.add(3);
        hashIntSet.add(-59);
        System.out.println("hashset");
        for (Integer item : hashIntSet) {
            System.out.println(item);
        }

        HashMap<Integer, String> hashMap = new HashMap<>();
        hashMap.put(50, "fifty");
        hashMap.put(1, "one");
        hashMap.put(3, "three");
        hashMap.put(-59, "minus fifty nine");

        System.out.println("key from hashmap");
        for (Integer key : hashMap.keySet()) {
            System.out.println("key: " + key + " value: " + hashMap.get(key));
        }

        System.out.println("values from hashmap");
        for (String value : hashMap.values()) {
            System.out.println(value);
        }

        System.out.println("entrySet from hashmap");
        for (Map.Entry<Integer, String> entry : hashMap.entrySet()) {
            System.out.println("key: " + entry.getKey() + " value: " + entry.getValue());
        }
    }

    static void trees() {
        // Граф - структура, состоящая из узлов, соединенных ребрами
        // Деревья - граф без циклов
        Node nodeC = new Node("c");
        Node nodeB = new Node("b");
        Node nodeA = new Node("c");
        Node nodeD = new Node("d");
        Node nodeE = new Node("e");
        Node nodeF = new Node("f");
        Node nodeG = new Node("g");

        nodeC.children.add(nodeB);
        nodeC.children.add(nodeD);
        nodeC.children.add(nodeF);

        nodeB.children.add(nodeA);
        nodeB.children.add(nodeE);

        nodeF.children.add(nodeG);

        Node root = nodeC;
        System.out.println(root.children.get(0).children.get(1));
        System.out.println(root);


    }

    static void treeTraversal() {
        // Бинарные деревья - деревья, узлы которого могут иметь максимум 2 наследников
        BNode bNodeA = new BNode("A");
        BNode bNodeB = new BNode("B");
        BNode bNodeC = new BNode("C");
        BNode bNodeD = new BNode("D");
        BNode bNodeE = new BNode("E");
        BNode bNodeF = new BNode("F");
        BNode bNodeG = new BNode("G");
        bNodeA.left = bNodeB;
        bNodeA.right = bNodeC;
        bNodeB.left = bNodeD;
        bNodeB.right = bNodeE;
        bNodeD.right = bNodeG;
        bNodeC.left = bNodeF;

        // horizontal
        System.out.println("Horizontal");
        horizontal(bNodeA);

        System.out.println("Preorder (NLR) - Прямой обход");
        preorder(bNodeA);

        System.out.println("Inorder (LNR) - Центрированный обход");
        inorder(bNodeA);

        System.out.println("Postorder (LRN) - Обратный обход");
        postorder(bNodeA);
    }

    static void horizontal(BNode root) {
        LinkedList<BNode> queue = new LinkedList<>();
        queue.addLast(root);
        while (!queue.isEmpty()) {
            BNode temp = queue.removeFirst();
            System.out.println(temp);
            if (temp.left != null) {
                queue.addLast(temp.left);
            }
            if (temp.right != null) {
                queue.addLast(temp.right);
            }
            System.out.println("\tQueue:" + queue);
        }
    }

    static void preorder(BNode root) {
        if (root != null) {
            System.out.println(root);
            preorder(root.left);
            preorder(root.right);
        }
    }

    static void inorder(BNode root) {
        if (root != null) {
            inorder(root.left);
            System.out.println(root);
            inorder(root.right);
        }
    }

    static void postorder(BNode root) {
        if (root != null) {
            postorder(root.left);
            postorder(root.right);
            System.out.println(root);
        }
    }

    static void search() {
        // Алгоритм поиска - поиск индекса элемента в структуре данных по его значению
        // Если структура данных не отсортирована, то есть только 1 вариант - линейный поиск
        LinkedList<Integer> list = new LinkedList<>();
        list.add(5);
        list.add(1);
        list.add(4);
        list.add(6);
        list.add(-5);
        list.add(7);
        list.add(100);
        list.add(8);
        list.add(5);
        System.out.println(list);
        System.out.println(linearSearch(list, -5));
        System.out.println(linearSearch(list, 101));

        // Если структура отсортирована, возможно этим воспользоваться
        list.sort(Comparator.comparingInt(x -> x));
        System.out.println(list);

//        System.out.println(binarySearch(list, -5));
        System.out.println(binarySearch(list, 7));
        System.out.println(binarySearch(list, 101));
    }

    static int linearSearch(List<Integer> list, int target) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == target) {
                return i;
            }
        }
        return -1;
    }

    static int binarySearch(List<Integer> list, int target) {
        int left = 0;
        int right = list.size() - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
//            System.out.printf("left %d, right %d, mid %d, list[%d] %d\n", left, right, mid, mid, list.get(mid));
            if (list.get(mid) > target) {
                right = mid - 1;
            } else if (list.get(mid) < target) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    static int interpolationSearch(List<Integer> list, int target) {
        return -1;
    }

    static void sort() {
        // Алгоритм сортировки - расстановка элементов структуры в порядке возрастания/убывания
        LinkedList<Integer> list = new LinkedList<>();
        list.add(5);
        list.add(1);
        list.add(4);
        list.add(6);
        list.add(-5);
        list.add(7);
        list.add(100);
        list.add(8);
        list.add(5);

        bubbleSort(list);
        System.out.println(list);
    }

    static void bubbleSort(List<Integer> list) {
        for (int j = 0; j < list.size(); j++) {
            for (int i = 0; i < list.size() - 1; i++) {
                if (list.get(i) > list.get(i + 1)) {
                    int temp = list.get(i);
                    list.set(i, list.get(i+1));
                    list.set(i+1, temp);
                }
            }
        }
    }

    public void quickSort(ArrayList<Integer> arr, int begin, int end) {
        if (begin < end) {
            int partitionIndex = partition(arr, begin, end);
            quickSort(arr, begin, partitionIndex-1);
            quickSort(arr, partitionIndex+1, end);
        }
    }

    private int partition(ArrayList<Integer> arr, int begin, int end) {
        int pivot = arr.get(end);
        int i = (begin-1);

        for (int j = begin; j < end; j++) {
            if (arr.get(j) <= pivot) {
                i++;

                int swapTemp = arr.get(i);
                arr.set(i, arr.get(j));
                arr.set(j, swapTemp);
            }
        }

        int swapTemp = arr.get(i+1);
        arr.set(i+1, arr.get(end));
        arr.set(end, swapTemp);

        return i+1;
    }

    public static void main(String[] args) {
//        sets();
//        maps();
//        stack();
//        queue();
//        linkedListAsDeque();
//        forEach();
//        trees();
//        treeTraversal();
//        search();
        sort();
    }
}
