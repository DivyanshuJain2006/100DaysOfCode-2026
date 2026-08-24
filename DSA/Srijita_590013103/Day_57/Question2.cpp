#include <bits/stdc++.h>
using namespace std;

bool mirror(const vector<long long>& a,
            const vector<long long>& b,
            int i, int j) {

    if (i >= a.size() && j >= b.size())
        return true;

    if (i >= a.size() || j >= b.size())
        return false;

    if (a[i] == -1 && b[j] == -1)
        return true;

    if (a[i] == -1 || b[j] == -1)
        return false;

    if (a[i] != b[j])
        return false;

    return mirror(a, b, 2 * i + 1, 2 * j + 2) &&
           mirror(a, b, 2 * i + 2, 2 * j + 1);
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int t;
    cin >> t;

    while (t--) {
        int n1;
        cin >> n1;

        vector<long long> a(n1);
        for (long long &x : a)
            cin >> x;

        int n2;
        cin >> n2;

        vector<long long> b(n2);
        for (long long &x : b)
            cin >> x;

        cout << (mirror(a, b, 0, 0) ? "YES" : "NO") << '\n';
    }

    return 0;
}