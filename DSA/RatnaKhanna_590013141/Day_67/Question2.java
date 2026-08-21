import java.util.*;

public class Main {

    static int[] countBalance(int[] arr) {
        int[] count = new int[3];

        build(arr, 0, arr.length - 1, count);

        return count;
    }

    static int build(int[] arr, int left, int right, int[] count) {

        // Empty subtree
        if (left > right) {
            return 0;
        }

        // Choose left-middle element
        int mid = (left + right) / 2;

        // Build left and right subtrees
        int leftHeight = build(arr, left, mid - 1, count);
        int rightHeight = build(arr, mid + 1, right, count);

        // Calculate balance factor
        int balance = leftHeight - rightHeight;

        // Store:
        // index 0 -> -1
        // index 1 ->  0
        // index 2 -> +1
        count[balance + 1]++;

        // Return height of current subtree
        return 1 + Math.max(leftHeight, rightHeight);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Input size
        int n = sc.nextInt();

        int[] arr = new int[n];

        // Input array
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int[] result = countBalance(arr);

        System.out.println(Arrays.toString(result));

        sc.close();
    }
}
