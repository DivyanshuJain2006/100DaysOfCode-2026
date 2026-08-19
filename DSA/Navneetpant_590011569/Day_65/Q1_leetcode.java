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
    int [] arr = new int [1];
    ArrayList <Integer> al = new ArrayList <> ();
    public int[] findMode(TreeNode root) {
        traverse(root);
        return removeLow(al);
    }

    public void traverse(TreeNode root) {
        if (root == null) {
            return;
        }

        traverse(root.left);

        al.add(root.val);

        traverse(root.right);
    }
    public int [] removeLow(ArrayList <Integer> al){
        HashMap <Integer,Integer> hm = new HashMap <> ();
        for (int i = 0 ; i < al.size() ; i++ ) {
            hm.put(al.get(i),hm.getOrDefault(al.get(i),0)+1);

        }
        int max = 0;
        for (int count : hm.values()) {
            max = Math.max(max, count);
        }
        ArrayList <Integer> arrlist = new ArrayList <> ();

        for (Map.Entry <Integer,Integer> entry : hm.entrySet()){
            if (entry.getValue() == max) {
                arrlist.add(entry.getKey());
            }

        }
        return arrlist.stream().mapToInt(Integer::intValue).toArray();



    }
 }