#include <bits/stdc++.h>
using namespace std;

long long maxPleasure(vector<int>& length, vector<int>& beauty, int k) {
    
    int n = length.size();

    // {beauty, length}
    vector<pair<int, int>> songs;

    for (int i = 0; i < n; i++) {
        songs.push_back({beauty[i], length[i]});
    }

    // Sort by beauty in descending order
    sort(songs.begin(), songs.end(), greater<pair<int, int>>());

    // Min heap for lengths
    priority_queue<int, vector<int>, greater<int>> pq;

    long long sumLength = 0;
    long long answer = 0;

    for (auto song : songs) {

        int b = song.first;
        int len = song.second;

        // Add current song
        pq.push(len);
        sumLength += len;

        // Keep at most k songs
        if (pq.size() > k) {
            sumLength -= pq.top();
            pq.pop();
        }

        // Current beauty is the minimum beauty
        // among the songs currently considered
        long long pleasure = sumLength * b;

        answer = max(answer, pleasure);
    }

    return answer;
}

int main() {

    vector<int> length = {4, 15, 3, 6};
    vector<int> beauty = {7, 1, 6, 8};

    int k = 3;

    cout << maxPleasure(length, beauty, k) << endl;

    return 0;
}