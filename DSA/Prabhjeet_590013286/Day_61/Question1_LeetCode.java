//Need to find the person trusted by everyone and trusting nobody

class Solution {

    public int findJudge(int n, int[][] trust) {

        int[] score = new int[n + 1];

        for (int[] pair : trust)
        {
            score[pair[0]]--;
            score[pair[1]]++;
        }

        for (int i = 1; i <= n; i++)
        {
            if (score[i] == n - 1)
            {
                return i;
            }
        }

        return -1;
    }
}
