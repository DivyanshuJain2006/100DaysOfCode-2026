class Solution {
    public int rangeSumBST(TreeNode r, int l, int h) {
        if (r == null) return 0;
        if (r.val < l) return rangeSumBST(r.right, l, h);
        if (r.val > h) return rangeSumBST(r.left, l, h);
        return r.val + rangeSumBST(r.left, l, h) + rangeSumBST(r.right, l, h);
    }
}