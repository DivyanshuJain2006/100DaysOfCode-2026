import java.util.*;

public class Main {

    static int count = 0;

    static void dfs(int[] tree, int index, int mask) {
        if (index >= tree.length || tree[index] == -1) {
            return;
        }

        mask ^= (1 << tree[index]);

        int left = 2 * index + 1;
        int right = 2 * index + 2;

        boolean isLeaf = (left >= tree.length || tree[left] == -1) &&
                         (right >= tree.length || tree[right] == -1);

        if (isLeaf) {
            if (Integer.bitCount(mask) <= 1) {
                count++;
            }
            return;
        }

        dfs(tree, left, mask);
        dfs(tree, right, mask);
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

            count = 0;
            dfs(tree, 0, 0);

            System.out.println(count);
        }

        sc.close();
    }
}
