class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, int a, int b) {

        while (root != null) {

            // Both values are smaller than root
            if (a < root.val && b < root.val) {
                root = root.left;
            }

            // Both values are greater than root
            else if (a > root.val && b > root.val) {
                root = root.right;
            }

            // They are on different sides,
            // or root itself is one of them
            else {
                return root;
            }
        }

        return null;
    }
}
