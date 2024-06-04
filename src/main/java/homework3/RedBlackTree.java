package homework3;

import java.util.ArrayList;

public class RedBlackTree {
    private Node root;

    private static final boolean RED = true;
    private static final boolean BLACK = false;

    public ArrayList<Entry> get(String searchableName) {
        Node node = root;
        int[] counts = {0, 0};

        while (node != null) {
            int cmp = searchableName.compareTo(node.key);

            if (cmp < 0) {
                node = node.left;
                if (node != null && !node.isRed) counts[0]++;
            } else if (cmp > 0) {
                node = node.right;
                if (node != null && !node.isRed) counts[0]++;
            } else {
                System.out.println("Red edges: " + counts[1] + ", Black edges: " + counts[0]);
                return node.values;
            }

            if (node != null && node.isRed) counts[1]++;
        }

        return null;
    }


    public void put(String searchableName, Entry entry) {
        root = put(root, searchableName, entry);
        root.isRed = false;
    }
    private Node put(Node node, String key, Entry entry) {
        if (node == null) return new Node(key, entry);

        int cmp = key.compareTo(node.key);
        if (cmp < 0) node.left = put(node.left, key, entry);
        else if (cmp > 0) node.right = put(node.right, key, entry);
        else node.values.add(entry);

        if (isRed(node.right) && !isRed(node.left)) node = rotateLeft(node);
        if (isRed(node.left) && isRed(node.left.left)) node = rotateRight(node);
        if (isRed(node.left) && isRed(node.right)) flipColors(node);

        return node;
    }

    public int[] countRedAndBlackEdges() {
        int[] counts = {0, 0};
        countEdges(root, counts);
        return counts;
    }

    private void countEdges(Node node, int[] counts) {
        if (node == null) return;
        if (node.isRed) counts[1]++; else counts[0]++;
        countEdges(node.left, counts);
        countEdges(node.right, counts);
    }


    private boolean isRed(Node node) {
        return node != null && node.isRed;
    }

    private Node rotateLeft(Node node) {
        Node rightChild = node.right;
        node.right = rightChild.left;
        rightChild.left = node;
        rightChild.isRed = node.isRed;
        node.isRed = RED;
        return rightChild;
    }

    private Node rotateRight(Node node) {
        Node leftChild = node.left;
        node.left = leftChild.right;
        leftChild.right = node;
        leftChild.isRed = node.isRed;
        node.isRed = RED;
        return leftChild;
    }

    private void flipColors(Node node) {
        node.isRed = !node.isRed;
        node.left.isRed = !node.left.isRed;
        node.right.isRed = !node.right.isRed;
    }
}