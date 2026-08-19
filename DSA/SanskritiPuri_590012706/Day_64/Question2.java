import java.util.*;

public class Main {

    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    // Build tree from level-order array
    static TreeNode buildTree(int[] tree) {
        if (tree.length == 0 || tree[0] == -1) {
            return null;
        }

        TreeNode root = new TreeNode(tree[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int i = 1;

        while (!queue.isEmpty() && i < tree.length) {
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

    static int findLCA(TreeNode root, int a, int b) {

        while (root != null) {

            // Both values are smaller than root
            if (a < root.val && b < root.val) {
                root = root.left;
            }

            // Both values are greater than root
            else if (a > root.val && b > root.val) {
                root = root.right;
            }

            // Values split around root, or root equals one of them
            else {
                return root.val;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 
