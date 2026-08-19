class Solution {
    public int findJudge(int n, int[][] trust) {

        int[] score = new int[n + 1];

        for (int[] t : trust) {
            int a = t[0];
            int b = t[1];

            // a trusts someone -> a cannot be judge
            score[a]--;

            // b is trusted by someone
            score[b]++;
        }

        // Judge must be trusted by n-1 people
        // and must trust nobody
        for (int person = 1; person <= n; person++) {
            if (score[person] == n - 1) {
                return person;
            }
        }

        return -1;
    }
}