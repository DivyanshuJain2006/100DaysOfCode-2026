#include <iostream>
#include <vector>
#include <algorithm>
#include <climits>

using namespace std;

// Data structure to pass information up the recursive calls
struct SubtreeInfo {
    bool isBST;
    int size;
    int minVal;
    int maxVal;
};

SubtreeInfo dfs(const vector<int>& tree, int idx, int& maxSize) {
    // Base case: out of bounds or missing node (-1)
    // A null node is technically a valid BST of size 0
    if (idx >= tree.size() || tree[idx] == -1) {
        return {true, 0, INT_MAX, INT_MIN};
    }
    
    int val = tree[idx];
    
    // Post-order traversal: process left and right subtrees first
    SubtreeInfo left = dfs(tree, 2 * idx + 1, maxSize);
    SubtreeInfo right = dfs(tree, 2 * idx + 2, maxSize);
    
    // Check if the current subtree is a valid BST
    if (left.isBST && right.isBST && val > left.maxVal && val < right.minVal) {
        int currentSize = left.size + right.size + 1;
        maxSize = max(maxSize, currentSize); // Update global max
        
        // Return info for the current valid BST
        return {
            true, 
            currentSize, 
            min(val, left.minVal), 
            max(val, right.maxVal)
        };
    }
    
    // If it's not a valid BST, pass false. Min/Max values no longer matter.
    return {false, 0, 0, 0}; 
}

int largestBSTSubtree(const vector<int>& tree) {
    int maxSize = 0;
    dfs(tree, 0, maxSize);
    return maxSize;
}

int main() {
    vector<int> tree = {10, 5, 15, 1, 8, -1, 7};
    
    cout << "Output: " << largestBSTSubtree(tree) << endl; 
    // Expected Output: 3 
    // (The subtree rooted at 5 with children 1 and 8 is the largest valid BST)
    
    return 0;
}