/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     struct TreeNode *left;
 *     struct TreeNode *right;
 * };
 */
bool evaluateTree(struct TreeNode* root) {
    if(root->left==NULL&&root->right==NULL)
        return root->val;

    bool l=evaluateTree(root->left);
    bool r=evaluateTree(root->right);

    if(root->val==2)
        return l||r;
    return l&&r;
}
