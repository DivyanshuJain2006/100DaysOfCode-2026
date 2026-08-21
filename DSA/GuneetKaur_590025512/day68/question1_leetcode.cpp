#include <iostream>
#include<vector>
using namespace std;

struct TreeNode {
    int val;
    TreeNode* left;
    TreeNode* right;

    TreeNode(int value) {
        val = value;
        left = NULL;
        right = NULL;
    }
};
class Solution {
public:

    void inorder(TreeNode* root, vector<int>& arr) {
        if (root == NULL)
            return;

        inorder(root->left, arr);
        arr.push_back(root->val);
        inorder(root->right, arr);
    }

    TreeNode* build(vector<int>& arr, int left, int right) {

        if (left > right)
            return NULL;

        int mid = left + (right - left) / 2;

        TreeNode* root = new TreeNode(arr[mid]);

        root->left = build(arr, left, mid - 1);
        root->right = build(arr, mid + 1, right);

        return root;
    }

    TreeNode* balanceBST(TreeNode* root) {

        vector<int> arr;
        inorder(root, arr);
        return build(arr, 0, arr.size() - 1);
    }
};