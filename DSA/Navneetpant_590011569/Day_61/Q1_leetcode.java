class Solution {
    public int findJudge(int n, int[][] trust) {
        
        if (n == 1 ) {
            return 1;
        }

        int [] inDegree  = new int [n+1];
        int [] outDegree = new int [n+1];

        for (int [] arr : trust) {
            int x = arr[0];
            int y = arr[1];

            inDegree[y]++;
            outDegree[x]++;
        }

        for (int i = 0 ; i < inDegree.length; i++ ) {
            if (inDegree[i] == n-1 && outDegree[i]==0) {
                return i;
            }
        }
        return -1;
       
    }
}