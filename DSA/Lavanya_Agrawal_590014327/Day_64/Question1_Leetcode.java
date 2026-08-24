import java.util.*;

public class Question1_Leetcode {

    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static int rangeSumBST(TreeNode root, int low, int high) {

        if (root == null) {
            return 0;
        }

        if (root.val < low) {
            return rangeSumBST(root.right, low, high);
        }

        if (root.val > high) {
            return rangeSumBST(root.left, low, high);
        }

        return root.val
                + rangeSumBST(root.left, low, high)
                + rangeSumBST(root.right, low, high);
    }

    static TreeNode buildTree(String[] arr) {

        if (arr.length == 0 || arr[0].equals("null")) {
            return null;
        }

        TreeNode[] nodes = new TreeNode[arr.length];

        for (int i = 0; i < arr.length; i++) {
            if (!arr[i].equals("null")) {
                nodes[i] = new TreeNode(Integer.parseInt(arr[i]));
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
        sc.nextLine();

        String[] arr = sc.nextLine().trim().split("\\s+");

        int low = sc.nextInt();
        int high = sc.nextInt();

        TreeNode root = buildTree(arr);

        System.out.println(rangeSumBST(root, low, high));

        sc.close();
    }
}