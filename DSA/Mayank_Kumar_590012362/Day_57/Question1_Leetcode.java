class Solution {
    public int sumOfLeftLeaves(TreeNode r) {
        if (r == null) return 0;
        if (r.left != null && r.left.left == null && r.left.right == null) return r.left.val + sumOfLeftLeaves(r.right);
        return sumOfLeftLeaves(r.left) + sumOfLeftLeaves(r.right);
    }
}