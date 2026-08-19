#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

// DFS function to find the depth of the current student's mentor chain
int getDepth(int i, const vector<int>& mentor, vector<int>& memo) {
    // Base case: The student has no mentor
    if (mentor[i] == -1) {
        return 1;
    }
    
    // Return cached result if already computed
    if (memo[i] != 0) {
        return memo[i];
    }
    
    // Values in `mentor` are 1-based IDs, so the 0-based index is `mentor[i] - 1`
    memo[i] = 1 + getDepth(mentor[i] - 1, mentor, memo);
    return memo[i];
}

int minGroups(int n, const vector<int>& mentor) {
    vector<int> memo(n, 0);
    int maxGroups = 0;
    
    // Calculate the depth for every student and find the maximum
    for (int i = 0; i < n; ++i) {
        maxGroups = max(maxGroups, getDepth(i, mentor, memo));
    }
    
    return maxGroups;
}

int main() {
    int n = 5;
    // -1: root, 1: mentored by 1, 2: mentored by 2, etc.
    vector<int> mentor = {-1, 1, 2, 1, -1};
    
    cout << "Output: " << minGroups(n, mentor) << endl; 
    // Expected Output: 3
    
    return 0;
}