public class Question2 {
    static boolean isMirror(TreeNode a, TreeNode b) {
        if (a == null || b == null) return a == b;
        return a.val == b.val && isMirror(a.left, b.right) && isMirror(a.right, b.left);
    }
}