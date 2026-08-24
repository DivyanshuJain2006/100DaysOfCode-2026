class Solution {
    private int idx = 0;
    private int[] preorder;

    public TreeNode bstFromPreorder(int[] preorder) {
        this.preorder = preorder;
        return build(Integer.MAX_VALUE);
    }

    // Builds a subtree whose values must all be < upperBound
    private TreeNode build(int upperBound) {
        if (idx == preorder.length || preorder[idx] > upperBound) {
            return null;
        }
        int val = preorder[idx++];
        TreeNode node = new TreeNode(val);
        node.left = build(val);          // left subtree: everything < val
        node.right = build(upperBound);  // right subtree: everything < upperBound (but > val, guaranteed by preorder order)
        return node;
    }
}
