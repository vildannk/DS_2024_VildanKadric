package week11;

public class Main {
    public static void main(String[] args) {
        /* Create a BST with string keys, and integer values */
        BinarySearchTree<String, Integer> bst = new BinarySearchTree<>();

        bst.put("T", 1);
        bst.put("E", 2);
        bst.put("X", 3);
        bst.put("A", 4);
        bst.put("R", 5);
        bst.put("C", 6);
        bst.put("H", 7);
        bst.put("M", 8);

        System.out.println("R: " + bst.get("R"));           // 5
        System.out.println("M: " + bst.get("M"));           // 8
        System.out.println("X: " + bst.get("X"));           // 3

        System.out.println("bst size: " + bst.size());      // 8

        System.out.println("min key: " + bst.findMin());    // A
        System.out.println("max key: " + bst.findMax());    // X

        System.out.println("rank of E: " + bst.rank("E"));  // 2
        System.out.println("rank of R: " + bst.rank("R"));  // 5

        bst.deleteMin();
        System.out.println("min key: " + bst.findMin());    // C

        bst.delete("H");
        bst.delete("M");
        System.out.println("M: " + bst.get("M"));           // null
        System.out.println("bst size: " + bst.size());      // 5

        System.out.println("inorder:");
        bst.inorder();
        System.out.println("preorder:");
        bst.preorder();
        System.out.println("postorder:");
        bst.postorder();
    }
}
