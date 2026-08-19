class Solution {
    public int minGroups(int n, int[] mentor) {
        int ans = 0;

        for (int i = 0; i < n; i++) {
            int x = i + 1;
            int count = 1;

            while (mentor[x - 1] != -1) {
                x = mentor[x - 1];
                count++;
            }

            ans = Math.max(ans, count);
        }

        return ans;
    }
}