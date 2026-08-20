import java.util.*;

public class Main {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    static TreeNode deleteNode(TreeNode root, int key) {

        TreeNode parent = null;
        TreeNode current = root;

        while (current != null && current.val != key) {

            parent = current;

            if (key < current.val) {
                current = current.left;
            } else {
                current = current.right;
            }
        }

        if (current == null) {
            return root;
        }

        if (current.left != null && current.right != null) {

            TreeNode successorParent = current;
            TreeNode successor = current.right;

            while (successor.left != null) {
                successorParent = successor;
                successor = successor.left;
            }

            current.val = successor.val;

            parent = successorParent;
            current = successor;
        }

        TreeNode child;

        if (current.left != null) {
            child = current.left;
        } else {
            child = current.right;
        }

        if (parent == null) {
            return child;
        }

        if (parent.left == current) {
            parent.left = child;
        } else {
            parent.right = child;
        }

        return root;
    }

    static TreeNode insert(TreeNode root, int value) {

        if (root == null) {
            return new TreeNode(value);
        }

        TreeNode current = root;

        while (true) {

            if (value < current.val) {

                if (current.left == null) {
                    current.left = new TreeNode(value);
                    break;
                }

                current = current.left;

            } else {

                if (current.right == null) {
                    current.right = new TreeNode(value);
                    break;
                }

                current = current.right;
            }
        }

        return root;
    }

    static void inorder(TreeNode root) {

        if (root == null) {
            return;
        }

        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }

    public static void main(String[] args) {


        int[] values = {5, 3, 7, 2, 4, 6, 8};

        TreeNode root = null;

        for (int value : values) {
            root = insert(root, value);
        }

        int key = 5;

        root = deleteNode(root, key);

        System.out.print("BST after deletion: ");
        inorder(root);
    }
}