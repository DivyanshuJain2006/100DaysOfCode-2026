package Day_64;

public class Question2 {
    public int lowestCommonAncestor(TreeNode root, int a, int b) {
    if (a < root.val && b < root.val) {
        return lowestCommonAncestor(root.left, a, b);
    }
    if (a > root.val && b > root.val) {
        return lowestCommonAncestor(root.right, a, b);
    }
    return root.val;
}
}
