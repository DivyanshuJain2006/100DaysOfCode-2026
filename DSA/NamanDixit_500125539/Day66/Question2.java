import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Question2 {

    // Function to merge two BSTs into a single sorted array of UNIQUE values
    public static int[] mergeEmployeeIds(int[] tree1, int[] tree2) {

        // Step 1: Get sorted lists from each tree using in-order traversal
        List<Integer> list1 = new ArrayList<>();
        inorderTraversal(tree1, 0, list1);

        List<Integer> list2 = new ArrayList<>();
        inorderTraversal(tree2, 0, list2);

        // Step 2: Merge the two sorted lists together, removing duplicates
        List<Integer> merged = new ArrayList<>();

        int i = 0; // pointer into list1
        int j = 0; // pointer into list2

        while (i < list1.size() && j < list2.size()) {

            int val1 = list1.get(i);
            int val2 = list2.get(j);

            if (val1 < val2) {
                addIfNotDuplicate(merged, val1);
                i++;
            } else if (val2 < val1) {
                addIfNotDuplicate(merged, val2);
                j++;
            } else {
                // val1 == val2 -- they're the same value, only add it ONCE
                addIfNotDuplicate(merged, val1);
                i++;
                j++;
            }
        }

        // Step 3: Copy over any remaining elements from list1 (if list2 ran out first)
        while (i < list1.size()) {
            addIfNotDuplicate(merged, list1.get(i));
            i++;
        }

        // Step 4: Copy over any remaining elements from list2 (if list1 ran out first)
        while (j < list2.size()) {
            addIfNotDuplicate(merged, list2.get(j));
            j++;
        }

        // Step 5: Convert the final List<Integer> into a plain int[] to return
        int[] result = new int[merged.size()];
        for (int k = 0; k < merged.size(); k++) {
            result[k] = merged.get(k);
        }

        return result;
    }

    // Helper: adds a value to the list ONLY IF it's different from the last
    // value already added (this avoids adding duplicates, since our merged
    // list is built in sorted order, so duplicates would always be adjacent).
    private static void