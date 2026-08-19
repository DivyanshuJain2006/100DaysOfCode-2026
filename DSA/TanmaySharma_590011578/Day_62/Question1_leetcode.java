package DSA.TanmaySharma_590011578.Day_62;
class Solution {
    public boolean evaluateTree(TreeNode root) {
        // Leaf node: value is 0 (False) or 1 (True)
        if (root.val == 0) return false;
        if (root.val == 1) return true;
        
        boolean leftVal = evaluateTree(root.left);
        boolean rightVal = evaluateTree(root.right);
        
        // Internal node: value 2 = OR, value 3 = AND
        if (root.val == 2) {
            return leftVal || rightVal;
        } else { // root.val == 3
            return leftVal && rightVal;
        }
    }
}