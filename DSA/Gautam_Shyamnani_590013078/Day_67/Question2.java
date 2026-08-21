import java.util.*;

public class Question2 {

    static int minusOne = 0;
    static int zero = 0;
    static int plusOne = 0;

    static int getHeight(int left, int right) {

        if (left > right) {
            return 0;
        }

        int mid = (left + right) / 2;

        int leftHeight = getHeight(left, mid - 1);
        int rightHeight = getHeight(mid + 1, right);

        int balance = rightHeight - leftHeight;

        if (balance == -1) {
            minusOne++;
        } else if (balance == 0) {
            zero++;
        } else {
            plusOne++;
        }

        return 1 + Math.max(leftHeight, rightHeight);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            sc.nextInt();
        }

        getHeight(0, n - 1);

        System.out.println(minusOne + " " + zero + " " + plusOne);

        sc.close();
    }
}