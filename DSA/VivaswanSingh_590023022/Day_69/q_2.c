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

void splitBST(struct TreeNode* root, int k,
              struct TreeNode** leftTree,
              struct TreeNode** rightTree)
{
    if (root == NULL)
    {
        *leftTree = NULL;
        *rightTree = NULL;
        return;
    }

    if (root->val < k)
    {
        *leftTree = root;

        splitBST(root->right, k, &root->right, rightTree);
    }
    else
    {
        *rightTree = root;

        splitBST(root->left, k, leftTree, &root->left);
    }
}

void preorder(struct TreeNode *root)
{
    if (root == NULL)
        return;

    printf("%d ", root->val);
    preorder(root->left);
    preorder(root->right);
}

int main()
{
    /*
             10
            /  \
           5    15
          / \   / \
         2   7 12 20
    */

    struct TreeNode *root = createNode(10);

    root->left = createNode(5);
    root->right = createNode(15);

    root->left->left = createNode(2);
    root->left->right = createNode(7);

    root->right->left = createNode(12);
    root->right->right = createNode(20);

    int k = 10;

    struct TreeNode *leftTree = NULL;
    struct TreeNode *rightTree = NULL;

    splitBST(root, k, &leftTree, &rightTree);

    if (leftTree == NULL)
        printf("EMPTY\n");
    else
    {
        preorder(leftTree);
        printf("\n");
    }

    if (rightTree == NULL)
        printf("EMPTY\n");
    else
    {
        preorder(rightTree);
        printf("\n");
    }

    return 0;
}