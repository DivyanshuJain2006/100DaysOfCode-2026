import java.util.*;

public class Main {

    // Binary tree node
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    // Returns {rob, notRob}
    static int[] solve(TreeNode root) {

        // Empty node
        if (root == null) {
            return new int[]{0, 0};
        }

        // Solve left and right subtrees
        int[] left = solve(root.left);
        int[] right = solve(root.right);

        // If we rob current house,
        // we cannot rob either child
        int rob = root.val + left[1] + right[1];

        // If we don't rob current house,
        // we can either rob or not rob each child
        int notRob = Math.max(left[0], left[1])
                   + Math.max(right[0], right[1]);

        return new int[]{rob, notRob};
    }

    // Build tree from level-order input
    // -1 represents a missing node
    static TreeNode buildTree(int[] arr) {

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

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Number of elements
        int n = sc.nextInt();

        int[] arr = new int[n];

        // Tree in level-order
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        TreeNode root = buildTree(arr);

        int[] result = solve(root);

        // Maximum of robbing or not robbing root
        int answer = Math.max(result[0], result[1]);

        System.out.println(answer);

        sc.close();
    }
}
