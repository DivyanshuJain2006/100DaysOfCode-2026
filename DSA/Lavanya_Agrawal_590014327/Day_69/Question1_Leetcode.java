import java.util.*;

public class Question1_Leetcode {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    static int index = 0;

    static TreeNode buildBST(int[] preorder, int upperBound) {

        if (index == preorder.length || preorder[index] > upperBound) {
            return null;
        }

        int value = preorder[index++];

        TreeNode root = new TreeNode(value);

        root.left = buildBST(preorder, value);
        root.right = buildBST(preorder, upperBound);

        return root;
    }

    static TreeNode bstFromPreorder(int[] preorder) {

        index = 0;

        return buildBST(preorder, Integer.MAX_VALUE);
    }

    static void printLevelOrder(TreeNode root) {

        if (root == null) {
            System.out.println("[]");
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        List<String> result = new ArrayList<>();

        queue.add(root);

        while (!queue.isEmpty()) {

            TreeNode current = queue.poll();

            if (current == null) {
                result.add("null");
                continue;
            }

            result.add(String.valueOf(current.val));

            queue.add(current.left);
            queue.add(current.right);
        }

        // Remove trailing nulls
        while (!result.isEmpty()
                && result.get(result.size() - 1).equals("null")) {
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

        TreeNode root = bstFromPreorder(preorder);

        printLevelOrder(root);

        sc.close();
    }
}