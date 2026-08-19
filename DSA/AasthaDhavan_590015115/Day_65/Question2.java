import java.util.*;
class Question2 {
    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    }
    public static int closestValue(TreeNode root, int target) {
        int ans = root.val;

        while (root != null) {
            int diff = Math.abs(root.val - target);
            int ansDiff = Math.abs(ans - target);
            if (diff < ansDiff || (diff == ansDiff && root.val < ans)) {
                ans = root.val;
            }
            if (root.val < target)
                root = root.right;
            else
                root = root.left;
        }
        return ans;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        int target = 3;
        System.out.println(closestValue(root, target));
    }
}