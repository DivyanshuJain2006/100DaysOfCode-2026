#include <stdio.h>
#include <stdlib.h>

struct TreeNode
{
    int val;
    struct TreeNode *left;
    struct TreeNode *right;
};

struct TreeNode* createNode(int value)
{
    struct TreeNode *node = malloc(sizeof(struct TreeNode));

    node->val = value;
    node->left = NULL;
    node->right = NULL;

    return node;
}

struct TreeNode* lowestCommonAncestor(struct TreeNode* root, int a, int b)
{
    if (a < root->val && b < root->val)
        return lowestCommonAncestor(root->left, a, b);

    if (a > root->val && b > root->val)
        return lowestCommonAncestor(root->right, a, b);

    return root;
}

int main()
{

    struct TreeNode *root = createNode(6);

    root->left = createNode(2);
    root->right = createNode(8);

    root->left->left = createNode(0);
    root->left->right = createNode(4);

    root->right->left = createNode(7);
    root->right->right = createNode(9);

    int a = 2;
    int b = 8;

    struct TreeNode *lca = lowestCommonAncestor(root, a, b);

    printf("Lowest Common Ancestor: %d\n", lca->val);

    return 0;
}