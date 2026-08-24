class Solution {
    public int minGroups(int n, int[] mentor) {
        int maxDepth = 0;

        for (int i = 0; i < n; i++) {
            int depth = 1;
            int current = i;

            while (mentor[current] != -1) {
                current = mentor[current] - 1;
                depth++;
            }

            maxDepth = Math.max(maxDepth, depth);
        }

        return maxDepth;
    }
}