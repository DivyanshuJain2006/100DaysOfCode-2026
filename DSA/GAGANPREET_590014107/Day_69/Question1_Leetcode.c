/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     struct TreeNode *left;
 *     struct TreeNode *right;
 * };
 */

struct TreeNode* createNode(int val) {
    struct TreeNode* node =
        (struct TreeNode*)malloc(sizeof(struct TreeNode));

    node->val = val;
    node->left = NULL;
    node->right = NULL;

    return node;
}

struct TreeNode* build(int* preorder, int size, int* index, int bound) {
    if (*index == size || preorder[*index] > bound)
        return NULL;

    int val = preorder[*index];
    (*index)++;

    struct TreeNode* root = createNode(val);

    root->left = build(preorder, size, index, val);
    root->right = build(preorder, size, index, bound);

    return root;
}

struct TreeNode* bstFromPreorder(int* preorder, int preorderSize) {
    int index = 0;

    return build(preorder, preorderSize, &index, INT_MAX);
}
