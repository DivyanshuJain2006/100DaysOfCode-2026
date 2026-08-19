import java.util.*;

public class Question2 {

    static int[] tree;
    static int n;
    static int[] dp;

    static int rob(int i) {

        if (i >= n || tree[i] == -1) {
            return 0;
        }

        if (dp[i] != -1) {
            return dp[i];
        }

        int robCurrent = tree[i];

        int left = 2 * i + 1;
        int right = 2 * i + 2;

        robCurrent += rob(left * 2 + 1);
        robCurrent += rob(left * 2 + 2);
        robCurrent += rob(right * 2 + 1);
        robCurrent += rob(right * 2 + 2);

        int skipCurrent = rob(left) + rob(right);

        dp[i] = Math.max(robCurrent, skipCurrent);

        return dp[i];
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        tree = new int[n];
        dp = new int[n];

        Arrays.fill(dp, -1);

        for (int i = 0; i < n; i++) {
            tree[i] = sc.nextInt();
        }

        System.out.println(rob(0));

        sc.close();
    }
}