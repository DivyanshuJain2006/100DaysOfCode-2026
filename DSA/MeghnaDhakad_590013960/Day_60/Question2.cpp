#include <iostream>
#include <vector>
#include <algorithm>
#include <climits>

using namespace std;

void dfs(const vector<int>& tree, int idx, int maxSoFar, int& safeCount) {
    // Base case: Out of bounds or missing node
    if (idx >= tree.size() || tree[idx] == -1) {
        return;
    }
    
    // If the current node is greater than or equal to the max seen on its path
    if (tree[idx] >= maxSoFar) {
        safeCount++;
        maxSoFar = tree[idx]; // Update the maximum for subsequent children
    }
    
    int leftIdx = 2 * idx + 1;
    int rightIdx = 2 * idx + 2;
    
    // Recurse down left and right children
    dfs(tree, leftIdx, maxSoFar, safeCount);
    dfs(tree, rightIdx, maxSoFar, safeCount);
}

int countSafeCampsites(const vector<int>& tree) {
    int safeCount = 0;
    // Start DFS from root (index 0) with the lowest possible initial max
    dfs(tree, 0, INT_MIN, safeCount);
    return safeCount;
}

int main() {
    vector<int> tree = {3, 1, 4, 3, -1, 1, 5};
    
    cout << "Output: " << countSafeCampsites(tree) << endl; 
    // Expected Output: 4
    
    return 0;
}