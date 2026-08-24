// Definition for a binary tree node
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

public class SumOfLeftLeaves {

    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;

        int sum = 0;

        // Check if left child exists
        if (root.left != null) {
            // Check if left child is a leaf
            if (isLeaf(root.left)) {
                sum += root.left.val;
            } else {
                sum += sumOfLeftLeaves(root.left);
            }
        }

        // Always check right subtree
        sum += sumOfLeftLeaves(root.right);

        return sum;
    }

    // Helper function to check leaf
    private boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }

    // Main method for testing in VS Code
    public static void main(String[] args) {
        SumOfLeftLeaves obj = new SumOfLeftLeaves();

        // Creating sample tree: [3,9,20,null,null,15,7]
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        int result = obj.sumOfLeftLeaves(root);
        System.out.println("Sum of Left Leaves: " + result); // Output: 24
    }
}