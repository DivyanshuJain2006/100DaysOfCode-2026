class Solution {
    public boolean evaluateTree(TreeNode r) {
        if (r.left == null) return r.val == 1;
        boolean a = evaluateTree(r.left), b = evaluateTree(r.right);
        return r.val == 2 ? a || b : a && b;
    }
}