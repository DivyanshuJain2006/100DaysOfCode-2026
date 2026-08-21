import java.io.*;
import java.util.*;

public class Main {

    static class TreeNode {
        long val;
        TreeNode left;
        TreeNode right;

        TreeNode(long val) {
            this.val = val;
        }
    }

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

    static int maxBSTSize;

    static Info largestBST(TreeNode node) {

        if (node == null) {

            return new Info(true, 0,
                    Long.MAX_VALUE,
                    Long.MIN_VALUE);
        }

        Info left = largestBST(node.left);
        Info right = largestBST(node.right);

        if (left.isBST &&
            right.isBST &&
            left.max < node.val &&
            node.val < right.min) {

            int size = left.size + right.size + 1;

            maxBSTSize = Math.max(maxBSTSize, size);

            long minValue =
                    Math.min(node.val, left.min);

            long maxValue =
                    Math.max(node.val, right.max);

            return new Info(
                    true,
                    size,
                    minValue,
                    maxValue
            );
        }

        return new Info(false, 0, 0, 0);
    }

    static TreeNode buildTree(long[] arr) {

        if (arr.length == 0 || arr[0] == -1) {
            return null;
        }

        TreeNode root = new TreeNode(arr[0]);

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        int i = 1;

        while (!queue.isEmpty() && i < arr.length) {

            TreeNode current = queue.poll();

            if (i < arr.length && arr[i] != -1) {
                current.left = new TreeNode(arr[i]);
                queue.offer(current.left);
            }

            i++;

            if (i < arr.length && arr[i] != -1) {
                current.right = new TreeNode(arr[i]);
                queue.offer(current.right);
            }

            i++;
        }

        return root;
    }

    static int findLargestBST(TreeNode root) {

        maxBSTSize = 0;

        largestBST(root);

        return maxBSTSize;
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br =
                new BufferedReader(
                        new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine().trim());

        StringBuilder output = new StringBuilder();

        while (t-- > 0) {

            int n = Integer.parseInt(br.readLine().trim());

            long[] tree = new long[n];

            int count = 0;

            while (count < n) {

                StringTokenizer st =
                        new StringTokenizer(br.readLine());

                while (st.hasMoreTokens() && count < n) {
                    tree[count++] =
                            Long.parseLong(st.nextToken());
                }
            }

            TreeNode root = buildTree(tree);

            output.append(findLargestBST(root))
                   .append('\n');
        }

        System.out.print(output);
    }
}