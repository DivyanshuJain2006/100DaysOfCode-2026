import java.util.*;

// ---------------------------------------------------------
// TREE NODE
// ---------------------------------------------------------

class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    // Constructor
    TreeNode(int val) {
        this.val = val;
    }
}


// ---------------------------------------------------------
// SOLUTION CLASS
// ---------------------------------------------------------

class Solution {

    // ---------------------------------------------------------
    // FUNCTION TO SPLIT BST
    // ---------------------------------------------------------

    TreeNode[] splitBST(TreeNode root, int k) {

        // If tree is empty
        if (root == null) {
            return new TreeNode[]{null, null};
        }

        // If current value is smaller than K,
        // it belongs to the LEFT BST.
        if (root.val < k) {

            // Split the right subtree
            TreeNode[] result = splitBST(root.right, k);

            // The current node stays in the first BST
            root.right = result[0];

            // result[1] becomes the second BST
            return new TreeNode[]{root, result[1]};
        }

        // If current value is greater than or equal to K,
        // it belongs to the RIGHT BST.
        else {

            // Split the left subtree
            TreeNode[] result = splitBST(root.left, k);

            // The current node stays in the second BST
            root.left = result[1];

            // result[0] is the first BST
            return new TreeNode[]{result[0], root};
        }
    }

    // ---------------------------------------------------------
    // PREORDER TRAVERSAL
    // ---------------------------------------------------------

    void preorder(TreeNode root, StringBuilder result) {

        // If there is no node, stop
        if (root == null) {
            return;
        }

        // Visit root first
        result.append(root.val).append(" ");

        // Visit left subtree
        preorder(root.left, result);

        // Visit right subtree
        preorder(root.right, result);
    }
}


// ---------------------------------------------------------
// DRIVER / MAIN CLASS
// ---------------------------------------------------------

public class Question2 {

    // ---------------------------------------------------------
    // INSERT INTO BST
    // Used to create the original BST
    // ---------------------------------------------------------

    static TreeNode insert(TreeNode root, int value) {

        // If tree is empty, create a new node
        if (root == null) {
            return new TreeNode(value);
        }

        // Smaller values go to the left
        if (value < root.val) {
            root.left = insert(root.left, value);
        }

        // Greater or equal values go to the right
        else {
            root.right = insert(root.right, value);
        }

        return root;
    }


    // ---------------------------------------------------------
    // MAIN FUNCTION
    // ---------------------------------------------------------

    public static void main(String[] args) {

        // Scanner takes input from user
        Scanner sc = new Scanner(System.in);

        // Take number of nodes
        int n = sc.nextInt();

        // Initially tree is empty
        TreeNode root = null;

        // Take BST elements
        for (int i = 0; i < n; i++) {

            int value = sc.nextInt();

            // Insert value into BST
            root = insert(root, value);
        }

        // Take K
        int k = sc.nextInt();

        // Create Solution object
        Solution solution = new Solution();

        // Split the BST
        TreeNode[] result = solution.splitBST(root, k);

        // StringBuilders for preorder traversal
        StringBuilder first = new StringBuilder();
        StringBuilder second = new StringBuilder();

        // Get preorder of first BST
        solution.preorder(result[0], first);

        // Get preorder of second BST
        solution.preorder(result[1], second);

        // Remove extra space
        String firstResult = first.toString().trim();
        String secondResult = second.toString().trim();

        // If first BST is empty
        if (firstResult.isEmpty()) {
            firstResult = "EMPTY";
        }

        // If second BST is empty
        if (secondResult.isEmpty()) {
            secondResult = "EMPTY";
        }

        // Print result
        System.out.println(
            "[\"" + firstResult + "\", \"" + secondResult + "\"]"
        );

        // Close Scanner
        sc.close();
    }
}