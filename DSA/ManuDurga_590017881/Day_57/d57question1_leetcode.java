package Day_57;

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


public class d57question1_leetcode {
    public static int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        int total = 0;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            
            if (node.left != null) {
                if (node.left.left == null && node.left.right == null) {
                    total += node.left.val;
                }
                stack.push(node.left);
            }
            
            if (node.right != null) {
                stack.push(node.right);
            }
        }
        
        return total;
    }
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
