public class Question1_LeetCode {
    private int getDepth(TreeNode node, boolean isLeft) {
        int depth = 0;
        while (node != null) {
            depth++;
            node = isLeft ? node.left : node.right;
        }
        return depth;
    }

    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        int leftDepth = getDepth(root, true);
        int rightDepth = getDepth(root, false);
        
        if (leftDepth == rightDepth) {
            return (1 << leftDepth) - 1; 
        }
        
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}
