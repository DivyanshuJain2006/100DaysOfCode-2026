#include <bits/stdc++.h>
using namespace std;

class Solution {
public:

    void inorder(Node* root, vector<int>& ans) {
        if (root == NULL)
            return;

        inorder(root->left, ans);
        ans.push_back(root->data);
        inorder(root->right, ans);
    }

    vector<int> mergeBSTs(Node* root1, Node* root2) {

        vector<int> a;
        vector<int> b;

        // Inorder traversal of both BSTs
        inorder(root1, a);
        inorder(root2, b);

        vector<int> result;

        int i = 0;
        int j = 0;

        // Merge two sorted arrays
        while (i < a.size() && j < b.size()) {

            if (a[i] < b[j]) {
                if (result.empty() || result.back() != a[i])
                    result.push_back(a[i]);

                i++;
            }

            else if (b[j] < a[i]) {
                if (result.empty() || result.back() != b[j])
                    result.push_back(b[j]);

                j++;
            }

            else {
                // Duplicate ID
                if (result.empty() || result.back() != a[i])
                    result.push_back(a[i]);

                i++;
                j++;
            }
        }

        // Remaining elements of first tree
        while (i < a.size()) {
            if (result.empty() || result.back() != a[i])
                result.push_back(a[i]);

            i++;
        }

        // Remaining elements of second tree
        while (j < b.size()) {
            if (result.empty() || result.back() != b[j])
                result.push_back(b[j]);

            j++;
        }

        return result;
    }
};