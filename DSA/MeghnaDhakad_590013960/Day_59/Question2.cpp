#include <iostream>
#include <vector>
#include <unordered_set>

using namespace std;

int getDisputeResolutionLCA(const vector<int>& tree, int a, int b) {
    int idxA = -1;
    int idxB = -1;
    
    // 1. Find the indices of a and b in the array
    for (int i = 0; i < tree.size(); ++i) {
        if (tree[i] == a) idxA = i;
        if (tree[i] == b) idxB = i;
    }
    
    // If either employee is missing from the hierarchy
    if (idxA == -1 || idxB == -1) {
        return -1;
    }
    
    unordered_set<int> pathA;
    
    // 2. Trace path from node A to root
    while (idxA > 0) {
        pathA.insert(idxA);
        idxA = (idxA - 1) / 2; // Move to parent
    }
    pathA.insert(0); // Insert root index
    
    // 3. Trace path from node B to root to find LCA
    while (idxB > 0) {
        if (pathA.count(idxB)) {
            return tree[idxB];
        }
        idxB = (idxB - 1) / 2; // Move to parent
    }
    
    // Check root for B
    if (pathA.count(0)) {
        return tree[0];
    }
    
    return -1;
}

int main() {
    vector<int> tree = {3, 5, 1, 6, 2, 0, 8, -1, -1, 7, 4};
    int a = 5;
    int b = 1;
    
    cout << "Output: " << getDisputeResolutionLCA(tree, a, b) << endl; 
    // Expected Output: 3
    
    return 0;
}