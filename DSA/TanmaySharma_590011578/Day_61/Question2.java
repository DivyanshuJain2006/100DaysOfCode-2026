
public class Question2 {
    public int groups(int n, int[] mentor) {
        Integer[] memo = new Integer[n];
        int result = 0;
        for (int i = 0; i < n; i++) {
            result = Math.max(result, depth(i, mentor, memo));
        }
        return result;
    }

    private int depth(int i, int[] mentor, Integer[] memo) {
        if (memo[i] != null) {
            return memo[i];
        }
        int m = mentor[i];
        memo[i] = (m == -1) ? 1 : 1 + depth(m - 1, mentor, memo);
        return memo[i];
    }
}