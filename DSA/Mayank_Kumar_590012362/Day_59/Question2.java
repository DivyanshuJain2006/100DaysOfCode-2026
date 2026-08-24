public class Question2 {
    public static int solve(int[] a) {
        int n = a.length, ans = 0;
        int[] x = new int[n];

        for (int i = 0; i < n; i++) {
            if (a[i] == -1) continue;

            int p = i == 0 ? 0 : x[(i - 1) / 2];
            x[i] = p ^ (1 << a[i]);

            if ((2 * i + 1 >= n || a[2 * i + 1] == -1) &&
                (2 * i + 2 >= n || a[2 * i + 2] == -1) &&
                Integer.bitCount(x[i]) <= 1)
                ans++;
        }
        return ans;
    }
}