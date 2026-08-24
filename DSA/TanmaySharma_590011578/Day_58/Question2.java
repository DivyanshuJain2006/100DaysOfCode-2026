package DSA.TanmaySharma_590011578.Day_58;
import java.util.*;

public class Question2 {

    static class TreeNode {
        int id;
        TreeNode left, right;

        TreeNode(int id) {
            this.id = id;
        }
    }

    public static TreeNode buildTree(int[] tree) {
        if (tree == null || tree.length == 0 || tree[0] == -1)
            return null;

        TreeNode root = new TreeNode(tree[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int i = 1;

        while (i < tree.length) {
            TreeNode current = queue.poll();

            if (i < tree.length && tree[i] != -1) {
                current.left = new TreeNode(tree[i]);
                queue.offer(current.left);
            }
            i++;

            if (i < tree.length && tree[i] != -1) {
                current.right = new TreeNode(tree[i]);
                queue.offer(current.right);
            }
            i++;
        }

        return root;
    }

    public static boolean exists(TreeNode root, int id) {
        if (root == null)
            return false;

        if (root.id == id)
            return true;

        return exists(root.left, id) || exists(root.right, id);
    }

    public static TreeNode findLCA(TreeNode root, int a, int b) {
        if (root == null)
            return null;

        if (root.id == a || root.id == b)
            return root;

        TreeNode left = findLCA(root.left, a, b);
        TreeNode right = findLCA(root.right, a, b);

        if (left != null && right != null)
            return root;

        return left != null ? left : right;
    }

    public static int lowestCommonAncestor(int[] tree, int a, int b) {
        TreeNode root = buildTree(tree);

        if (!exists(root, a) || !exists(root, b))
            return -1;

        TreeNode lca = findLCA(root, a, b);

        return lca == null ? -1 : lca.id;
    }

    public static void main(String[] args) {
        int[] tree = {3, 5, 1, 6, 2, 0, 8, -1, -1, 7, 4};
        int a = 5;
        int b = 1;

        System.out.println(lowestCommonAncestor(tree, a, b));
    }
}