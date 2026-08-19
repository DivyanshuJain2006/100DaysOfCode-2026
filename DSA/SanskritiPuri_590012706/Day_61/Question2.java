class Solution {
    public int minimumGroups(int n, int[] mentor) {
        int maxDepth = 0;

        for (int i = 0; i < n; i++) {
            int current = i;
            int depth = 1;

            while (mentor[current] != -1) {
                current = mentor[current] - 1;
                depth++;
            }

            maxDepth = Math.max(maxDepth, depth);
        }

        return maxDepth;
    }
}
