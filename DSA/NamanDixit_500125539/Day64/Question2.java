import java.util.Scanner;

public class Question2 {

    // Function to find the value of the Lowest Common Ancestor of rooms 'a' and 'b'
    // in a Binary Search Tree, represented in heap-array format (-1 = missing node)
    public static int lowestCommonAncestor(int[] tree, int a, int b) {

        // Start searching from the root (index 0)
        int index = 0;

        // Keep walking down the tree until we find the split point
        while (true) {

            int currentValue = tree[index];

            if (a < currentValue && b < currentValue) {
                // Both target values are SMALLER than the current node,
                // so the LCA must be further down the LEFT subtree.
                index = 2 * index + 1;

            } else if (a > currentValue && b > currentValue) {
                // Both target values are LARGER than the current node,
                // so the LCA must be further down the RIGHT subtree.
                index = 2 * index + 2;

            } else {
                // Otherwise, this is the point where the paths to 'a' and 'b'
                // split apart (or one of them IS this node) -- so THIS node
                // is the Lowest Common Ancestor.
                return currentValue;
            }
        }
    }

    // Main method: takes user input and prints the result
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Step 1: Read the number of elements in the tree array
        System.out.println("Enter the number of elements in the tree array:");
        int n = Integer.parseInt(scanner.nextLine().trim());

        // Step 2: Read the tree values (use -1 for missing nodes)
        System.out.println("Enter " + n + " values separated by spaces (use -1 for missing nodes):");
        String[] parts = scanner.nextLine().trim().split("\\s+");

        int[] tree = new int[n];
        for (int i = 0; i < n; i++) {
            tree[i] = Integer.parseInt(parts[i]);
        }

        // Step 3: Read the two room numbers (values) to find the LCA of
        System.out.println("Enter room a:");
        int a = Integer.parseInt(scanner.nextLine().trim());

        System.out.println("Enter room b:");
        int b = Integer.parseInt(scanner.nextLine().trim());

        // Step 4: Call the function and print the result
        int result = lowestCommonAncestor(tree, a, b);

        System.out.println("Lowest Common Ancestor: " + result);

        scanner.close();
    }
}