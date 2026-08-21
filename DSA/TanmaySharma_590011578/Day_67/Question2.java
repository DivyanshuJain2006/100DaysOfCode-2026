
import java.util.*;

public class Question2 {
    static int[] countBalance(int[] arr) {
        int[] count = new int[3];
        build(arr, 0, arr.length - 1, count);
        return count;
    }

    static int build(int[] arr, int left, int right, int[] count) {
        if (left > right) {
            return 0;
        }

        int mid = (left + right) / 2;

        int leftHeight = build(arr, left, mid - 1, count);
        int rightHeight = build(arr, mid + 1, right, count);

        int balance = rightHeight - leftHeight;

        if (balance == -1) {
            count[0]++;
        } else if (balance == 0) {
            count[1]++;
        } else if (balance == 1) {
            count[2]++;
        }

        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int[] result = countBalance(arr);

        System.out.println(Arrays.toString(result));
        sc.close();
    }
}