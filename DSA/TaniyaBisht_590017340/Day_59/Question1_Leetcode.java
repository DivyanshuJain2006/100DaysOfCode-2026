
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isCompleteTree(TreeNode root) {
        if(root==null){
            return true;
        }
        int totalNodes= countNodes(root);
        return isCompleteTree(root, 0, totalNodes);

    }
    private boolean isCompleteTree(TreeNode root, int idx, int totalNodes){
        if(root==null){
            return true;
        }
        if(idx>=totalNodes){
            return false;
        }
        return isCompleteTree(root.left, 2*idx+1, totalNodes) && isCompleteTree(root.right, 2*idx+2, totalNodes);
    }
    private int countNodes(TreeNode root){
        if(root==null){
            return 0;
        }
        return 1+countNodes(root.left) + countNodes(root.right);
    }
}