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

    static ArrayList<Integer> values = new ArrayList<>();

    static void inorder(TreeNode root) {

        if (root == null) {
            return;
        }

        inorder(root.left);

        values.add(root.val);

        inorder(root.right);
    }

    static TreeNode buildBalanced(int left, int right) {

        if (left > right) {
            return null;
        }

        int mid = left + (right - left) / 2;

        TreeNode root = new TreeNode(values.get(mid));

        root.left = buildBalanced(left, mid - 1);
        root.right = buildBalanced(mid + 1, right);

        return root;
    }

    static TreeNode balanceBST(TreeNode root) {

        values.clear();

        inorder(root);

        return buildBalanced(0, values.size() - 1);
    }

    static TreeNode insert(TreeNode root, int val) {

        if (root == null) {
            return new TreeNode(val);
        }

        if (val < root.val) {
            root.left = insert(root.left, val);
        } else {
            root.right = insert(root.right, val);
        }

        return root;
    }

    static void printInorder(TreeNode root) {

        if (root == null) {
            return;
        }

        printInorder(root.left);
        System.out.print(root.val + " ");
        printInorder(root.right);
    }

    static void printLevelOrder(TreeNode root) {

        if (root == null) {
            return;
        }

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        while (!queue.isEmpty()) {

            TreeNode current = queue.poll();

            System.out.print(current.val + " ");

            if (current.left != null) {
                queue.offer(current.left);
            }

            if (current.right != null) {
                queue.offer(current.right);
            }
        }
    }

    public static void main(String[] args) {


        int[] nums = {1, 2, 3, 4};

        TreeNode root = null;

        for (int value : nums) {
            root = insert(root, value);
        }

        root = balanceBST(root);

        System.out.print("Balanced BST (level order): ");
        printLevelOrder(root);

        System.out.println();

        System.out.print("Inorder: ");
        printInorder(root);
    }
}