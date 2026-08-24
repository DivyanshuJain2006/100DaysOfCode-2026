/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     struct TreeNode *left;
 *     struct TreeNode *right;
 * };
 */

#include <stdlib.h>

struct TreeNode* build(int* preorder, int* index, int size, int upper)
{
    if (*index >= size || preorder[*index] > upper)
        return NULL;

    struct TreeNode* root = malloc(sizeof(struct TreeNode));
    root->val = preorder[*index];
    (*index)++;

    root->left = build(preorder, index, size, root->val);
    root->right = build(preorder, index, size, upper);

    return root;
}

struct TreeNode* bstFromPreorder(int* preorder, int preorderSize)
{
    int index = 0;

    return build(preorder, &index, preorderSize, 1001);
}