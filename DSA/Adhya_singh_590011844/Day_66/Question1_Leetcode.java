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

    static TreeNode insertIntoBST(TreeNode root, int val) {

        if (root == null) {
            return new TreeNode(val);
        }

        TreeNode current = root;

        while (true) {

            if (val < current.val) {

                if (current.left == null) {
                    current.left = new TreeNode(val);
                    break;
                }

                current = current.left;
            }

            else {

                if (current.right == null) {
                    current.right = new TreeNode(val);
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

    static TreeNode buildBST(int[] values) {

        TreeNode root = null;

        for (int value : values) {
            root = insertIntoBST(root, value);
        }

        return root;
    }

    public static void main(String[] args) {

        int[] values = {4, 2, 7, 1, 3};

        int val = 5;

        TreeNode root = buildBST(values);

        root = insertIntoBST(root, val);

        System.out.print("Inorder after insertion: ");
        inorder(root);
    }
}