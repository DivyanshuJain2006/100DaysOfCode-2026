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
    public TreeNode balanceBST(TreeNode root) {
        int [] arr = arrayConversion (root);
        return createBST (arr, 0 ,arr.length-1);

       
    }

    public int [] arrayConversion (TreeNode root) {
        if (root == null) {
            return new int [0];
        }
        ArrayList <Integer> al = new ArrayList <> ();

        inorder(root,al);

        int [] arr = al.stream().mapToInt(Integer:: intValue).toArray();

        return arr;

    }

    public void inorder (TreeNode root , ArrayList <Integer> al ) {
        if (root == null) {
            return;
        }
        inorder(root.left,al);
        al.add(root.val);
        inorder(root.right,al);
    }

    public TreeNode createBST (int arr [] , int left , int right ) {
        if (left > right) {
            return null;
        }
        int mid = (left+right)/2;

        TreeNode root = new TreeNode (arr[mid]);
        root.left = createBST (arr , left , mid-1);
        root.right = createBST (arr , mid+1 , right);
        return root;
    }
}