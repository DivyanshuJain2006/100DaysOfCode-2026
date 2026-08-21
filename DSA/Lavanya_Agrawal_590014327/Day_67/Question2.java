import java.util.*;

public class Question2 {

    static int minusOne = 0;
    static int zero = 0;
    static int plusOne = 0;

    // Returns the height of the subtree
    static int buildAndCount(int[] arr, int left, int right) {

        if (left > right) {
            return 0;
        }

        // Left-middle for even-sized segments
        int mid = (left + right) / 2;

        int leftHeight = buildAndCount(arr, left, mid - 1);
        int rightHeight = buildAndCount(arr, mid + 1, right);

        int balance = rightHeight - leftHeight;

        if (balance == -1) {
            minusOne++;
        } else if (balance == 0) {
            zero++;
        } else {
            plusOne++;
        }

        return Math.max(leftHeight, rightHeight) + 1;
    }

    static void balanceSpectrum(int[] arr) {

        minusOne = 0;
        zero = 0;
        plusOne = 0;

        buildAndCount(arr, 0, arr.length - 1);

        System.out.println(minusOne + " " + zero + " " + plusOne);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        balanceSpectrum(arr);

        sc.close();
    }
}