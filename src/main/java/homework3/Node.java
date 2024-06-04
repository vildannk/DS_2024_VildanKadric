package homework3;

import java.util.ArrayList;

public class Node {
    String key;
    ArrayList<Entry> values = new ArrayList<>();
    Node left, right;
    boolean isRed;

    public Node(String key, Entry entry) {
        this.key = key;
        this.values.add(entry);
        this.isRed = true;
    }
}