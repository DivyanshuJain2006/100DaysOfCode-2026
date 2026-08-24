/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     struct TreeNode *left;
 *     struct TreeNode *right;
 * };
 */

int leftHeight(struct TreeNode* root)
{
    int height = 0;

    while (root != NULL)
    {
        height++;
        root = root->left;
    }

    return height;
}

int rightHeight(struct TreeNode* root)
{
    int height = 0;

    while (root != NULL)
    {
        height++;
        root = root->right;
    }

    return height;
}

int countNodes(struct TreeNode* root)
{
    if (root == NULL)
        return 0;

    int left = leftHeight(root);
    int right = rightHeight(root);

    // Perfect binary tree
    if (left == right)
        return (1 << left) - 1;

    return 1 + countNodes(root->left) + countNodes(root->right);
}