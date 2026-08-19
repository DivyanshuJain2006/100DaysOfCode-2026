#include <vector>

using namespace std;

class Solution {
public:
    int findJudge(int n, vector<vector<int>>& trust) {
        // Array to store the net trust score for each person (1-indexed)
        vector<int> trustScores(n + 1, 0);
        
        for (const auto& relation : trust) {
            trustScores[relation[0]]--; // This person trusts someone (out-degree)
            trustScores[relation[1]]++; // This person is trusted (in-degree)
        }
        
        // Find the person with a net trust score of n - 1
        for (int i = 1; i <= n; ++i) {
            if (trustScores[i] == n - 1) {
                return i;
            }
        }
        
        return -1; // No town judge found
    }
};