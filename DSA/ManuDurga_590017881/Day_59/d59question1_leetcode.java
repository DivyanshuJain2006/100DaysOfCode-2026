package Day_59;

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


public class d59question1_leetcode {
     public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        boolean gap = false;

        while (!q.isEmpty()) {
            TreeNode node = q.poll();

            if (node == null) {
                gap = true;
            } else {
                if (gap) return false; // once a null is seen, no more nodes allowed
                q.add(node.left);
                q.add(node.right);
            }
        }
        return true;
    }
    }
