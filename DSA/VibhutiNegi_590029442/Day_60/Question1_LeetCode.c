/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     struct TreeNode *left;
 *     struct TreeNode *right;
 * };
 */
int diameter = 0;
int height(struct TreeNode* root) {
    if (root == NULL)
        return 0;
    int leftHeight = height(root->left);
    int rightHeight = height(root->right);
    if (leftHeight + rightHeight > diameter)
        diameter = leftHeight + rightHeight;
    return 1 + (leftHeight > rightHeight ? leftHeight : rightHeight);
}
int diameterOfBinaryTree(struct TreeNode* root) {
    diameter = 0;
    height(root);
    return diameter;
}