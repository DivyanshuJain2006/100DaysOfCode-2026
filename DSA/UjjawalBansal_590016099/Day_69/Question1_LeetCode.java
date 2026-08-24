public class Question1_LeetCode {
    private int i = 0;
    public TreeNode bstFromPreorder(int[] preorder) {
        return buildTree(preorder, Integer.MAX_VALUE);
    }

    private TreeNode buildTree(int[] preorder, int bound) {
        if (i == preorder.length || preorder[i] > bound) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[i++]);
        root.left = buildTree(preorder, root.val);
        root.right = buildTree(preorder, bound);
        return root;
    }
}