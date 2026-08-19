import java.util.*;

public class Main {

    static int[] tree;
    static int n;
    static int count;

    static void dfs(int index, int mask) {
        if (index >= n || tree[index] == -1) {
            return;
        }
        mask ^= (1 << tree[index]);

        int left = 2 * index + 1;
        int right = 2 * index + 2;
        boolean isLeaf = (left >= n || tree[left] == -1) &&
                         (right >= n || tree[right] == -1);

        if (isLeaf) {
            
            if (mask == 0 || (mask & (mask - 1)) == 0) {
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

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            n = sc.nextInt();

            tree = new int[n];

            for (int i = 0; i < n; i++) {
                tree[i] = sc.nextInt();
            }

            count = 0;

            if (n > 0 && tree[0] != -1) {
                dfs(0, 0);
            }

            System.out.println(count);
        }

        sc.close();
    }
}