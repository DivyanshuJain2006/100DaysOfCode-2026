package Day_58;

import java.util.*;

// public class TreeNode {
//     int val;
//     TreeNode left;
//     TreeNode right;
//     TreeNode() {}
//     TreeNode(int val) { this.val = val; }
//     TreeNode(int val, TreeNode left, TreeNode right) {
//         this.val = val;
//         this.left = left;
//         this.right = right;
//     }
// }


public class d58question1_leetcode {
     public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        int leftHeight = getLeftHeight(root);

        int rightHeight = getRightHeight(root);
        
        if (leftHeight == rightHeight) {
            return (1 << leftHeight) - 1; 
        }
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
    
    private int getLeftHeight(TreeNode node) {
        int height = 0;
        while (node != null) { 
            height++; 
            node = node.left; }
        return height;
    }
    private int getRightHeight(TreeNode node) {
        int height = 0;
        while (node != null) { 
            height++; 
            node = node.right; 
        }
        return height;}}

    // public static void main(String[] args) {
    //    Scanner sc = new Scanner(System.in);
    //     System.out.print("Enter Size of Array: ");
    //     int n1 = sc.nextInt();
    //     int[] Arr1 = new int[n1];
    //     for(int i=0;i<n1;i++){
    //         System.out.print(": ");
    //         Arr1[i]=sc.nextInt();}
    //         System.out.println(sumOfLeftLeaves(Arr1));
    //     sc.close();    }
    }
