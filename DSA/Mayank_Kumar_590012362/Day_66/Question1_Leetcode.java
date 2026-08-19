class Solution {
    public TreeNode insertIntoBST(TreeNode r, int v) {
        if (r == null) return new TreeNode(v);
        if (v < r.val) r.left = insertIntoBST(r.left, v);
        else r.right = insertIntoBST(r.right, v);
        return r;
    }
}