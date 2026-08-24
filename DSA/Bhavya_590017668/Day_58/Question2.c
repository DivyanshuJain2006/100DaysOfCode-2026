#include <stdio.h>
#include <stdlib.h>

struct TreeNode {
    int val;
    struct TreeNode *left;
    struct TreeNode *right;
};

int find(struct TreeNode* root, int x) {
    if (root == NULL)
        return 0;
    if (root->val == x)
        return 1;
    return find(root->left, x) || find(root->right, x);
}

struct TreeNode* lca(struct TreeNode* root, int p, int q) {
    if (root == NULL || root->val == p || root->val == q)
        return root;

    struct TreeNode* left = lca(root->left, p, q);
    struct TreeNode* right = lca(root->right, p, q);

    if (left && right)
        return root;

    return left ? left : right;
}

int lowestCommonAncestor(struct TreeNode* root, int p, int q) {
    if (!find(root, p) || !find(root, q))
        return -1;

    struct TreeNode* ans = lca(root, p, q);
    return ans ? ans->val : -1;
}