package Day_60;
import java.util.*;

public class Question2 {
    static int count = 0;
    static void dfs(int[] tree, int i, int max) {
        if (i >= tree.length || tree[i] == -1) {
            return;
        }
        if (tree[i] >= max) {
            count++;
        }
        max = Math.max(max, tree[i]);
        dfs(tree, 2 * i + 1, max);
        dfs(tree, 2 * i + 2, max);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] tree = new int[n];
        for (int i = 0; i < n; i++) {
            tree[i] = sc.nextInt();
        }
        count = 0;
        dfs(tree, 0, Integer.MIN_VALUE);
        System.out.println(count);
        sc.close();
    }
}