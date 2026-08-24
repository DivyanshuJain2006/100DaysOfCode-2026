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
    int leftdepth=countNodes(root->left);
    int rightdepth=countNodes(root->right);
    return leftdepth+rightdepth+1;
}
