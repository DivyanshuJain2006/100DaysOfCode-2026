#include <stdio.h>
#include <stdlib.h>

struct TreeNode {
    int val;
    struct TreeNode *left;
    struct TreeNode *right;
};

int max(int a, int b) {
    return a > b ? a : b;
}

void solve(struct TreeNode* root, int* rob, int* skip) {
    if (root == NULL) {
        *rob = 0;
        *skip = 0;
        return;
    }

    int leftRob, leftSkip, rightRob, rightSkip;

    solve(root->left, &leftRob, &leftSkip);
    solve(root->right, &rightRob, &rightSkip);

    *rob = root->val + leftSkip + rightSkip;

    *skip = max(leftRob, leftSkip) + max(rightRob, rightSkip);
}

int rob(struct TreeNode* root) {
    int robRoot, skipRoot;

    solve(root, &robRoot, &skipRoot);

    return max(robRoot, skipRoot);
}