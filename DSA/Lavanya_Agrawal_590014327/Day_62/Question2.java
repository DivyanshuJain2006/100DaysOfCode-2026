import java.util.*;

public class Question2 {

    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    static int[] rob(TreeNode root) {

        if (root == null) {
            return new int[]{0, 0};
        }

        int[] left = rob(root.left);
        int[] right = rob(root.right);

        // Rob current house
        int take = root.val + left[0] + right[0];

        // Skip current house
        int skip = Math.max(left[0], left[1])
                 + Math.max(right[0], right[1]);

        return new int[]{skip, take};
    }

    static int maxRob(TreeNode root) {
        int[] result = rob(root);
        return Math.max(result[0], result[1]);
    }

    static TreeNode buildTree(int[] arr) {

        if (arr.length == 0 || arr[0] == -1) {
            return null;
        }

        TreeNode[] nodes = new TreeNode[arr.length];

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != -1) {
                nodes[i] = new TreeNode(arr[i]);
            }
        }

        for (int i = 0; i < arr.length; i++) {

            if (nodes[i] != null) {

                int left = 2 * i + 1;
                int right = 2 * i + 2;

                if (left < arr.length) {
                    nodes[i].left = nodes[left];
                }

                if (right < arr.length) {
                    nodes[i].right = nodes[right];
                }
            }
        }

        return nodes[0];
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] tree = new int[n];

        for (int i = 0; i < n; i++) {
            tree[i] = sc.nextInt();
        }

        TreeNode root = buildTree(tree);

        System.out.println(maxRob(root));

        sc.close();
    }
}