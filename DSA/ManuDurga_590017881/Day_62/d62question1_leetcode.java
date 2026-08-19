package Day_62;

import java.util.*;

public class d62question1_leetcode {
     public boolean evaluateTree(TreeNode root) {
         // Leaf node
        if (root.left == null && root.right == null) {
            return root.val == 1;
        }

        // Evaluate left and right subtrees
        boolean left = evaluateTree(root.left);
        boolean right = evaluateTree(root.right);

        // 2 = OR, 3 = AND
        if (root.val == 2) {
            return left || right;
        } else {
            return left && right;
        }
        
    }    }
