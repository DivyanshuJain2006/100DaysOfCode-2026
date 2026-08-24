import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static int[] tree;
    static long count;

    static boolean canFormPalindrome(int mask) {
        return (mask & (mask - 1)) == 0;
    }

    static void dfs(int index, int mask) {

        if (index >= n) {
            return;
        }

        if (tree[index] == -1) {
            return;
        }

        mask ^= (1 << tree[index]);

        int left = 2 * index + 1;
        int right = 2 * index + 2;

        boolean leftExists =
                left < n && tree[left] != -1;

        boolean rightExists =
                right < n && tree[right] != -1;

        if (!leftExists && !rightExists) {
            if (canFormPalindrome(mask)) {
                count++;
            }
            return;
        }

        if (leftExists) {
            dfs(left, mask);
        }

        if (rightExists) {
            dfs(right, mask);
        }
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine().trim());

        StringBuilder output = new StringBuilder();

        while (t-- > 0) {

            n = Integer.parseInt(br.readLine().trim());

            tree = new int[n];

            int filled = 0;

            while (filled < n) {
                StringTokenizer st =
                        new StringTokenizer(br.readLine());

                while (st.hasMoreTokens() && filled < n) {
                    tree[filled++] =
                            Integer.parseInt(st.nextToken());
                }
            }

            count = 0;

            dfs(0, 0);

            output.append(count).append('\n');
        }

        System.out.print(output);
    }
}