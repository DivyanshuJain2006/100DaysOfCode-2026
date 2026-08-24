import java.util.Scanner;
import java.util.Arrays;

public class Question2 {

    // Function to find the minimum number of groups needed so that no
    // student shares a group with ANY of their mentors (direct or indirect).
    public static int minGroups(int n, int[] mentor) {

        // Step 1: Create a memoization array to store each student's DEPTH
        // (how many steps up the mentor chain until reaching a root student).
        // We use 1-indexed students (1 to n), so the array has size (n+1),
        // and index 0 is unused. We initialize with -1 to mean "not computed yet".
        int[] depth = new int[n + 1];
        Arrays.fill(depth, -1);

        int maxDepth = 0;

        // Step 2: Compute the depth of every student, and track the maximum.
        for (int student = 1; student <= n; student++) {
            int studentDepth = getDepth(student, mentor, depth);
            maxDepth = Math.max(maxDepth, studentDepth);
        }

        // Step 3: The number of groups needed equals the longest chain length + 1
        // (a chain of depth 0 to maxDepth needs maxDepth+1 distinct groups).
        return maxDepth + 1;
    }

    // Recursive helper (with memoization) to compute the depth of a given student.
    // Depth 0 means the student has no mentor (a root of their hierarchy).
    private static int getDepth(int student, int[] mentor, int[] depth) {

        // If we've already computed this student's depth, just return it
        // (this avoids recalculating the same chain over and over).
        if (depth[student] != -1) {
            return depth[student];
        }

        // mentor[] is 0-indexed, so student "student" corresponds to
        // mentor[student - 1] in the array.
        int mentorId = mentor[student - 1];

        if (mentorId == -1) {
            // No mentor -- this student is at the top of their chain (depth 0)
            depth[student] = 0;
        } else {
            // This student's depth is 1 more than their mentor's depth
            depth[student] = getDepth(mentorId, mentor, depth) + 1;
        }

        return depth[student];
    }

    // Main method: takes user input and prints the result
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Step 1: Read n (number of students)
        System.out.println("Enter n (number of students):");
        int n = Integer.parseInt(scanner.nextLine().trim());

        // Step 2: Read the mentor array
        System.out.println("Enter " + n + " mentor values separated by spaces (use -1 for no mentor):");
        String[] parts = scanner.nextLine().trim().split("\\s+");

        int[] mentor = new int[n];
        for (int i = 0; i < n; i++) {
            mentor[i] = Integer.parseInt(parts[i]);
        }

        // Step 3: Call the function and print the result
        int result = minGroups(n, mentor);

        System.out.println("Minimum number of groups needed: " + result);

        scanner.close();
    }
}