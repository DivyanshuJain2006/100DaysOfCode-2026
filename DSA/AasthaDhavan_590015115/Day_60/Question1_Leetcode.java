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
    int dia=0;
    public int diameterOfBinaryTree(TreeNode root) {
        lpath(root);
        return dia;
    }
    private int lpath(TreeNode root){
        if(root==null){
            return 0;
        }
        int lp=lpath(root.left);
        int rp=lpath(root.right);
        dia = Math.max(dia,lp+rp);
        return Math.max(lp,rp)+1;
    }
}