import java.util.Scanner;

public class Question2 {

    // Function to find the value in the BST closest to 'target',
    // breaking ties by choosing the SMALLER value.
    public static int closestValue(int[] tree, double target) {

        int index = 0;

        // Start with the root as our initial "best guess"
        int bestValue = tree[index];
        double bestDiff = Math.abs(bestValue - target);

        // Keep walking down the tree, following the BST ordering
        while (index < tree.length && tree[index] != -1) {

            int currentValue = tree[index];
            double currentDiff = Math.abs(currentValue - target);

            // Update our best answer if this node is CLOSER to target,
            // OR if it's equally close but has a SMALLER value (tie-break rule).
            if (currentDiff < bestDiff ||
               (currentDiff == bestDiff && currentValue < bestValue)) {
                bestValue = currentValue;
                bestDiff = currentDiff;
            }

            // Decide which direction to move, using the BST property
            if (target < currentValue) {
                // Target is smaller -- move left
                index = 2 * index + 1;
            } else if (target > currentValue) {
                // Target is larger -- move right
                index = 2 * index + 2;
            } else {
                // Exact match found! Can't get any closer than 0 difference.
                break;
            }
        }

        return bestValue;
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

        // Step 3: Read the target temperature
        System.out.println("Enter the target value:");
        double target = Double.parseDouble(scanner.nextLine().trim());

        // Step 4: Call the function and print the result
        int result = closestValue(tree, target);

        System.out.println("Closest preset temperature: " + result);

        scanner.close();
    }
}