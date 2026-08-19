class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] in = new int[n + 1];   // times person is trusted
        int[] out = new int[n + 1];  // times person trusts others

        for (int[] t : trust) {
            out[t[0]]++;
            in[t[1]]++;
        }

        for (int i = 1; i <= n; i++) {
            if (out[i] == 0 && in[i] == n - 1) {
                return i;
            }
        }
        return -1;
    }
}