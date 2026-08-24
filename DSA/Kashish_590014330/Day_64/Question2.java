class Solution {
    public int lowestCommonAncestor(TreeNode root, int a, int b) {

        while (root != null) {

            if (a < root.val && b < root.val) {
                root = root.left;
            }

            else if (a > root.val && b > root.val) {
                root = root.right;
            }
            else {
                return root.val;
            }
        }

        return -1;
    }
}