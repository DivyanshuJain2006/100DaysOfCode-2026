/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     struct TreeNode *left;
 *     struct TreeNode *right;
 * };
 */
bool evaluateTree(struct TreeNode* root) {
    if(root->val==0) return 0;
    if(root->val==1) return 1;
    
    bool leftval=evaluateTree(root->left);
    bool rightval=evaluateTree(root->right);
    if(root->val==2)
    return leftval || rightval;
    if(root->val==3)
    return leftval && rightval;

    return 0;
}
