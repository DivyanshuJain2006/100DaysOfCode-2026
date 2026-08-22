class Solution {

    int index = 0;

    public TreeNode bstFromPreorder(int[] preorder) {
        return build(preorder, Integer.MAX_VALUE);
    }

    private TreeNode build(int[] preorder, int bound) {

        // No more elements or current value cannot belong here
        if (index == preorder.length || preorder[index] > bound) {
            return null;
        }

        // Current preorder element becomes root
        TreeNode root = new TreeNode(preorder[index]);
        index++;

        // Smaller values go to left
        root.left = build(preorder, root.val);

        // Values up to the current bound go to right
        root.right = build(preorder, bound);

        return root;
    }
}