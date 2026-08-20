//Need to find the longest path between any two nodes

class Solution {

    private int diameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {

        height(root);
        return diameter;
    }

    private int height(TreeNode node)
    {
        if (node == null) {
            return 0;
        }

        int left = height(node.left);
        int right = height(node.right);

        // path through this node
        diameter = Math.max(diameter, left + right);

        return 1 + Math.max(left, right);
    }
}
