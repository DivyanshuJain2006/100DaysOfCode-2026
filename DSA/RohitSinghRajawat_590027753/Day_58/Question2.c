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
    if(value == -1)
        return NULL;

    struct TreeNode* node = malloc(sizeof(struct TreeNode));

    node->val = value;
    node->left = NULL;
    node->right = NULL;

    return node;
}

int find(struct TreeNode* root, int x)
{
    if(root == NULL)
        return 0;

    if(root->val == x)
        return 1;

    return find(root->left, x) || find(root->right, x);
}

struct TreeNode* lca(struct TreeNode* root, int a, int b)
{
    if(root == NULL)
        return NULL;

    if(root->val == a || root->val == b)
        return root;

    struct TreeNode* left = lca(root->left, a, b);
    struct TreeNode* right = lca(root->right, a, b);

    if(left != NULL && right != NULL)
        return root;

    if(left != NULL)
        return left;

    return right;
}

int main()
{
    struct TreeNode* root = createNode(3);

    root->left = createNode(5);
    root->right = createNode(1);

    root->left->left = createNode(6);
    root->left->right = createNode(2);

    root->right->left = createNode(0);
    root->right->right = createNode(8);

    root->left->right->left = createNode(7);
    root->left->right->right = createNode(4);

    int a = 5;
    int b = 1;

    if(!find(root, a) || !find(root, b))
    {
        printf("-1\n");
    }
    else
    {
        struct TreeNode* result = lca(root, a, b);
        printf("%d\n", result->val);
    }

    return 0;
}