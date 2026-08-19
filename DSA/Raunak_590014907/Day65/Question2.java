class Solution {

    public int closestValue(TreeNode root, int target) {

        int answer = root.val;

        while (root != null) {

            // Current value is closer
            if (Math.abs(root.val - target) < Math.abs(answer - target)) {
                answer = root.val;
            }

            // Same distance -> choose smaller value
            else if (Math.abs(root.val - target) == Math.abs(answer - target)
                    && root.val < answer) {
                answer = root.val;
            }

            // Use BST property
            if (root.val < target) {
                root = root.right;
            } else {
                root = root.left;
            }
        }

        return answer;
    }
}