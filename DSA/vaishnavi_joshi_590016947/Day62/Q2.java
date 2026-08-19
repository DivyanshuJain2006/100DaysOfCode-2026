import java.util.*;

class Solution {

    public int maxRob(int n, int[] tree) {
        int[] result = solve(0, tree);
        return Math.max(result[0], result[1]);
    }

    // result[0] = maximum money if current node is NOT robbed
    // result[1] = maximum money if current node IS robbed
    private int[] solve(int index, int[] tree) {

        // Node does not exist
        if (index >= tree.length || tree[index] == -1) {
            return new int[]{0, 0};
        }

        // Solve left subtree
        int[] left = solve(2 * index + 1, tree);

        // Solve right subtree
        int[] right = solve(2 * index + 2, tree);

        // If current house is robbed,
        // children cannot be robbed
        int rob = tree[index] + left[0] + right[0];

        // If current house is NOT robbed,
        // children can either be robbed or not robbed
        int notRob = Math.max(left[0], left[1])
                   + Math.max(right[0], right[1]);

        return new int[]{notRob, rob};
    }
}