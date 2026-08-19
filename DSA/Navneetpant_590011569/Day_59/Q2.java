class Q2 {

    static int[] tree;
    static int n;
    static int answer;

    static void dfs(int index, int[] freq) {

        if (index >= n || tree[index] == -1) {
            return;
        }


        freq[tree[index]]++;

        int left = 2 * index + 1;
        int right = 2 * index + 2;

   
        if ((left >= n || tree[left] == -1) &&
            (right >= n || tree[right] == -1)) {

            int odd = 0;

            for (int i = 0; i < 10; i++) {
                if (freq[i] % 2 != 0) {
                    odd++;
                }
            }

            if (odd <= 1) {
                answer++;
            }
        }

      
        dfs(left, freq);

      
        dfs(right, freq);

       
        freq[tree[index]]--;
    }
}