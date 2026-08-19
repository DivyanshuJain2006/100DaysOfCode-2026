package Day_64;

import java.util.*;

public class d64question1_leetcode {
     public int rangeSumBST(TreeNode root, int low, int high) {
    if (root == null) 
        return 0;

    if (root.val < low) 
        return rangeSumBST(root.right, low, high);

    if (root.val > high) 
        return rangeSumBST(root.left, low, high);

    return root.val 
         + rangeSumBST(root.left, low, high) 
         + rangeSumBST(root.right, low, high);
}
    }
