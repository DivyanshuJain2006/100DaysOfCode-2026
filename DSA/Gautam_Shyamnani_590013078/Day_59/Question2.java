import java.io.*;
import java.util.*;

public class Question2 {

    static int[] tree;
    static int n;
    static long count;

    static void dfs(int index, int mask) {

        // Missing node
        if (index >= n || tree[index] == -1) {
            return;
        }

        // Toggle the current digit
        mask ^= (1 << tree[index]);

        int left = 2 * index + 1;
        int right = 2 * index + 2;

        // Check if current node is a leaf
        if ((left >= n || tree[left] == -1) &&
            (right >= n || tree[right] == -1)) {

            // At most one digit can have odd frequency
            if (mask == 0 || (mask & (mask - 1)) == 0) {
                count++;
            }

            return;
        }

        // Go to left child
        if (left < n && tree[left] != -1) {
            dfs(left, mask);
        }

        // Go to right child
        if (right < n && tree[right] != -1) {
            dfs(right, mask);
        }
    }

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {

            n = sc.nextInt();

            tree = new int[n];

            for (int i = 0; i < n; i++) {
                tree[i] = sc.nextInt();
            }

            count = 0;

            // Start DFS from root
            if (n > 0 && tree[0] != -1) {
                dfs(0, 0);
            }

            System.out.println(count);
        }

        sc.close();
    }
}