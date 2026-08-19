/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     struct TreeNode *left;
 *     struct TreeNode *right;
 * };
 */

/**
 * Note: The returned array must be malloced, assume caller calls free().
 */

int maxCount = 0;
int currentCount = 0;
int prevValue = 0;
int hasPrev = 0;

int* result;
int resultSize;

void inorder(struct TreeNode* root) {
    if (root == NULL)
        return;

    inorder(root->left);

    // Count current value
    if (hasPrev && root->val == prevValue)
        currentCount++;
    else
        currentCount = 1;

    // New maximum frequency
    if (currentCount > maxCount) {
        maxCount = currentCount;
        resultSize = 0;
        result[resultSize++] = root->val;
    }
    // Another value with same maximum frequency
    else if (currentCount == maxCount) {
        result[resultSize++] = root->val;
    }

    prevValue = root->val;
    hasPrev = 1;

    inorder(root->right);
}

int* findMode(struct TreeNode* root, int* returnSize) {
    result = (int*)malloc(10000 * sizeof(int));

    maxCount = 0;
    currentCount = 0;
    prevValue = 0;
    hasPrev = 0;
    resultSize = 0;

    inorder(root);

    *returnSize = resultSize;
    return result;
}
