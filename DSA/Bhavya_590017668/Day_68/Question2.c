#include <stdio.h>
#include <stdlib.h>
#include <limits.h>

struct TreeNode {
    int val;
    struct TreeNode* left;
    struct TreeNode* right;
};

struct Info {
    int size;
    int min;
    int max;
    int isBST;
};

int maxBST = 0;

struct Info check(struct TreeNode* root) {
    if (root == NULL) {
        return (struct Info){0, INT_MAX, INT_MIN, 1};
    }

    struct Info left = check(root->left);
    struct Info right = check(root->right);

    struct Info curr;

    if (left.isBST && right.isBST &&
        root->val > left.max &&
        root->val < right.min) {

        curr.isBST = 1;
        curr.size = left.size + right.size + 1;

        curr.min = (root->val < left.min) ? root->val : left.min;
        curr.max = (root->val > right.max) ? root->val : right.max;

        if (curr.size > maxBST)
            maxBST = curr.size;
    }
    else {
        curr.isBST = 0;
        curr.size = 0;
        curr.min = INT_MIN;
        curr.max = INT_MAX;
    }

    return curr;
}

int largestBSTSubtree(struct TreeNode* root) {
    maxBST = 0;
    check(root);
    return maxBST;
}