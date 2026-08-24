
class Question1_leetcode {

    int maxDiameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return maxDiameter;
    }

    private int height(TreeNode node) {

        if (node == null) {
            return -1;
        }

        int leftHeight = height(node.left);
        int rightHeight = height(node.right);

        int diameterThroughThisNode = leftHeight + rightHeight + 2;
        maxDiameter = Math.max(maxDiameter, diameterThroughThisNode);

        return Math.max(leftHeight, rightHeight) + 1;
    }
}
