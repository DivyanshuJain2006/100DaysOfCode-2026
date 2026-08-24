class Solution {
    public int minimumGroups(int n, int[] mentor) {

        int[] depth = new int[n + 1];
        int maxDepth = 0;

        for (int i = 1; i <= n; i++) {
            int current = i;
            int d = 0;

            while (mentor[current - 1] != -1) {
                d++;
                current = mentor[current - 1];
            }

            depth[i] = d;
            maxDepth = Math.max(maxDepth, d);
        }

        return maxDepth + 1;
    }
}
