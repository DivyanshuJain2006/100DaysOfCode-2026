import java.util.*;

public class Q2 {

    public static int closestValue(int[] tree, int n, double target) {
        int index = 0;
        int closest = tree[index];

        while (index < n && tree[index] != -1) {

            int current = tree[index];

            double currentDiff = Math.abs(current - target);
            double closestDiff = Math.abs(closest - target);

            if (currentDiff < closestDiff ||
                (currentDiff == closestDiff && current < closest)) {

                closest = current;
            }

            if (target < current) {
                index = 2 * index + 1;
            } else {
                index = 2 * index + 2;
            }
        }

        return closest;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        while (T-- > 0) {

            int n = sc.nextInt();

            int[] tree = new int[n];

            for (int i = 0; i < n; i++) {
                tree[i] = sc.nextInt();
            }

            double target = sc.nextDouble();

            System.out.println(closestValue(tree, n, target));
        }

        sc.close();
    }
}