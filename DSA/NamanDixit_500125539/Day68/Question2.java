import java.util.*;

// Node of the binary tree
class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    // Constructor
    TreeNode(int val) {
        this.val = val;
    }
}

// Solution class
class Solution {

    // This function returns information about a subtree
    static class Info {

        int size;       // Number of nodes in subtree
        int min;        // Minimum value
        int max;        // Maximum value
        boolean isBST;  // Is this subtree a BST?

        Info(int size, int min, int max, boolean isBST) {
            this.size = size;
            this.min = min;
            this.max = max;
            this.isBST = isBST;
        }
    }

    // Stores the largest BST size found
    int largestBST = 0;

    // Function to find the largest BST
    public int largestBSTSubtree(TreeNode root) {

        // Check the tree recursively
        checkBST(root);

        // Return the largest BST size
        return largestBST;
    }

    // Function to check whether a subtree is a BST
    Info checkBST(TreeNode root) {

        // Empty tree is a BST
        if (root == null) {
            return new Info(0, Integer.MAX_VALUE,
                    Integer.MIN_VALUE, true);
        }

        // Check left subtree
        Info left = checkBST(root.left);

        // Check right subtree
        Info right = checkBST(root.right);

        // Check if current subtree is a BST
        if (left.isBST &&
            right.isBST &&
            root.val > left.max &&
            root.val < right.min) {

            // Calculate size of current BST
            int size = left.size + right.size + 1;

            // Update largest BST
            largestBST = Math.max(largestBST, size);

            // Find minimum value
            int min = Math.min(root.val, left.min);

            // Find maximum value
            int max = Math.max(root.val, right.max);

            // Return information about this BST
            return new Info(size, min, max, true);
        }

        // If it is not a BST
        return new Info(0, 0, 0, false);
    }
}

// Driver class
public class Question2 {

    // Insert a value into the binary tree
    // This is only used to build the input tree
    static TreeNode buildTree(int[] arr) {

        // Empty tree
        if (arr.length == 0 || arr[0] == -1) {
            return null;
        }

        // Create root
        TreeNode root = new TreeNode(arr[0]);

        // Queue helps us build tree level by level
        Queue<TreeNode> queue = new LinkedList<>();

        // Add root to queue
        queue.add(root);

        int i = 1;

        // Build the tree
        while (i < arr.length) {

            // Get current node
            TreeNode current = queue.poll();

            // Create left child
            if (i < arr.length && arr[i] != -1) {

                current.left = new TreeNode(arr[i]);

                queue.add(current.left);
            }

            i++;

            // Create right child
            if (i < arr.length && arr[i] != -1) {

                current.right = new TreeNode(arr[i]);

                queue.add(current.right);
            }

            i++;
        }

        return root;
    }

    // Main function
    public static void main(String[] args) {

        // Scanner takes input from user
        Scanner sc = new Scanner(System.in);

        // Take number of elements
        int n = sc.nextInt();

        // Create array
        int[] arr = new int[n];

        // Take tree elements
        // -1 means there is no node
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // Build the binary tree
        TreeNode root = buildTree(arr);

        // Create Solution object
        Solution solution = new Solution();

        // Find largest BST
        int answer = solution.largestBSTSubtree(root);

        // Print answer
        System.out.println(answer);

        // Close Scanner
        sc.close();
    }
}