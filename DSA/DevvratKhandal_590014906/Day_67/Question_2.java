import java.util.*;

public class Question_2 {

    static int minusOne = 0;
    static int zero = 0;
    static int plusOne = 0;

    static int build(int[] arr, int left, int right) {

        if (left > right) {
            return 0;
        }

        // Choose left-middle element
        int mid = (left + right) / 2;

        int leftHeight = build(arr, left, mid - 1);
        int rightHeight = build(arr, mid + 1, right);

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

        return 1 + Math.max(leftHeight, rightHeight);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Enter sorted array elements:");

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        build(arr, 0, n - 1);

        System.out.println(
            "Balance factor -1: " + minusOne
        );

        System.out.println(
            "Balance factor 0: " + zero
        );

        System.out.println(
            "Balance factor +1: " + plusOne
        );

        System.out.println(
            "Final Output: " + minusOne + " " + zero + " " + plusOne
        );
    }
}