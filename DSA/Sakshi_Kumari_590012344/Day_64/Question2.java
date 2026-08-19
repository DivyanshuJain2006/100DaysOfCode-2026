class Solution {
    public int lowestCommonAncestor(TreeNode root, int p, int q) {

        while (root != null) {

            if (p < root.val && q < root.val) {
                root = root.left;
            }

            else if (p > root.val && q > root.val) {
                root = root.right;
            }

            else {
                return root.val;
            }
        }

        return -1;
    }
}
