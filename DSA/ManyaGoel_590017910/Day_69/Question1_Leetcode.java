public class Question1_Leetcode {
    int i = 0;
    public TreeNode bstFromPreorder(int[] preorder) {
        return build(preorder, Integer.MAX_VALUE);
    }
    private TreeNode build(int[] preorder, int max) {
        if (i == preorder.length || preorder[i] > max)
            return null;
        TreeNode node = new TreeNode(preorder[i++]);
        node.left = build(preorder, node.val);
        node.right = build(preorder, max);
        return node;
    }
}