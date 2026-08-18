#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int T;
    cin >> T;

    while (T--) {
        int n;
        cin >> n;

        vector<long long> tree(n + 1);
        for (int i = 1; i <= n; i++)
            cin >> tree[i];

        double target;
        cin >> target;

        int idx = 1;
        long long closest = tree[1];

        while (idx <= n && tree[idx] != -1) {
            long long val = tree[idx];

            double d1 = abs((double)val - target);
            double d2 = abs((double)closest - target);

            if (d1 < d2 || (d1 == d2 && val < closest))
                closest = val;

            if (target < val)
                idx = 2 * idx;
            else if (target > val)
                idx = 2 * idx + 1;
            else
                break;
        }

        cout << closest << '\n';
    }

    return 0;
}
