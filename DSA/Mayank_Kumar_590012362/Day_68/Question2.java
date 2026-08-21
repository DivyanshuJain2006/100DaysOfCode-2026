class Solution {
    int ans;
    int[] f(TreeNode r) {
        if (r == null) return new int[]{1, 0, Integer.MAX_VALUE, Integer.MIN_VALUE};
        int[] l = f(r.left), q = f(r.right);
        if (l[0] == 1 && q[0] == 1 && l[3] < r.val && r.val < q[2]) {
            int s = l[1] + q[1] + 1;
            ans = Math.max(ans, s);
            return new int[]{1, s, Math.min(l[2], r.val), Math.max(q[3], r.val)};
        }
        return new int[]{0, 0, 0, 0};
    }
    public int largestBSTSubtree(TreeNode r) {
        f(r); return ans;
    }
}