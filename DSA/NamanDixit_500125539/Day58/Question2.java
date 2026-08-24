import java.util.*;

// A class to represent one employee/node in the tree
class Node {

    int data;          // Employee ID
    Node left;         // Left employee/subordinate
    Node right;        // Right employee/subordinate

    // Constructor to create a new node
    Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

public class Question2 {

    // ---------------------------------------------------------
    // Function to build the binary tree from level-order input
    // ---------------------------------------------------------
    static Node buildTree(int[] values) {

        // If there is no value or first value is -1,
        // then there is no tree
        if (values.length == 0 || values[0] == -1) {
            return null;
        }

        // Create the root node
        Node root = new Node(values[0]);

        // Queue is used to build the tree level by level
        Queue<Node> queue = new LinkedList<>();

        // Put the root into the queue
        queue.add(root);

        // This variable points to the next value in the array
        int index = 1;

        // Continue until all values are processed
        while (index < values.length) {

            // Take the current parent from the queue
            Node current = queue.poll();

            // -------------------------------------------------
            // Create the LEFT child
            // -------------------------------------------------
            if (index < values.length && values[index] != -1) {

                // Create the left child
                current.left = new Node(values[index]);

                // Add the left child to the queue
                queue.add(current.left);
            }

            // Move to the next value
            index++;

            // -------------------------------------------------
            // Create the RIGHT child
            // -------------------------------------------------
            if (index < values.length && values[index] != -1) {

                // Create the right child
                current.right = new Node(values[index]);

                // Add the right child to the queue
                queue.add(current.right);
            }

            // Move to the next value
            index++;
        }

        // Return the completed tree
        return root;
    }

    // ---------------------------------------------------------
    // Function to check whether an employee exists in the tree
    // ---------------------------------------------------------
    static boolean exists(Node root, int employee) {

        // If we reach an empty node, employee does not exist here
        if (root == null) {
            return false;
        }

        // If current node contains the employee ID
        if (root.data == employee) {
            return true;
        }

        // Search in the left subtree
        boolean foundLeft = exists(root.left, employee);

        // If found on the left side, return true
        if (foundLeft) {
            return true;
        }

        // Otherwise search in the right subtree
        return exists(root.right, employee);
    }

    // ---------------------------------------------------------
    // Function to find the Lowest Common Ancestor
    // ---------------------------------------------------------
    static Node findLCA(Node root, int a, int b) {

        // If tree is empty, there is no LCA
        if (root == null) {
            return null;
        }

        // If current node is employee a or employee b,
        // this node can be the LCA
        if (root.data == a || root.data == b) {
            return root;
        }

        // Search for employee a/b in the left subtree
        Node leftResult = findLCA(root.left, a, b);

        // Search for employee a/b in the right subtree
        Node rightResult = findLCA(root.right, a, b);

        // If both sides returned a node,
        // current node is the common ancestor
        if (leftResult != null && rightResult != null) {
            return root;
        }

        // If only the left side found something,
        // return the left result
        if (leftResult != null) {
            return leftResult;
        }

        // Otherwise return the right result
        return rightResult;
    }

    // ---------------------------------------------------------
    // Main function
    // ---------------------------------------------------------
    public static void main(String[] args) {

        // Scanner is used to take input from the user
        Scanner sc = new Scanner(System.in);

        // Ask for number of elements in the level-order tree
        System.out.print("Enter number of tree elements: ");
        int n = sc.nextInt();

        // Create an array to store the tree values
        int[] values = new int[n];

        // Take all tree elements from the user
        System.out.println("Enter tree elements in level-order (-1 for missing nodes):");

        for (int i = 0; i < n; i++) {
            values[i] = sc.nextInt();
        }

        // Take the first employee ID
        System.out.print("Enter first employee ID: ");
        int a = sc.nextInt();

        // Take the second employee ID
        System.out.print("Enter second employee ID: ");
        int b = sc.nextInt();

        // Build the binary tree
        Node root = buildTree(values);

        // -----------------------------------------------------
        // First check whether both employees actually exist
        // -----------------------------------------------------

        boolean employeeAExists = exists(root, a);
        boolean employeeBExists = exists(root, b);

        // If either employee does not exist,
        // answer should be -1
        if (!employeeAExists || !employeeBExists) {

            System.out.println("Lowest Common Ancestor: -1");

        } else {

            // Both employees exist,
            // so now find their Lowest Common Ancestor
            Node answer = findLCA(root, a, b);

            // Print the ID of the LCA
            System.out.println("Lowest Common Ancestor: " + answer.data);
        }

        // Close Scanner
        sc.close();
    }
}