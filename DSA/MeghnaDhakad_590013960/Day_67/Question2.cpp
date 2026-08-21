#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

// Recursive function to simulate the BST and calculate heights
int calculateBalance(int left, int right, vector<int>& counts) {
    // Base case: empty subtree has a height of 0
    if (left > right) {
        return 0;
    }
    
    // Naturally selects the left-middle element for even-length segments
    int mid = left + (right - left) / 2;
    
    // Get heights of the simulated left and right subtrees
    int leftHeight = calculateBalance(left, mid - 1, counts);
    int rightHeight = calculateBalance(mid + 1, right, counts);
    
    // Calculate balance factor: Height(Left) - Height(Right)
    int balanceFactor = leftHeight - rightHeight;
    
    // Update the corresponding spectrum count
    if (balanceFactor == -1) {
        counts[0]++;
    } else if (balanceFactor == 0) {
        counts[1]++;
    } else if (balanceFactor == 1) {
        counts[2]++;
    }
    
    // Return the height of the current simulated node
    return 1 + max(leftHeight, rightHeight);
}

vector<int> getBalanceSpectrum(const vector<int>& arr) {
    // counts[0] maps to BF -1, counts[1] to BF 0, counts[2] to BF +1
    vector<int> counts(3, 0); 
    
    if (!arr.empty()) {
        calculateBalance(0, arr.size() - 1, counts);
    }
    
    return counts;
}

int main() {
    vector<int> arr = {1, 2, 3, 4, 5, 6, 7};
    
    vector<int> result = getBalanceSpectrum(arr);
    
    cout << "Output: [" << result[0] << ", " << result[1] << ", " << result[2] << "]\n";
    // Expected Output: [0, 7, 0]
    
    return 0;
}