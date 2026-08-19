import java.util.*;

public class Question2 {

    static int[] tree;
    static int n;

    static int countSafe(int index, int maxAltitude) {

        if (index >= n || tree[index] == -1) {
            return 0;
        }

        int current = tree[index];

        int count = (current >= maxAltitude) ? 1 : 0;

        maxAltitude = Math.max(maxAltitude, current);

        int left = 2 * index + 1;
        int right = 2 * index + 2;

        count += countSafe(left, maxAltitude);
        count += countSafe(right, maxAltitude);

        return count;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        tree = new int[n];

        for (int i = 0; i < n; i++) {
            tree[i] = sc.nextInt();
        }

        int answer = countSafe(0, Integer.MIN_VALUE);

        System.out.println(answer);

        sc.close();
    }
}