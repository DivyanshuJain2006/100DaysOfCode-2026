#include <bits/stdc++.h>
using namespace std;

pair<int, int> solve(vector<int>& tree, int i, int n) {
    if (i >= n || tree[i] == -1) {
        return {0, 0};
    }

    auto left = solve(tree, 2 * i + 1, n);
    auto right = solve(tree, 2 * i + 2, n);

    int rob = tree[i] + left.second + right.second;

    int skip = max(left.first, left.second)
             + max(right.first, right.second);

    return {rob, skip};
}

int main() {
    int n;
    cin >> n;

    vector<int> tree(n);

    for (int i = 0; i < n; i++) {
        cin >> tree[i];
    }

    auto ans = solve(tree, 0, n);

    cout << max(ans.first, ans.second) << endl;

    return 0;
}