import javax.swing.tree.TreeNode;

public class Question1_LeetCode {
    private int maxD = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        calculateDepth(root);
        return maxD;
    }

    private int calculateDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftD = calculateDepth(node.left);
        int rightD = calculateDepth(node.right);
        maxD = Math.max(maxD, leftD + rightD);
        return Math.max(leftD, rightD) + 1;
    }
}
