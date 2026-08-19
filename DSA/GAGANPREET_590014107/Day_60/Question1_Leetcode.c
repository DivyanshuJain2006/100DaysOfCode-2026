/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     struct TreeNode *left;
 *     struct TreeNode *right;
 * };
 */

int max(int a, int b) {
    return (a > b) ? a : b;
}

int height(struct TreeNode* root, int* diameter) {
    if (root == NULL)
        return 0;

    int leftHeight = height(root->left, diameter);
    int rightHeight = height(root->right, diameter);

    // Diameter passing through current node
    *diameter = max(*diameter, leftHeight + rightHeight);

    // Return height of current node
    return 1 + max(leftHeight, rightHeight);
}

int diameterOfBinaryTree(struct TreeNode* root) {
    int diameter = 0;

    height(root, &diameter);

    return diameter;
}
