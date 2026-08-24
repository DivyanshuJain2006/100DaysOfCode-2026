#include <stdio.h>
#include <stdlib.h>

struct TreeNode
{
    int val;
    struct TreeNode *left;
    struct TreeNode *right;
};

int findLCA(struct TreeNode* root, int a, int b)
{
    while(root != NULL)
    {
        if(a < root->val && b < root->val)
        {
            root = root->left;
        }
        else if(a > root->val && b > root->val)
        {
            root = root->right;
        }
        else
        {
            return root->val;
        }
    }

    return -1;
}

int main()
{
    struct TreeNode n0 = {0, NULL, NULL};
    struct TreeNode n4 = {4, &n0, NULL};
    struct TreeNode n7 = {7, NULL, NULL};
    struct TreeNode n9 = {9, NULL, NULL};
    struct TreeNode n2 = {2, &n0, &n4};
    struct TreeNode n8 = {8, &n7, &n9};
    struct TreeNode root = {6, &n2, &n8};

    int a = 2;
    int b = 8;

    printf("%d\n", findLCA(&root, a, b));

    return 0;
}