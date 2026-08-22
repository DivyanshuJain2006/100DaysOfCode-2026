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
    public TreeNode bstFromPreorder(int[] preorder) {
        return helper(preorder,0,preorder.length);
    }
    public TreeNode helper(int[] preorder,int rootidx,int r){
        if(rootidx>=r) return null;
        int val=preorder[rootidx];
        TreeNode root=new TreeNode(val);
        int i=rootidx+1;
        while(i<=preorder.length-1 && preorder[i]<val){
            i++;
        }
        root.left=helper(preorder,rootidx+1,i);
        root.right=helper(preorder,i,r);
        return root;
    }
}