#include <iostream>
#include <vector>

using namespace std;

int getConferenceRoomLCA(const vector<int>& tree, int a, int b) {
    int idx = 0;
    int n = tree.size();
    
    // Iterate while we are within bounds and not on a missing node (-1)
    while (idx < n && tree[idx] != -1) {
        int curr = tree[idx];
        
        // If both rooms are smaller, LCA is in the left subtree
        if (a < curr && b < curr) {
            idx = 2 * idx + 1;
        }
        // If both rooms are larger, LCA is in the right subtree
        else if (a > curr && b > curr) {
            idx = 2 * idx + 2;
        }
        // Current node is between a and b (inclusive), this is the LCA
        else {
            return curr;
        }
    }
    
    return -1; // Return -1 if no valid LCA could be found
}

int main() {
    vector<int> tree = {6, 2, 8, 0, 4, 7, 9};
    int a = 2;
    int b = 8;
    
    cout << "Output: " << getConferenceRoomLCA(tree, a, b) << endl; 
    // Expected Output: 6
    
    return 0;
}