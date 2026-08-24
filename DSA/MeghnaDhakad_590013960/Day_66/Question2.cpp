#include <iostream>
#include <vector>

using namespace std;

// Helper function to perform in-order traversal on the array-based BST
void inorder(const vector<int>& tree, int idx, vector<int>& result) {
    if (idx >= tree.size() || tree[idx] == -1) {
        return;
    }
    
    inorder(tree, 2 * idx + 1, result); // Left
    result.push_back(tree[idx]);        // Root
    inorder(tree, 2 * idx + 2, result); // Right
}

vector<int> mergeCorporateTrees(const vector<int>& tree1, const vector<int>& tree2) {
    vector<int> list1;
    vector<int> list2;
    
    // Extract sorted elements from both trees
    inorder(tree1, 0, list1);
    inorder(tree2, 0, list2);
    
    vector<int> merged;
    int i = 0, j = 0;
    
    // Merge the two sorted arrays using two pointers
    while (i < list1.size() && j < list2.size()) {
        int valToAdd;
        
        if (list1[i] < list2[j]) {
            valToAdd = list1[i++];
        } else if (list1[i] > list2[j]) {
            valToAdd = list2[j++];
        } else {
            // Both are equal, add one and advance both pointers to avoid duplicates
            valToAdd = list1[i];
            i++;
            j++;
        }
        
        // Ensure uniqueness in the final merged array
        if (merged.empty() || merged.back() != valToAdd) {
            merged.push_back(valToAdd);
        }
    }
    
    // Add any remaining elements from list1
    while (i < list1.size()) {
        if (merged.empty() || merged.back() != list1[i]) {
            merged.push_back(list1[i]);
        }
        i++;
    }
    
    // Add any remaining elements from list2
    while (j < list2.size()) {
        if (merged.empty() || merged.back() != list2[j]) {
            merged.push_back(list2[j]);
        }
        j++;
    }
    
    return merged;
}

int main() {
    vector<int> tree1 = {2, 1, 3};
    vector<int> tree2 = {4, -1, 5};
    
    vector<int> result = mergeCorporateTrees(tree1, tree2);
    
    cout << "Output: [";
    for (int i = 0; i < result.size(); i++) {
        cout << result[i] << (i == result.size() - 1 ? "" : ", ");
    }
    cout << "]\n";
    
    return 0;
}