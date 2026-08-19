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
    public int countNodes(TreeNode root) {
        if(root==null){
            return 0;
        }
       int ld=ld(root);
       int rd=rd(root);

       if(ld==rd){
        return (1<<ld)-1;
       }

       return 1+countNodes(root.left)+countNodes(root.right);
       }
    
    private int rd(TreeNode root){
        int d=0;
        while(root!=null){
            root=root.right;
            d++;
        }
        return d;
    }

    private int ld(TreeNode root){
        int de=0;
        while(root!=null){
            root=root.left;
            de++;
        }
        return de;
    }
    }

