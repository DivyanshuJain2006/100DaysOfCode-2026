/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     struct TreeNode *left;
 *     struct TreeNode *right;
 * };
 */

void inorder(struct TreeNode* root, struct TreeNode** nodes, int* index) {
    if (root == NULL)
        return;

    inorder(root->left, nodes, index);

    nodes[(*index)++] = root;

    inorder(root->right, nodes, index);
}

struct TreeNode* buildBalanced(struct TreeNode** nodes, int left, int right) {
    if (left > right)
        return NULL;

    int mid = left + (right - left) / 2;

    struct TreeNode* root = nodes[mid];

    root->left = buildBalanced(nodes, left, mid - 1);
    root->right = buildBalanced(nodes, mid + 1, right);

    return root;
}

struct TreeNode* balanceBST(struct TreeNode* root) {
    struct TreeNode* nodes[10000];
    int index = 0;

    // Store nodes in sorted order
    inorder(root, nodes, &index);

    // Build balanced BST
    return buildBalanced(nodes, 0, index - 1);
}
