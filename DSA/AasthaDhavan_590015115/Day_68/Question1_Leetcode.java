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
    void inorder(TreeNode root,ArrayList<Integer> a){
        if(root==null){
            return;
        }
        inorder(root.left,a);
        a.add(root.val);
        inorder(root.right,a);
    }

    TreeNode construct(int l,int r,ArrayList<Integer> a ){
        if(l>r){
            return null;
        }
        int m=l+(r-l)/2;
        TreeNode root=new TreeNode(a.get(m));
        root.left=construct(l,m-1,a);
        root.right=construct(m+1,r,a);
        return root;
    }
    public TreeNode balanceBST(TreeNode root) {
      ArrayList<Integer> a=new ArrayList<>();
      inorder(root,a);
      int l=0;
      int r=a.size()-1;
      return construct(l,r,a);  
    }
}