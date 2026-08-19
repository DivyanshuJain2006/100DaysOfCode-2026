import java.util.*;

public class Question2 {

    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    static int closestValue(TreeNode root, double target) {

        int closest = root.val;

        while (root != null) {

            double currentDiff = Math.abs(root.val - target);
            double closestDiff = Math.abs(closest - target);

            if (currentDiff < closestDiff ||
                (currentDiff == closestDiff && root.val < closest)) {
                closest = root.val;
            }

            if (target < root.val) {
                root = root.left;
            } else if (target > root.val) {
                root = root.right;
            } else {
                return root.val;
            }
        }

        return closest;
    }

    static TreeNode buildTree(String[] arr) {

        if (arr.length == 0 || arr[0].equals("-1")) {
            return null;
        }

        TreeNode[] nodes = new TreeNode[arr.length];

        for (int i = 0; i < arr.length; i++) {
            if (!arr[i].equals("-1")) {
                nodes[i] = new TreeNode(Integer.parseInt(arr[i]));
            }
        }

        // 0-based array:
        // left child = 2*i + 1
        // right child = 2*i + 2
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

        int T = sc.nextInt();

        for (int test = 0; test < T; test++) {

            int n = sc.nextInt();

            String[] arr = new String[n];

            for (int i = 0; i < n; i++) {
                arr[i] = sc.next();
            }

            double target = sc.nextDouble();

            TreeNode root = buildTree(arr);

            System.out.println(closestValue(root, target));
        }

        sc.close();
    }
}