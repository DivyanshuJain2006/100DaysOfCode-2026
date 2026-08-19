import java.util.*;

public class Main {

    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    static int countSafeNodes(TreeNode root, int maxSoFar) {
        if (root == null) {
            return 0;
        }

        int count = 0;

        // Check if current node is safe
        if (root.val >= maxSoFar) {
            count = 1;
        }

        // Update maximum value on the path
        maxSoFar = Math.max(maxSoFar, root.val);

        count += countSafeNodes(root.left, maxSoFar);
        count += countSafeNodes(root.right, maxSoFar);

        return count;
    }

    static TreeNode buildTree(int[] arr) {
        if (arr.length == 0 || arr[0] == -1) {
            return null;
        }

        TreeNode root = new TreeNode(arr[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int i = 1;

        while (i < arr.length) {
            TreeNode current = queue.poll();

            // Left child
            if (i < arr.length && arr[i] != -1) {
                current.left = new TreeNode(arr[i]);
                queue.add(current.left);
            }
            i++;

            // Right child
            if (i < arr.length && arr[i] != -1) {
                current.right = new TreeNode(arr[i]);
                queue.add(current.right);
            }
            i++;
        }

        return root;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Enter number of nodes
        int n = sc.nextInt();

        int[] tree = new int[n];

        // Enter level-order tree
        for (int i = 0; i < n; i++) {
            tree[i] = sc.nextInt();
        }

        TreeNode root = buildTree(tree);

        int answer = countSafeNodes(root, root.val);

        System.out.println(answer);

        sc.close();
    }
}
