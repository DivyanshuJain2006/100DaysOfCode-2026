import java.util.*;

public class Main {

    public static int closestValue(int[] tree, double target) {

        int index = 0;
        int closest = tree[0];

        while (index < tree.length && tree[index] != -1) {

            int current = tree[index];

            double currentDiff = Math.abs(current - target);
            double closestDiff = Math.abs(closest - target);

    
            if (currentDiff < closestDiff ||
                (currentDiff == closestDiff && current < closest)) {
                closest = current;
            }
            if (current == target) {
                return current;
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

            System.out.println(closestValue(tree, target));
        }

        sc.close();
    }
}