class Solution {
    public int rob(TreeNode root) {
        int[] result = robHelper(root);
        return Math.max(result[0], result[1]);
    }

    // returns [maxIfRobbed, maxIfNotRobbed]
    private int[] robHelper(TreeNode node) {
        if (node == null) {
            return new int[]{0, 0};
        }

        int[] left = robHelper(node.left);
        int[] right = robHelper(node.right);

        // Rob this node: children must NOT be robbed
        int robThis = node.val + left[1] + right[1];

        // Don't rob this node: take the best of each child independently
        int notRobThis = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);

        return new int[]{robThis, notRobThis};
    }
}
