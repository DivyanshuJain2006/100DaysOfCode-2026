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

    static int largestBST;

    static class Info {
        boolean isBST;
        int size;
        long min;
        long max;

        Info(boolean isBST, int size, long min, long max) {
            this.isBST = isBST;
            this.size = size;
            this.min = min;
            this.max = max;
        }
    }

    static Info findLargestBST(TreeNode root) {

        if (root == null) {
            return new Info(true, 0, Long.MAX_VALUE, Long.MIN_VALUE);
        }

        Info left = findLargestBST(root.left);
        Info right = findLargestBST(root.right);

        // Current subtree is a BST if:
        // left subtree is BST
        // right subtree is BST
        // all left values < root
        // all right values > root
        if (left.isBST &&
            right.isBST &&
            left.max < root.val &&
            root.val < right.min) {

            int size = left.size + right.size + 1;

            largestBST = Math.max(largestBST, size);

            long min = Math.min(root.val, left.min);
            long max = Math.max(root.val, right.max);

            return new Info(true, size, min, max);
        }

        // Current subtree is not a BST
        return new Info(false, 0, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    static int buildAndFind(int[] arr) {

        if (arr.length == 0 || arr[0] == -1) {
            return 0;
        }

        TreeNode root = buildTree(arr);

        largestBST = 0;

        findLargestBST(root);

        return largestBST;
    }

    static TreeNode buildTree(int[] arr) {

        if (arr.length == 0 || arr[0] == -1) {
            return null;
        }

        TreeNode root = new TreeNode(arr[0]);

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int i = 1;

        while (!queue.isEmpty() && i < arr.length) {

            TreeNode current = queue.poll();

            if (i < arr.length && arr[i] != -1) {
                current.left = new TreeNode(arr[i]);
                queue.add(current.left);
            }
            i++;

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

        int t = sc.nextInt();

        while (t-- > 0) {

            int n = sc.nextInt();

            int[] arr = new int[n];

            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            System.out.println(buildAndFind(arr));
        }

        sc.close();
    }
}