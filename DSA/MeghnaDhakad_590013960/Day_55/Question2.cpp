#include <bits/stdc++.h>
using namespace std;

long long maximumPleasure(vector<int>& length,
                          vector<int>& beauty,
                          int k) {

    int n = length.size();

    vector<pair<int, int>> songs;

    for (int i = 0; i < n; i++) {
        songs.push_back({beauty[i], length[i]});
    }

    // Highest beauty first
    sort(songs.rbegin(), songs.rend());

    priority_queue<int, vector<int>, greater<int>> pq;

    long long sum = 0;
    long long ans = 0;

    for (auto &song : songs) {
        int b = song.first;
        int len = song.second;

        pq.push(len);
        sum += len;

        // Keep only the k largest lengths
        if (pq.size() > k) {
            sum -= pq.top();
            pq.pop();
        }

        // Current beauty is the minimum beauty
        ans = max(ans, sum * b);
    }

    return ans;
}

int main() {
    vector<int> length = {4, 15, 3, 6};
    vector<int> beauty = {7, 1, 6, 8};

    int k = 3;

    cout << maximumPleasure(length, beauty, k);

    return 0;
}