import java.io.*;
import java.util.*;

public class Main {

    static long closestValue(int[] tree, double target) {

        int index = 0;

        while (index < tree.length && tree[index] == -1) {
            index++;
        }

        if (index == tree.length) {
            return -1;
        }

        long best = tree[index];
        double bestDiff = Math.abs(best - target);

        index = 0;

        while (index < tree.length && tree[index] != -1) {

            long current = tree[index];
            double currentDiff = Math.abs(current - target);

            if (currentDiff < bestDiff ||
                (currentDiff == bestDiff && current < best)) {

                best = current;
                bestDiff = currentDiff;
            }

            if (target < current) {
                index = 2 * index + 1;
            }

            else if (target > current) {
                index = 2 * index + 2;
            }

            else {
                return current;
            }
        }

        return best;
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine().trim());

        StringBuilder output = new StringBuilder();

        while (T-- > 0) {

            int n = Integer.parseInt(br.readLine().trim());

            int[] tree = new int[n];

            int count = 0;

            while (count < n) {

                StringTokenizer st =
                        new StringTokenizer(br.readLine());

                while (st.hasMoreTokens() && count < n) {
                    tree[count++] =
                            Integer.parseInt(st.nextToken());
                }
            }

            double target =
                    Double.parseDouble(br.readLine().trim());

            output.append(closestValue(tree, target))
                   .append('\n');
        }

        System.out.print(output);
    }
}