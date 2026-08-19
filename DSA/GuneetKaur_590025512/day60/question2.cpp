#include<iostream>
using namespace std;

class TreeNode {
public:
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

    int countSafe(TreeNode* root, int maxValue) {

        if (root == NULL)
            return 0;

        int count = 0;

        if (root->val >= maxValue) {
            count = 1;
            maxValue = root->val;
        }

        count += countSafe(root->left, maxValue);
        count += countSafe(root->right, maxValue);

        return count;
    }

    int goodNodes(TreeNode* root) {
        return countSafe(root, root->val);
    }
};