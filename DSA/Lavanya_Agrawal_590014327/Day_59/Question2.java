import java.util.*;

public class Question2 {

    static int[] tree;
    static int n;
    static int count;

    static void dfs(int i, int mask) {
        if (i >= n || tree[i] == -1) return;

        // Toggle the bit for current digit
        mask ^= (1 << tree[i]);

        int left = 2 * i + 1;
        int right = 2 * i + 2;

        // Leaf node
        if ((left >= n || tree[left] == -1) &&
            (right >= n || tree[right] == -1)) {

            // At most one digit has odd frequency
            if ((mask & (mask - 1)) == 0)
                count++;

            return;
        }

        dfs(left, mask);
        dfs(right, mask);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            n = sc.nextInt();
            tree = new int[n];

            for (int i = 0; i < n; i++)
                tree[i] = sc.nextInt();

            count = 0;

            if (n > 0 && tree[0] != -1)
                dfs(0, 0);

            System.out.println(count);
        }

        sc.close();
    }
}