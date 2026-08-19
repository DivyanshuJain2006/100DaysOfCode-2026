class Solution {

    int countSafe(TreeNode root, int maxAltitude) {
        if (root == null) {
            return 0;
        }

        int count = 0;

        // Check whether current campsite is safe
        if (root.val >= maxAltitude) {
            count = 1;
            maxAltitude = root.val;
        }

        // Check left subtree
        count += countSafe(root.left, maxAltitude);

        // Check right subtree
        count += countSafe(root.right, maxAltitude);

        return count;
    }

    public int countSafeNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return countSafe(root, root.val);
    }
}
