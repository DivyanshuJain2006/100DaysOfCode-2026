import java.util.*;
public class Question2 {
    static int[] min, max, size;
    static int ans;
    public static boolean dfs(int i, int[] tree) {
        int n = tree.length;
        if (i >= n || tree[i] == -1)
            return true;

        int left = 2 * i + 1;
        int right = 2 * i + 2;

        boolean leftValid = dfs(left, tree);
        boolean rightValid = dfs(right, tree);

        if (!leftValid || !rightValid)
            return false;

        int val = tree[i];
        if (left < n && tree[left] != -1 && max[left] >= val)
            return false;
        if (right < n && tree[right] != -1 && min[right] <= val)
            return false;

        size[i] = 1;
        min[i] = max[i] = val;

        if (left < n && tree[left] != -1) {
            size[i] += size[left];
            min[i] = Math.min(min[i], min[left]);
        }

        if (right < n && tree[right] != -1) {
            size[i] += size[right];
            max[i] = Math.max(max[i], max[right]);
        }
        ans = Math.max(ans, size[i]);
        return true;
    }
    public static int largestBST(int[] tree) {
        int n = tree.length;
        if (tree[0] == -1) return 0;
        min = new int[n];
        max = new int[n];
        size = new int[n];
        ans = 0;
        dfs(0, tree);
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of test cases: ");
        int t = sc.nextInt();
        for (int tc = 1; tc <= t; tc++) {
            System.out.println("\nTest Case " + tc);

            System.out.print("Enter number of nodes: ");
            int n = sc.nextInt();

            int[] tree = new int[n];

            System.out.println("Enter " + n + " values (-1 for null):");

            for (int i = 0; i < n; i++) {
                tree[i] = sc.nextInt();
            }
            System.out.println("Tree: " + Arrays.toString(tree));
            System.out.println( "Size of the largest valid BST subtree: " + largestBST(tree));
        }
        sc.close();
    }
}