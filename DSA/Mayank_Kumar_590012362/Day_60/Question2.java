public class Question2 {
    static int countSafe(TreeNode r, int m) {
        if (r == null) return 0;
        int c = r.val >= m ? 1 : 0;
        m = Math.max(m, r.val);
        return c + countSafe(r.left, m) + countSafe(r.right, m);
    }
}