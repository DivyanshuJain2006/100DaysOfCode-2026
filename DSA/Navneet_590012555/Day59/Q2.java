class Solution {
    public int countPaths(int[] tree) {
        return dfs(tree, 0, 0);
    }

    int dfs(int[] a, int i, int mask) {
        if (i >= a.length || a[i] == -1)
            return 0;

        mask ^= (1 << a[i]);

        int l = 2 * i + 1;
        int r = 2 * i + 2;

        if ((l >= a.length || a[l] == -1) &&
                (r >= a.length || a[r] == -1)) {

            return (mask & (mask - 1)) == 0 ? 1 : 0;
        }

        return dfs(a, l, mask) + dfs(a, r, mask);
    }
}