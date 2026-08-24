import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static int[] tree;
    static long count;

    public static void dfs(int index, int mask) {
        if (index >= n || tree[index] == -1) {
            return;
        }

        // Toggle the bit corresponding to the current digit
        mask ^= (1 << tree[index]);

        int left = 2 * index + 1;
        int right = 2 * index + 2;

        // Check if current node is a leaf
        boolean isLeaf = (left >= n || tree[left] == -1) &&
                         (right >= n || tree[right] == -1);

        if (isLeaf) {
            // Valid if at most one digit has odd frequency
            if ((mask & (mask - 1)) == 0) {
                count++;
            }
            return;
        }

        if (left < n && tree[left] != -1) {
            dfs(left, mask);
        }

        if (right < n && tree[right] != -1) {
            dfs(right, mask);
        }
    }

    public static long countValidPaths(int[] arr) {
        tree = arr;
        n = arr.length;
        count = 0;

        if (n > 0 && tree[0] != -1) {
            dfs(0, 0);
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[] tree = new int[n];

            for (int i = 0; i < n; i++) {
                tree[i] = sc.nextInt();
            }

            System.out.println(countValidPaths(tree));
        }

        sc.close();
    }
}
