class Solution {
    public int findClosestValue(TreeNode root, double target) {
        int closest = root.val;

        while (root != null) {
            double currentDiff = Math.abs(root.val - target);
            double closestDiff = Math.abs(closest - target);

        
            if (currentDiff < closestDiff ||
                (currentDiff == closestDiff && root.val < closest)) {
                closest = root.val;
            }

            
            if (target < root.val) {
                root = root.left;
            } else if (target > root.val) {
                root = root.right;
            } else {
                return root.val;
            }
        }

        return closest;
    }
}
