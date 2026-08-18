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

int closestValue(struct TreeNode* root, int target)
{
    int closest = root->val;

    while (root != NULL)
    {
        int currentDiff = abs(root->val - target);
        int closestDiff = abs(closest - target);

        if (currentDiff < closestDiff ||
            (currentDiff == closestDiff && root->val < closest))
        {
            closest = root->val;
        }

        if (root->val < target)
            root = root->right;
        else if (root->val > target)
            root = root->left;
        else
            return root->val;
    }

    return closest;
}

int main()
{

    struct TreeNode *root = createNode(4);

    root->left = createNode(2);
    root->right = createNode(5);

    root->left->left = createNode(1);
    root->left->right = createNode(3);

    int target = 3;

    printf("Closest Temperature: %d\n",
           closestValue(root, target));

    return 0;
}