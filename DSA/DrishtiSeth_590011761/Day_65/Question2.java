import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        while (T-- > 0) {

            int n = sc.nextInt();

            long[] tree = new long[n + 1];

            // Read tree
            for (int i = 1; i <= n; i++) {
                tree[i] = sc.nextLong();
            }

            double target = sc.nextDouble();

            long answer = -1;
            double minDistance = Double.MAX_VALUE;

            for (int i = 1; i <= n; i++) {

                // -1 represents null node
                if (tree[i] == -1) {
                    continue;
                }

                double distance =
                        Math.abs(tree[i] - target);

                // If this value is closer
                if (distance < minDistance) {

                    minDistance = distance;
                    answer = tree[i];

                }

                // If same distance, choose smaller value
                else if (distance == minDistance
                        && tree[i] < answer) {

                    answer = tree[i];
                }
            }

            System.out.println(answer);
        }

        sc.close();
    }
}
