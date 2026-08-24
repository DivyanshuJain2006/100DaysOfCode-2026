import javax.swing.tree.TreeNode;

public class Question1_LeetCode {
    private int sum = 0;
    
    public int sumOfLeftLeaves(TreeNode root) {
        addLeft(root);
        return sum;
    }
    
    private void addLeft(TreeNode root) {
        if (root == null) {
            return;
        }
        
        if (root.left != null && root.left.left == null && root.left.right == null) {
            sum += root.left.val;
        }

        addLeft(root.left);
        addLeft(root.right);
    }
}
