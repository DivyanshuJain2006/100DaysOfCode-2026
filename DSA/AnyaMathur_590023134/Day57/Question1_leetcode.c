// Leetcode Problem 404
// Sum of Left Leaves 

/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     struct TreeNode *left;
 *     struct TreeNode *right;
 * };
 */
int sumOfLeftLeaves(struct TreeNode* root) {
    if (root == NULL)
        return 0;
    int total = 0;
    if (root->left != NULL) {
        if (root->left->left == NULL && root->left->right == NULL)
            total += root->left->val;
        else
            total += sumOfLeftLeaves(root->left);
    }
    total += sumOfLeftLeaves(root->right);
    return total;
}