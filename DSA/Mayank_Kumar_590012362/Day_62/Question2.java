public class Question2 {
    static int[] f(TreeNode r) {
        if (r == null) return new int[]{0, 0};
        int[] a = f(r.left);
        int[] b = f(r.right);
        int x = r.val + a[1] + b[1];
        int y = Math.max(a[0], a[1]) + Math.max(b[0], b[1]);
        return new int[]{x, y};
    }
    public static int rob(TreeNode r) {
        int[] a = f(r);
        return Math.max(a[0], a[1]);
    }
}