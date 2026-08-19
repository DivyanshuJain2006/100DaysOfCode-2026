import java.io.*;
import java.util.*;

public class Main {

    static int[] tree;
    static int n;
    static int safeCount;

    static void dfs(int index, int maxAltitude) {
        if (index >= n || tree[index] == -1) {
            return;
        }

        int current = tree[index];

        if (current >= maxAltitude) {
            safeCount++;
        }

        int newMax = Math.max(maxAltitude, current);

        dfs(2 * index + 1, newMax);

        dfs(2 * index + 2, newMax);
    }

    static int countSafeCampsites(int[] arr) {
        tree = arr;
        n = arr.length;
        safeCount = 0;

        dfs(0, Integer.MIN_VALUE);

        return safeCount;
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine().trim());

        StringBuilder output = new StringBuilder();

        while (t-- > 0) {

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

            output.append(countSafeCampsites(tree))
                   .append('\n');
        }

        System.out.print(output);
    }
}