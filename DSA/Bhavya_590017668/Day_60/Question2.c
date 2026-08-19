#include <stdio.h>
#include <stdlib.h>

struct TreeNode {
    int val;
    struct TreeNode *left;
    struct TreeNode *right;
};

int countSafe(struct TreeNode* root, int maxVal) {
    if (root == NULL)
        return 0;

    int count = 0;

    if (root->val >= maxVal) {
        count = 1;
        maxVal = root->val;
    }

    count += countSafe(root->left, maxVal);
    count += countSafe(root->right, maxVal);

    return count;
}

int goodNodes(struct TreeNode* root) {
    if (root == NULL)
        return 0;

    return countSafe(root, root->val);
}