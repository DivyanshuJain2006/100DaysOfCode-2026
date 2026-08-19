import java.util.*;

public class Question1_Leetcode {

    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    static boolean evaluateTree(TreeNode root) {

        if (root.left == null && root.right == null) {
            return root.val == 1;
        }

        boolean left = evaluateTree(root.left);
        boolean right = evaluateTree(root.right);

        if (root.val == 2) {
            return left || right;
        }

        return left && right;
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

        TreeNode root = buildTree(arr);

        System.out.println(evaluateTree(root));

        sc.close();
    }
}