#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

// DFS function returning a pair: {max if we ROB this node, max if we SKIP this node}
pair<int, int> robDFS(const vector<int>& tree, int idx) {
    // Base case: Out of bounds or missing node
    if (idx >= tree.size() || tree[idx] == -1) {
        return {0, 0};
    }
    
    // Post-order traversal: Process children first
    pair<int, int> left = robDFS(tree, 2 * idx + 1);
    pair<int, int> right = robDFS(tree, 2 * idx + 2);
    
    // Option 1: Rob this node. We must SKIP both children.
    int robThis = tree[idx] + left.second + right.second;
    
    // Option 2: Skip this node. We can take the MAX of robbing or skipping each child.
    int skipThis = max(left.first, left.second) + max(right.first, right.second);
    
    return {robThis, skipThis};
}

int robHeist(const vector<int>& tree) {
    if (tree.empty()) return 0;
    
    pair<int, int> result = robDFS(tree, 0);
    
    // Return the maximum of either robbing or skipping the root
    return max(result.first, result.second);
}

int main() {
    vector<int> tree = {3, 2, 3, -1, 3, -1, 1};
    
    cout << "Output: " << robHeist(tree) << endl; 
    // Expected Output: 7 (Robbing the root '3' + the left child's right child '3' + the right child's right child '1')
    
    return 0;
}