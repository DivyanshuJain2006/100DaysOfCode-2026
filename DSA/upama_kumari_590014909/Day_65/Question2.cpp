#include <bits/stdc++.h>
using namespace std;

int closestPreset(const vector<long long>& tree, int n, double target) {
    int index = 1;
    long long answer = tree[1];
    double bestDiff = abs(answer - target);
    const double EPS = 1e-9;

    while (index <= n && tree[index] != -1) {
        long long value = tree[index];
        double diff = abs(value - target);

        if (diff < bestDiff - EPS ||
            (abs(diff - bestDiff) <= EPS && value < answer)) {
            bestDiff = diff;
            answer = value;
        }

        if (target < value) {
            index = 2 * index;       // Left child
        } else if (target > value) {
            index = 2 * index + 1;   // Right child
        } else {
            return value;            // Exact match
        }
    }

    return answer;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int T;
    cin >> T;

    while (T--) {
        int n;
        cin >> n;

        // 1-indexed heap-style tree representation
        vector<long long> tree(n + 1);

        for (int i = 1; i <= n; i++) {
            cin >> tree[i];
        }

        double target;
        cin >> target;

        cout << closestPreset(tree, n, target) << '\n';
    }

    return 0;
}