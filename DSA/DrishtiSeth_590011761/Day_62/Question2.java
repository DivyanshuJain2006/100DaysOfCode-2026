class Solution {

    public int rob(int[] tree) {
        int[] result = solve(tree, 0);

        return Math.max(result[0], result[1]);
    }

    // result[0] = maximum money if current house is robbed
    // result[1] = maximum money if current house is not robbed
    private int[] solve(int[] tree, int i) {

        // No node
        if (i >= tree.length || tree[i] == -1) {
            return new int[]{0, 0};
        }

        // Left child
        int[] left = solve(tree, 2 * i + 1);

        // Right child
        int[] right = solve(tree, 2 * i + 2);

        // Rob current house
        int robCurrent = tree[i] + left[1] + right[1];

        // Don't rob current house
        int skipCurrent =
                Math.max(left[0], left[1])
                + Math.max(right[0], right[1]);

        return new int[]{robCurrent, skipCurrent};
    }
}
