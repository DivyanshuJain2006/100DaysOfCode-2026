#include <stdio.h>
#include <stdlib.h>
#include <math.h>

int closestValue(struct TreeNode* root, double target) {
    int closest = root->val;

    while (root != NULL) {
        if (fabs(root->val - target) < fabs(closest - target) ||
            (fabs(root->val - target) == fabs(closest - target) &&
             root->val < closest)) {
            closest = root->val;
        }

        if (target < root->val)
            root = root->left;
        else if (target > root->val)
            root = root->right;
        else
            return root->val;
    }

    return closest;
}