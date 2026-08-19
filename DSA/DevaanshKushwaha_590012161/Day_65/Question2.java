class Solution {
    public int closestValue(TreeNode root, double target) {
        int closest = root.val;
        TreeNode curr = root;

        while (curr != null) {
            if (Math.abs(curr.val - target) < Math.abs(closest - target) ||
                (Math.abs(curr.val - target) == Math.abs(closest - target) && curr.val < closest)) {
                closest = curr.val;
            }

            if (target < curr.val) {
                curr = curr.left;
            } else if (target > curr.val) {
                curr = curr.right;
            } else {
                // exact match, can't get closer
                return curr.val;
            }
        }

        return closest;
    }
}
