import java.util.*;

public class Question2 {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static void inorder(TreeNode root, TreeSet<Integer> set) {

        if (root == null) {
            return;
        }

        inorder(root.left, set);
        set.add(root.val);
        inorder(root.right, set);
    }

    public static ArrayList<Integer> mergeBSTs(TreeNode root1, TreeNode root2) {

        TreeSet<Integer> set = new TreeSet<>();

        inorder(root1, set);
        inorder(root2, set);

        return new ArrayList<>(set);
    }

    public static void main(String[] args) {

        TreeNode root1 = new TreeNode(2);
        root1.left = new TreeNode(1);
        root1.right = new TreeNode(3);

        TreeNode root2 = new TreeNode(4);
        root2.right = new TreeNode(5);

        System.out.println(mergeBSTs(root1, root2));
    }
}