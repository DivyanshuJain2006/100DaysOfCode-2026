#include <iostream>
#include <algorithm>
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
    int diameter = 0;

    int height(TreeNode* root) {
        if (root == NULL)
            return 0;

        int leftHeight = height(root->left);

        int rightHeight = height(root->right);

        diameter = max(diameter, leftHeight + rightHeight);

        return 1 + max(leftHeight, rightHeight);
    }

    int diameterOfBinaryTree(TreeNode* root) {
        height(root);
        return diameter;
    }
};

