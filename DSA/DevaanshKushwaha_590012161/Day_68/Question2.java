class Solution {
    int maxSize = 0;
    
    class Info {
        boolean isBST;
        int size;
        int min, max;
        Info(boolean isBST, int size, int min, int max) {
            this.isBST = isBST;
            this.size = size;
            this.min = min;
            this.max = max;
        }
    }
    
    public int largestBSTSubtree(TreeNode root) {
        postOrder(root);
        return maxSize;
    }
    
    private Info postOrder(TreeNode node) {
        if (node == null) {
            // Neutral element: valid "empty" BST, size 0.
            // max=MIN_VALUE, min=MAX_VALUE so any parent value satisfies bounds.
            return new Info(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }
        
        Info left = postOrder(node.left);
        Info right = postOrder(node.right);
        
        if (left.isBST && right.isBST && node.val > left.max && node.val < right.min) {
            int size = left.size + right.size + 1;
            maxSize = Math.max(maxSize, size);
            int min = (node.left == null) ? node.val : left.min;
            int max = (node.right == null) ? node.val : right.max;
            return new Info(true, size, min, max);
        }
        
        // Not a BST here — invalidate upward, values don't matter anymore
        return new Info(false, 0, 0, 0);
    }
}
