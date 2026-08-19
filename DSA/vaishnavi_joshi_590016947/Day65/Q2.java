import java.util.*;

class Solution {

    public int closestValue(TreeNode root, double target) {
        int closest = root.val;

        while (root != null) {

            // Check if current value is closer
            if (Math.abs(root.val - target) < Math.abs(closest - target)) {
                closest = root.val;
            }

            // If distance is equal, choose smaller value
            else if (Math.abs(root.val - target) == Math.abs(closest - target)
                    && root.val < closest) {
                closest = root.val;
            }

            // Use BST property
            if (target < root.val) {
                root = root.left;
            } else {
                root = root.right;
            }
        }

        return closest;
    }
}