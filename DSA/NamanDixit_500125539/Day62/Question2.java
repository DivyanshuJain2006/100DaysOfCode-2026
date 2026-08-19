
import java.util.Scanner;

public class Question2 {

    // Function to find the maximum money that can be robbed from the tree of houses
    public static int rob(int[] tree) {

        // Kick off the recursive search from the root (index 0)
        int[] result = robHelper(tree, 0);

        // result[0] = best total if we DON'T rob the root
        // result[1] = best total if we DO rob the root
        // The final answer is whichever choice gives more money overall
        return Math.max(result[0], result[1]);
    }

    // Recursive helper function.
    // Returns an array of size 2:
    //   [0] = maximum money obtainable from this subtree, if this node is NOT robbed
    //   [1] = maximum money obtainable from this subtree, if this node IS robbed
    private static int[] robHelper(int[] tree, int index) {

        // Base case: index out of bounds, or -1 (missing node) -- no money here
        if (index >= tree.length || tree[index] == -1) {
            return new int[]{0, 0};
        }

        int leftIndex = 2 * index + 1;
        int rightIndex = 2 * index + 2;

        // Recursively get the best options for both children
        int[] leftResult = robHelper(tree, leftIndex);
        int[] rightResult = robHelper(tree, rightIndex);

        // OPTION A: Rob THIS house.
        // Then we CANNOT rob its direct children -- so we must use their
        // "not robbed" values (index 0) instead.
        int robThis = tree[index] + leftResult[0] + rightResult[0];

        // OPTION B: Don't rob THIS house.
        // Then each child is free to be robbed or not, whichever gives more --
        // so we take the max of each child's two options.
        int notRobThis = Math.max(leftResult[0], leftResult[1])
                + Math.max(rightResult[0], rightResult[1]);

        return new int[]{notRobThis, robThis};
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

        // Step 3: Call the function and print the result
        int result = rob(tree);

        System.out.println("Maximum amount that can be robbed: " + result);

        scanner.close();
    }
}
