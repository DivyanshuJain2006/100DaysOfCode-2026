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
      TreeNode prev=null;
        int count=0;
        int max=0;
      
    public int[] findMode(TreeNode root) {
      prev=null;
      count=0;
      max=0;
            if(root==null){
                return new int[0];
            }
            List<Integer> l=new ArrayList<>();
            traverse(root,l);
            int[] res=new int[l.size()];
            for(int i=0;i<l.size();i++){
                res[i]=l.get(i);
            }
            return res;
    }

        private void traverse(TreeNode root,List<Integer> l){
            if(root==null){
                return;
            }
            traverse(root.left,l);
            if(prev==null){
                count=1;}

               else if(root.val==prev.val){
                count++;
               }  else{
                count=1;
               }
            
            if(count>max){
                max=count;
                l.clear();
                l.add(root.val);
            } else if(count==max){
                l.add(root.val);
            }
            prev=root;
            traverse(root.right,l);
        
    }
}