import java.util.*;

public class Question2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        while (T-- > 0) {

            int n = sc.nextInt();

            long[] tree = new long[n + 1];

            for (int i = 1; i <= n; i++) {
                tree[i] = sc.nextLong();
            }

            double target = sc.nextDouble();

            int i = 1;
            long answer = tree[1];

            while (i <= n && tree[i] != -1) {

                long value = tree[i];

                double current = Math.abs(value - target);
                double best = Math.abs(answer - target);

                if (current < best || (current == best && value < answer)) {
                    answer = value;
                }

                if (value == target)
                    break;

                if (target < value)
                    i = 2 * i;
                else
                    i = 2 * i + 1;
            }

            System.out.println(answer);
        }

        sc.close();
    }
}