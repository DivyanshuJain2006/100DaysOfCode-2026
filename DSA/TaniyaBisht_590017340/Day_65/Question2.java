
import java.util.*;
class TT{
    static class TreeNode {
        int val; TreeNode left; TreeNode right;
        TreeNode(int val) {
            this.val = val;
        }
    }
    static int closestValue(TreeNode root, double target) {
        int closest = root.val;
        while (root != null) {
            if (root.val == target) {
                return root.val;
            }
            if (Math.abs(root.val - target) < Math.abs(closest - target)) {
                closest = root.val;
            }
            else if (Math.abs(root.val - target) == Math.abs(closest - target)) {
                closest = Math.min(closest, root.val);
            }
            if (target < root.val) {
                root = root.left;
            } 
            else {
                root = root.right;
            }
        }
        return closest;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        int target = 3;
        System.out.println(
            "Closest Temperature:" + closestValue(root, target)
        );
    }
}