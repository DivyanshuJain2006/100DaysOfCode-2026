class Solution {

    public int minGroups(int n, int[] mentor) {

        int maxDepth = 0;

        for (int student = 1; student <= n; student++) {

            int current = student;
            int depth = 0;

            while (current != -1) {
                depth++;

                // mentor array is 0-indexed
                current = mentor[current - 1];
            }

            maxDepth = Math.max(maxDepth, depth);
        }

        return maxDepth;
    }
}