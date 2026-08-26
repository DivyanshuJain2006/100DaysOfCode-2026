import java.util.*;

public class Question1_Leetcode {
    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    static int index = 0;

    static TreeNode buildBST(int[] preorder, int min, int max) {
        if (index >= preorder.length) {
            return null;
        }

        int value = preorder[index];

        if (value < min || value > max) {
            return null;
        }

        TreeNode root = new TreeNode(value);
        index++;

        root.left = buildBST(preorder, min, value);
        root.right = buildBST(preorder, value, max);

        return root;
    }

    static void levelOrder(TreeNode root) {
        if (root == null) {
            System.out.println("[]");
            return;
        }

        List<String> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();

            if (curr == null) {
                result.add("null");
            } else {
                result.add(String.valueOf(curr.val));
                queue.add(curr.left);
                queue.add(curr.right);
            }
        }

        while (result.size() > 0 && result.get(result.size() - 1).equals("null")) {
            result.remove(result.size() - 1);
        }

        System.out.println(result);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] preorder = new int[n];

        for (int i = 0; i < n; i++) {
            preorder[i] = sc.nextInt();
        }

        TreeNode root = buildBST(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);

        levelOrder(root);
    }
}