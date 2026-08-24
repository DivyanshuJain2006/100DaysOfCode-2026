class Solution {
public:
    int minGroups(int n, vector<int>& mentor) {
        vector<int> dp(n + 1, 0);

        function<int(int)> depth = [&](int student) {
            if (student == -1)
                return 0;

            if (dp[student])
                return dp[student];

            return dp[student] =
                1 + depth(mentor[student - 1]);
        };

        int ans = 0;

        for (int i = 1; i <= n; i++) {
            ans = max(ans, depth(i));
        }

        return ans;
    }
};