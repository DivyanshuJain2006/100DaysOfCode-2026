
import java.util.Scanner;

public class Question2 {

    // Function to count root-to-leaf paths whose digits can be rearranged into a palindrome
    public static int countPalindromePaths(int[] tree) {
        // Start the recursive search at the root (index 0), with an empty bitmask (0)
        return dfs(tree, 0, 0);
    }

    // Recursive helper function.
    // index -> current node's position in the heap-array
    // mask  -> a 10-bit number where bit 'd' is 1 if digit 'd' has appeared
    //          an ODD number of times so far along this path from the root
    private static int dfs(int[] tree, int index, int mask) {

        // Base case: if this index is out of bounds, or marked -1 (missing node),
        // there's no node here, so this path contributes nothing.
        if (index >= tree.length || tree[index] == -1) {
            return 0;
        }

        int digit = tree[index];

        // Flip the bit corresponding to this digit.
        // XOR-ing with (1 << digit) toggles that bit:
        // if it was 0 (even count so far) it becomes 1 (now odd),
        // if it was 1 (odd count so far) it becomes 0 (now even).
        int newMask = mask ^ (1 << digit);

        // Calculate the indices of this node's children
        int leftIndex = 2 * index + 1;
        int rightIndex = 2 * index + 2;

        // Check whether each child actually exists (within bounds AND not -1)
        boolean hasLeft = leftIndex < tree.length && tree[leftIndex] != -1;
        boolean hasRight = rightIndex < tree.length && tree[rightIndex] != -1;

        // If this node has NO children, it's a LEAF -- check the path here.
        if (!hasLeft && !hasRight) {
            // Count how many bits are set to 1 in the mask.
            // Each set bit represents a digit with an ODD count along this path.
            int oddDigitCount = Integer.bitCount(newMask);

            // A palindrome rearrangement is possible only if AT MOST ONE
            // digit has an odd count (the rest must pair up evenly).
            return (oddDigitCount <= 1) ? 1 : 0;
        }

        // Otherwise, keep exploring downward, adding up results from both children.
        int total = 0;
        if (hasLeft) {
            total += dfs(tree, leftIndex, newMask);
        }
        if (hasRight) {
            total += dfs(tree, rightIndex, newMask);
        }

        return total;
    }

    // Main method: takes user input and prints the result
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Step 1: Read the size of the tree array
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
        int result = countPalindromePaths(tree);

        System.out.println("Number of palindrome-forming paths: " + result);

        scanner.close();
    }
}
