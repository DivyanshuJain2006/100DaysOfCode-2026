/**
 * Note: The returned array must be malloced, assume caller calls free().
 */

/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     struct TreeNode *left;
 *     struct TreeNode *right;
 * };
 */

void inorder(struct TreeNode *root,
             int *prev, int *count, int *maxCount,
             int *result, int *resultSize)
{
    if (root == NULL)
        return;

    inorder(root->left, prev, count, maxCount, result, resultSize);

    if (*prev == root->val)
        (*count)++;
    else
    {
        *prev = root->val;
        *count = 1;
    }

    if (*count > *maxCount)
    {
        *maxCount = *count;
        *resultSize = 0;
        result[(*resultSize)++] = root->val;
    }
    else if (*count == *maxCount)
    {
        result[(*resultSize)++] = root->val;
    }

    inorder(root->right, prev, count, maxCount, result, resultSize);
}

int* findMode(struct TreeNode* root, int* returnSize)
{
    int *result = malloc(10000 * sizeof(int));

    int prev = 0;
    int count = 0;
    int maxCount = 0;

    *returnSize = 0;

    inorder(root, &prev, &count, &maxCount, result, returnSize);

    return result;
}