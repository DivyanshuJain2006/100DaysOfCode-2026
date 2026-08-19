import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int val) { this.val = val; }
}

class Solution {
    
    // Builds tree from level-order array; -1 denotes a missing node
    public TreeNode buildTree(int[] arr) {
        if (arr.length == 0 || arr[0] == -1) return null;
        
        TreeNode root = new TreeNode(arr[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        int i = 1;
        while (!queue.isEmpty() && i < arr.length) {
            TreeNode curr = queue.poll();
            
            // Left child
            if (i < arr.length) {
                if (arr[i] != -1) {
                    curr.left = new TreeNode(arr[i]);
                    queue.offer(curr.left);
                }
                i++;
            }
            
            // Right child
            if (i < arr.length) {
                if (arr[i] != -1) {
                    curr.right = new TreeNode(arr[i]);
                    queue.offer(curr.right);
                }
                i++;
            }
        }
        
        return root;
    }
    
    // Checks whether a value exists in the tree
    private boolean exists(TreeNode root, int target) {
        if (root == null) return false;
        if (root.val == target) return true;
        return exists(root.left, target) || exists(root.right, target);
    }
    
    // Standard recursive LCA finder
    private TreeNode findLCA(TreeNode root, int a, int b) {
        if (root == null || root.val == a || root.val == b) {
            return root;
        }
        
        TreeNode left = findLCA(root.left, a, b);
        TreeNode right = findLCA(root.right, a, b);
        
        if (left != null && right != null) {
            return root; // a and b found in different subtrees -> this is LCA
        }
        
        return (left != null) ? left : right;
    }
    
    // Main entry point: resolves the dispute
    public int resolveDispute(int[] arr, int a, int b) {
        TreeNode root = buildTree(arr);
        
        // Validate both employees exist before searching
        if (!exists(root, a) || !exists(root, b)) {
            return -1;
        }
        
        TreeNode lca = findLCA(root, a, b);
        return (lca != null) ? lca.val : -1;
    }
}
