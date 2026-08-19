class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] score = new int[n + 1]; // 1-indexed; score[i] = (in-degree - out-degree)
        
        for (int[] pair : trust) {
            int a = pair[0], b = pair[1];
            score[a]--; // a trusts someone -> disqualifies a
            score[b]++; // b is trusted by someone
        }
        
        for (int i = 1; i <= n; i++) {
            if (score[i] == n - 1) {
                return i;
            }
        }
        
        return -1;
    }
}
