class Solution {

    int index = 0;

    public TreeNode bstFromPreorder(int[] preorder) {
        return build(preorder, Integer.MAX_VALUE);
    }

    private TreeNode build(int[] preorder, int upperBound) {

        // No more elements
        // or current value cannot belong to this subtree
        if (index == preorder.length || preorder[index] > upperBound) {
            return null;
        }

        // Create current node
        TreeNode root = new TreeNode(preorder[index]);
        index++;

        // Build left subtree
        root.left = build(preorder, root.val);

        // Build right subtree
        root.right = build(preorder, upperBound);

        return root;
    }
}