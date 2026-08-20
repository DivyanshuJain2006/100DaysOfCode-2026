class Solution {
    int[] c = new int[3];
    TreeNode b(int[] a, int l, int h) {
        if (l > h) return null;
        int m = (l + h) / 2;
        TreeNode n = new TreeNode(a[m]);
        n.left = b(a, l, m - 1);
        n.right = b(a, m + 1, h);
        return n;
    }
    int f(TreeNode n) {
        if (n == null) return -1;
        int p = f(n.left);
        int q = f(n.right);
        c[p - q + 1]++;
        return Math.max(p, q) + 1;
    }
    public int[] balanceSpectrum(int[] arr) {
        TreeNode r = b(arr, 0, arr.length - 1);
        f(r); return c;
    }
}
class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int v) { val = v; }
}