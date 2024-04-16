import javax.swing.*;
import java.util.*;

public class TreeSort extends JPanel {

    private Node root;

    private class Node {
        int key;
        Node left, right;

        public Node(int item) {
            key = item;
            left = right = null;
        }
    }

    public void executeTreeSort(ArrayList<Integer> nums, Background draw, Base Base) throws InterruptedException {
        System.out.println(nums);

        for (int i = 0; i < nums.size(); i++) {
            root = insert(root, nums.get(i));
        }

        ArrayList<Integer> sorted = new ArrayList<>();
        inorder(root, sorted);

        for (int i = 0; i < sorted.size(); i++) {
            nums.set(i, sorted.get(i));

            Thread.sleep(100);
            draw.removeAll();
            draw.updateArray(nums);
            draw.revalidate();
            draw.paintImmediately(0, 30, 870, 532);
            System.out.println(nums);
        }
        Base.needReset = true;
    }

    private Node insert(Node root, int key) {
        if (root == null) {
            root = new Node(key);
        }

        if (key < root.key) {
            root.left = insert(root.left, key);
        } else if (key > root.key) {
            root.right = insert(root.right, key);
        }

        return root;
    }

    private void inorder(Node root, ArrayList<Integer> sorted) {
        if (root != null) {
            inorder(root.left, sorted);
            sorted.add(root.key);
            inorder(root.right, sorted);
        }
    }
}