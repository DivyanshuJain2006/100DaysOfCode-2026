class Solution {

    public int lowestCommonAncestor(TreeNode root, int a, int b) {

        while (root != null) {

            // Both values are smaller → go left
            if (a < root.val && b < root.val) {
                root = root.left;
            }

            // Both values are greater → go right
            else if (a > root.val && b > root.val) {
                root = root.right;
            }

            // They are on different sides, or one is root
            else {
                return root.val;
            }
        }

        return -1;
    }
}