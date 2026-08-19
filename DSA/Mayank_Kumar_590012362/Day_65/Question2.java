public class Question2 {
    int f(TreeNode r, double t) {
        int a = r.val;
        while (r != null) {
            if (Math.abs(r.val - t) < Math.abs(a - t) || Math.abs(r.val - t) == Math.abs(a - t) && r.val < a)
            a = r.val;
            r = r.val < t ? r.right : r.left;
        } return a;
    }
}