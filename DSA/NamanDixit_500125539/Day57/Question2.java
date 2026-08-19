
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Question2 {

    // Simple TreeNode class representing one node of a binary tree
    static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    // Function to check if two trees are MIRROR IMAGES of each other
    public static boolean isMirror(TreeNode node1, TreeNode node2) {

        // Case 1: Both nodes are null -- they match perfectly (nothing vs nothing)
        if (node1 == null && node2 == null) {
            return true;
        }

        // Case 2: Only ONE of them is null -- structures don't match, so not a mirror
        if (node1 == null || node2 == null) {
            return false;
        }

        // Case 3: Both nodes exist, but their values are different -- not a mirror
        if (node1.val != node2.val) {
            return false;
        }

        // Case 4: Values match! Now recursively check the CROSSED pairs:
        // node1's LEFT should mirror node2's RIGHT,
        // and node1's RIGHT should mirror node2's LEFT.
        boolean outerPairMatches = isMirror(node1.left, node2.right);
        boolean innerPairMatches = isMirror(node1.right, node2.left);

        // Both crossed comparisons must be true for the whole tree to be a mirror
        return outerPairMatches && innerPairMatches;
    }

    // Function that returns "YES" or "NO" based on whether the two warehouses (trees) mirror each other
    public static String checkMirrorWarehouses(TreeNode root1, TreeNode root2) {
        return isMirror(root1, root2) ? "YES" : "NO";
    }

    // Helper function to build a binary tree from a level-order array,
    // where -1 represents a missing (null) node. (Same style as before.)
    public static TreeNode buildTree(int[] values) {

        if (values.length == 0 || values[0] == -1) {
            return null;
        }

        TreeNode root = new TreeNode(values[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int i = 1;

        while (!queue.isEmpty() && i < values.length) {
            TreeNode current = queue.poll();

            // Assign left child, if the next value isn't -1
            if (i < values.length) {
                int leftVal = values[i++];
                if (leftVal != -1) {
                    current.left = new TreeNode(leftVal);
                    queue.add(current.left);
                }
            }

            // Assign right child, if the next value isn't -1
            if (i < values.length) {
                int rightVal = values[i++];
                if (rightVal != -1) {
                    current.right = new TreeNode(rightVal);
                    queue.add(current.right);
                }
            }
        }

        return root;
    }

    // Main method: takes user input and prints the result
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Step 1: Read warehouse1 (tree1)
        System.out.println("Enter the number of values in warehouse1:");
        int n1 = Integer.parseInt(scanner.nextLine().trim());

        System.out.println("Enter " + n1 + " values for warehouse1, separated by spaces (use -1 for missing nodes):");
        String[] parts1 = scanner.nextLine().trim().split("\\s+");
        int[] values1 = new int[n1];
        for (int i = 0; i < n1; i++) {
            values1[i] = Integer.parseInt(parts1[i]);
        }

        // Step 2: Read warehouse2 (tree2)
        System.out.println("Enter the number of values in warehouse2:");
        int n2 = Integer.parseInt(scanner.nextLine().trim());

        System.out.println("Enter " + n2 + " values for warehouse2, separated by spaces (use -1 for missing nodes):");
        String[] parts2 = scanner.nextLine().trim().split("\\s+");
        int[] values2 = new int[n2];
        for (int i = 0; i < n2; i++) {
            values2[i] = Integer.parseInt(parts2[i]);
        }

        // Step 3: Build both trees
        TreeNode root1 = buildTree(values1);
        TreeNode root2 = buildTree(values2);

        // Step 4: Call the function and print the result
        String result = checkMirrorWarehouses(root1, root2);

        System.out.println("Are the warehouses mirror images? " + result);

        scanner.close();
    }
}
