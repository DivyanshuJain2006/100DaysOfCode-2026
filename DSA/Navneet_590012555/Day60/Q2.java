class Solution {
    public int countSafe(int[] tree) {
        return dfs(tree, 0, Integer.MIN_VALUE);
    }

    int dfs(int[] a, int i, int max) {
        if (i >= a.length || a[i] == -1)
            return 0;

        int count = 0;

        if (a[i] >= max)
            count = 1;

        max = Math.max(max, a[i]);

        count += dfs(a, 2 * i + 1, max);
        count += dfs(a, 2 * i + 2, max);

        return count;
    }
}