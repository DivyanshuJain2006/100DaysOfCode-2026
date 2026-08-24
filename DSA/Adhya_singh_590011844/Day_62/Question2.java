import java.io.*;
import java.util.*;

public class Main {

    static int[] tree;
    static int n;

    static long[] dfs(int index) {

        if (index >= n || tree[index] == -1) {
            return new long[]{0, 0};
        }

        long[] left = dfs(2 * index + 1);
        long[] right = dfs(2 * index + 2);

        long skip = Math.max(left[0], left[1])
                  + Math.max(right[0], right[1]);

        long rob = tree[index]
                 + left[0]
                 + right[0];

        return new long[]{skip, rob};
    }

    static long maxRobbery(int[] arr) {
        tree = arr;
        n = arr.length;

        if (n == 0 || tree[0] == -1) {
            return 0;
        }

        long[] result = dfs(0);

        return Math.max(result[0], result[1]);
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine().trim());

        int[] tree = new int[n];

        int index = 0;

        while (index < n) {
            StringTokenizer st =
                    new StringTokenizer(br.readLine());

            while (st.hasMoreTokens() && index < n) {
                tree[index++] =
                        Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(maxRobbery(tree));
    }
}
