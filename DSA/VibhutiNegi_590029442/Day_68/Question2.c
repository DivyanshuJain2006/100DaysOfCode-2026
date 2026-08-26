#include <stdio.h>
#include <stdlib.h>
#include <limits.h>
struct Node {
    int val;
    struct Node* left;
    struct Node* right;
};
int maxBST = 0;
int checkBST(struct Node* root, int* min, int* max) {
    if (root == NULL) {
        *min = INT_MAX;
        *max = INT_MIN;
        return 0;
    }
    int leftMin, leftMax;
    int rightMin, rightMax;
    int leftSize = checkBST(root->left, &leftMin, &leftMax);
    int rightSize = checkBST(root->right, &rightMin, &rightMax);
    if ((root->left == NULL || leftMax < root->val) &&
        (root->right == NULL || rightMin > root->val)) {
        int size = leftSize + rightSize + 1;
        if (size > maxBST)
            maxBST = size;
        if (root->left == NULL)
            *min = root->val;
        else
            *min = leftMin;
        if (root->right == NULL)
            *max = root->val;
        else
            *max = rightMax;
        return size;
    }
    *min = INT_MIN;
    *max = INT_MAX;
    return 0;
}
int largestBST(struct Node* root) {
    maxBST = 0;
    int min, max;
    checkBST(root, &min, &max);
    return maxBST;
}