import java.util.*;

public class Main {

    static int count = 0;
    static int[] tree;

    // DFS on heap-array representation
    static void dfs(int index, int mask) {

        // Out of bounds or missing node
        if (index >= tree.length || tree[index] == -1) {
            return;
        }

        // Toggle the bit corresponding to this digit
        mask ^= (1 << tree[index]);

        // Heap-array children
        int left = 2 * index + 1;
        int right = 2 * index + 2;

        // Check if current node is a leaf
        boolean isLeaf =
                (left >= tree.length || tree[left] == -1) &&
                (right >= tree.length || tree[right] == -1);

        if (isLeaf) {

            // At most one bit should be set
            // This means at most one digit has odd frequency
            if ((mask & (mask - 1)) == 0) {
                count++;
            }

            return;
        }

        // Traverse left and right
        dfs(left, mask);
        dfs(right, mask);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        tree = new int[n];

        for (int i = 0; i < n; i++) {
            tree[i] = sc.nextInt();
        }

        count = 0;

        dfs(0, 0);

        System.out.println(count);
    }
}
