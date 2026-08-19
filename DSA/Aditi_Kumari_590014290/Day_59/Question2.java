package Day_59;

public class Question2 {
     static int ans = 0;
    static void dfs(int[] tree, int i, int[] count) {
        if (i >= tree.length || tree[i] == -1) {
            return;
        }
        count[tree[i]]++;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        boolean leaf = (left >= tree.length || tree[left] == -1) &&
                       (right >= tree.length || tree[right] == -1);

        if (leaf) {
            int odd = 0;
            for (int j = 0; j < 10; j++) {
                if (count[j] % 2 != 0) {
                    odd++;
                }
            }
            if (odd <= 1) {
                ans++;
            }
        } else {
            dfs(tree, left, count);
            dfs(tree, right, count);
        }
        count[tree[i]]--;
    }
}
