
import java.util.*;

class Solution {
    public List<Integer> getAllUniqueEmployeeIDs(TreeNode root1, TreeNode root2) {
        Set<Integer> uniqueIDs = new HashSet<>();
        inOrderTraversal(root1, uniqueIDs);
        inOrderTraversal(root2, uniqueIDs);
        
        List<Integer> sortedUniqueIDs = new ArrayList<>(uniqueIDs);
        Collections.sort(sortedUniqueIDs);
        
        return sortedUniqueIDs;
    }
    
    private void inOrderTraversal(TreeNode node, Set<Integer> uniqueIDs) {
        if (node == null) {
            return;
        }
        inOrderTraversal(node.left, uniqueIDs);
        uniqueIDs.add(node.val);
        inOrderTraversal(node.right, uniqueIDs);
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }
}