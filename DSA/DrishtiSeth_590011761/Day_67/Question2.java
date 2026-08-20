import java.util.*;

public class Main {

    static int minusOne = 0;
    static int zero = 0;
    static int plusOne = 0;

    static int buildTree(int left, int right, int[] arr) {

        // Empty subtree
        if (left > right) {
            return 0;
        }

        // Choose middle element
        // For even length, this gives left-middle
        int mid = (left + right) / 2;

        // Build left subtree
        int leftHeight = buildTree(left, mid - 1, arr);

        // Build right subtree
        int rightHeight = buildTree(mid + 1, right, arr);

        // Balance factor
        int balance = rightHeight - leftHeight;

        if (balance == -1) {
            minusOne++;
        }
        else if (balance == 0) {
            zero++;
        }
        else if (balance == 1) {
            plusOne++;
        }

        // Return height of current subtree
        return 1 + Math.max(leftHeight, rightHeight);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        buildTree(0, n - 1, arr);

        System.out.println(minusOne + " " + zero + " " + plusOne);

        sc.close();
    }
}
