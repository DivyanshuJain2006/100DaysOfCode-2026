/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     struct TreeNode *left;
 *     struct TreeNode *right;
 * };
 */
int countNodes(struct TreeNode* root) {
    if(root==NULL) return 0;
    int lft=countNodes(root->left), rht=countNodes(root->right);
    return 1+lft+rht;
}
