class Solution {
    public int minGroups(int n, int[] mentor) {
        int[] depth = new int[n];
        int maxDepth = 0;

        for (int i = 0; i < n; i++) {
            if (mentor[i] == -1) {
                depth[i] = 1;
            } else {
                depth[i] = depth[mentor[i] - 1] + 1;
            }

            maxDepth = Math.max(maxDepth, depth[i]);
        }

        return maxDepth;
    }
}
