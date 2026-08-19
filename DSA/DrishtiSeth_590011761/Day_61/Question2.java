class Solution {
    public int minimumGroups(int n, int[] mentor) {
        int[] depth = new int[n];

        int maxDepth = 0;

        for (int i = 0; i < n; i++) {
            maxDepth = Math.max(maxDepth, getDepth(i, mentor, depth));
        }

        return maxDepth;
    }

    private int getDepth(int student, int[] mentor, int[] depth) {
        if (depth[student] != 0) {
            return depth[student];
        }

        // No mentor
        if (mentor[student] == -1) {
            return depth[student] = 1;
        }

        // mentor[i] is 1-based, so convert to 0-based
        return depth[student] =
                1 + getDepth(mentor[student] - 1, mentor, depth);
    }
}
