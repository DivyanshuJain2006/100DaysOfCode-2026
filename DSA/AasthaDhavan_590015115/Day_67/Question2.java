import java.util.*;
class Question2 {

    static int[] countBalanceFactors(int[] arr) {
        int[] count = new int[3];
        build(arr, 0, arr.length - 1, count);
        return count;
    }

    static int build(int[] arr, int l, int r, int[] count) {
        if (l > r) return 0;

        int mid = (l + r) / 2;

        int leftHeight = build(arr, l, mid - 1, count);
        int rightHeight = build(arr, mid + 1, r, count);

        int balance = leftHeight - rightHeight;

        if (balance == -1)
            count[0]++;
        else if (balance == 0)
            count[1]++;
        else if (balance == 1)
            count[2]++;

        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};

        int[] result = countBalanceFactors(arr);

        System.out.println("[" + result[0] + ", " + result[1] + ", " + result[2] + "]");
    }
}