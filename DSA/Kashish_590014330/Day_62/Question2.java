class Solution {

    public int rob(int[] tree, int n) {
        return solve(tree, 0);
    }

    private int solve(int[] tree, int i) {

        if (i >= tree.length || tree[i] == -1) {
            return 0;
        }
        int robCurrent = tree[i]
                + solve(tree, 2 * i + 1 + 1)
                + solve(tree, 2 * i + 2 + 1);

        int skipCurrent = solve(tree, 2 * i + 1)
                + solve(tree, 2 * i + 2);

        return Math.max(robCurrent, skipCurrent);
    }
}