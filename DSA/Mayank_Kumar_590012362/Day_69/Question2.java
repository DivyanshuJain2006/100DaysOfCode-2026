class Solution {
    void f(TreeNode r, int k, List<Integer> a, List<Integer> b) {
        if (r == null) return;
        if (r.val < k) {
            a.add(r.val);
            f(r.left, k, a, b);
            f(r.right, k, a, b);
        } else {
            b.add(r.val);
            f(r.left, k, a, b);
            f(r.right, k, a, b);
        }
    }
}