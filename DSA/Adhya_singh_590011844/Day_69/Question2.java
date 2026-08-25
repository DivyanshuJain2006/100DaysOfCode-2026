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

   
    static TreeNode[] splitBST(TreeNode root, long k) {

        if (root == null) {
            return new TreeNode[]{null, null};
        }

        if (root.val < k) {

            TreeNode[] split = splitBST(root.right, k);

            root.right = split[0];

            return new TreeNode[]{
                root,
                split[1]
            };

        } else {

            TreeNode[] split = splitBST(root.left, k);

            root.left = split[1];

            return new TreeNode[]{
                split[0],
                root
            };
        }
    }

    static TreeNode buildTree(long[] arr) {

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

            if (nodes[i] == null) {
                continue;
            }

            int left = 2 * i + 1;
            int right = 2 * i + 2;

            if (left < arr.length) {
                nodes[i].left = nodes[left];
            }

            if (right < arr.length) {
                nodes[i].right = nodes[right];
            }
        }

        return nodes[0];
    }

    static void preorder(TreeNode root, StringBuilder sb) {

        if (root == null) {
            return;
        }

        if (sb.length() > 0) {
            sb.append(' ');
        }

        sb.append(root.val);

        preorder(root.left, sb);
        preorder(root.right, sb);
    }

    static String getPreorder(TreeNode root) {

        if (root == null) {
            return "EMPTY";
        }

        StringBuilder sb = new StringBuilder();
        preorder(root, sb);

        return sb.toString();
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br =
                new BufferedReader(
                        new InputStreamReader(System.in));

        StringTokenizer st;

        int n = Integer.parseInt(br.readLine().trim());

        long[] tree = new long[n];

        int index = 0;

        while (index < n) {

            st = new StringTokenizer(br.readLine());

            while (st.hasMoreTokens() && index < n) {
                tree[index++] =
                        Long.parseLong(st.nextToken());
            }
        }

        long k = Long.parseLong(br.readLine().trim());

        TreeNode root = buildTree(tree);

        TreeNode[] result = splitBST(root, k);

        System.out.println(getPreorder(result[0]));

        System.out.println(getPreorder(result[1]));
    }
}