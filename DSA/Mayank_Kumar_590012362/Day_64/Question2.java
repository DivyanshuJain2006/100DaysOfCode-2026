class Solution {
    public TreeNode lca(TreeNode r, int a, int b) {
        while (r != null) {
            if (a < r.val && b < r.val) r = r.left;
            else if (a > r.val && b > r.val) r = r.right;
            else return r;
        }
        return null;
    }
}