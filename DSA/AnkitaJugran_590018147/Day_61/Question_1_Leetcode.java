class Solution {
    public int findJudge(int n, int[][] trust) {

        int[] outgoing = new int[n + 1];
        int[] incoming = new int[n + 1];

        for (int[] pair : trust) {
            int a = pair[0];
            int b = pair[1];

            outgoing[a]++;
            incoming[b]++;
        }

        for (int person = 1; person <= n; person++) {
            if (outgoing[person] == 0 && incoming[person] == n - 1) {
                return person;
            }
        }

        return -1;
    }
}