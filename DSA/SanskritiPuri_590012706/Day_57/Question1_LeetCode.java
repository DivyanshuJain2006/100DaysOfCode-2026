class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;
        
        int sum = 0;
        
        if (root.left != null) {
            if (root.left.left == null && root.left.right == null) {
                // Left child is a leaf, add its value
                sum += root.left.val;
            } else {
                // Left child has children, recurse into it
                sum += sumOfLeftLeaves(root.left);
            }
        }
        
        // Always recurse into the right subtree (never add its leaves directly)
        sum += sumOfLeftLeaves(root.right);
        
        return sum;
    }
}
