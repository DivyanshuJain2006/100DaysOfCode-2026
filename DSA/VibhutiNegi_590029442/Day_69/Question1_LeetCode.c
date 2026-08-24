/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     struct TreeNode *left;
 *     struct TreeNode *right;
 * };
 */
 struct TreeNode* createNode(int value) {
    struct TreeNode* node = (struct TreeNode*)malloc(sizeof(struct TreeNode));
    node->val = value;
    node->left = NULL;
    node->right = NULL;
    return node;
}
struct TreeNode* buildTree(int* preorder, int* index, int size, int upper) {
    if (*index >= size || preorder[*index] > upper)
        return NULL;
    int value = preorder[*index];
    (*index)++;
    struct TreeNode* root = createNode(value);
    root->left = buildTree(preorder, index, size, value);
    root->right = buildTree(preorder, index, size, upper);
    return root;
}
struct TreeNode* bstFromPreorder(int* preorder, int preorderSize) {
    int index = 0;
    return buildTree(preorder, &index, preorderSize, 1001);
}