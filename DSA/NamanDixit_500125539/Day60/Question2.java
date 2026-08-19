import java.util.Scanner;

public class Question2 {

    // Function to count "safe" campsites (nodes whose value is >= every
    // value on the path from the root to that node, including itself).
    public static int countSafeCampsites(int[] tree) {
        // Start the recursive search at the root (index 0).
        // We use Integer.MIN_VALUE as the initial "max so far" so that
        // the root itself is always considered safe (nothing is bigger than it yet).
        return dfs(tree, 0, Integer.MIN_VALUE);
    }

    // Recursive helper function.
    // index      -> current node's position in the heap-array
    // maxSoFar   -> the largest value seen on the path from the root
    //               down to (but NOT including) this node
    private static int dfs(int[] tree, int index, int maxSoFar) {

        // Base case: index out of bounds, or this position is -1 (missing node)
        if (index >= tree.length || tree[index] == -1) {
            return 0;
        }

        int value = tree[index];
        int count = 0;

        // Step 1: Check if THIS node is safe.
        // It's safe if its value is greater than or equal to the biggest
        // value we've seen so far on the path leading to it.
        if (value >= maxSoFar) {
            count = 1;
        }

        // Step 2: Update the "max so far" to include this node's value,
        // since it will now be part of the path for its children too.
        int newMax = Math.max(maxSoFar, value);

        // Step 3: Recurse into both children, passing along the updated max.
        int leftIndex = 2 * index + 1;
        int rightIndex = 2 * index + 2;

        count += dfs(tree, leftIndex, newMax);
        count += dfs(tree, rightIndex, newMax);

        return count;
    }

    // Main method: takes user input and prints the result
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Step 1: Read n (number of elements in the tree array)
        System.out.println("Enter n (number of elements in the tree array):");
        int n = Integer.parseInt(scanner.nextLine().trim());

        // Step 2: Read the tree values (use -1 for missing nodes)
        System.out.println("Enter " + n + " values separated by spaces (use -1 for missing nodes):");
        String[] parts = scanner.nextLine().trim().split("\\s+");

        int[] tree = new int[n];
        for (int i = 0; i < n; i++) {
            tree[i] = Integer.parseInt(parts[i]);
        }

        // Step 3: Call the function and print the result
        int result = countSafeCampsites(tree);

        System.out.println("Number of safe campsites: " + result);

        scanner.close();
    }
}