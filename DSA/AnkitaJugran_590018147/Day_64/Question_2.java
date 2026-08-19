import java.util.*;

public class ConferenceRoom
 {

    static class TreeNode {
        long val;
        TreeNode left;
        TreeNode right;

        TreeNode(long val) {
            this.val = val;
        }
    }

    // Build tree from level-order array
    static TreeNode buildTree(long[] arr) {
        if (arr.length == 0 || arr[0] == -1) {
            return null;
        }

        TreeNode root = new TreeNode(arr[0]);

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int i = 1;

        while (!queue.isEmpty() && i < arr.length) {
            TreeNode current = queue.poll();

            // Left child
            if (i < arr.length && arr[i] != -1) {
                current.left = new TreeNode(arr[i]);
                queue.offer(current.left);
            }
            i++;

            // Right child
            if (i < arr.length && arr[i] != -1) {
                current.right = new TreeNode(arr[i]);
                queue.offer(current.right);
            }
            i++;
        }

        return root;
    }

    // Find LCA in a Binary Search Tree
    static TreeNode lowestCommonAncestor(TreeNode root, long a, long b) {

        while (root != null) {

            // Both values are smaller than root
            if (a < root.val && b < root.val) {
                root = root.left;
            }

            // Both values are greater than root
            else if (a > root.val && b > root.val) {
                root = root.right;
            }

            // They are on different sides, or one is the root
            else {
                return root;
            }
        }

        return null;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {

            int n = sc.nextInt();

            long[] tree = new long[n];

            for (int i = 0; i < n; i++) {
                tree[i] = sc.nextLong();
            }

            long a = sc.nextLong();
            long b = sc.nextLong();

            TreeNode root = buildTree(tree);

            TreeNode lca = lowestCommonAncestor(root, a, b);

            System.out.println(lca.val);
        }

        sc.close();
    }
}
