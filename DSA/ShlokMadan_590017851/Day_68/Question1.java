import java.util.*;

public class Question1 {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static void inorder(TreeNode root, ArrayList<Integer> values) {
        if (root == null) {
            return;
        }

        inorder(root.left, values);
        values.add(root.val);
        inorder(root.right, values);
    }

    public static TreeNode buildBalancedBST(ArrayList<Integer> values, int left, int right) {
        if (left > right) {
            return null;
        }

        int mid = left + (right - left) / 2;

        TreeNode root = new TreeNode(values.get(mid));

        root.left = buildBalancedBST(values, left, mid - 1);
        root.right = buildBalancedBST(values, mid + 1, right);

        return root;
    }

    public static TreeNode balanceBST(TreeNode root) {
        ArrayList<Integer> values = new ArrayList<>();

        inorder(root, values);

        return buildBalancedBST(values, 0, values.size() - 1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(3);
        root.right.right.right = new TreeNode(4);

        TreeNode balancedRoot = balanceBST(root);

        System.out.println(balancedRoot.val);
    }
}