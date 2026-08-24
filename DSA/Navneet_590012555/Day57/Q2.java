class Solution {
    public boolean isMirror(TreeNode a, TreeNode b) {
        if (a == null && b == null)
            return true;

        if (a == null || b == null)
            return false;

        if (a.val != b.val)
            return false;

        return isMirror(a.left, b.right) &&
                isMirror(a.right, b.left);
    }
}