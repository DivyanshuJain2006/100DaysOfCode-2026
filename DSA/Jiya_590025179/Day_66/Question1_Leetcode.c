/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     struct TreeNode *left;
 *     struct TreeNode *right;
 * };
 */
struct TreeNode* insertIntoBST(struct TreeNode* root, int val) {
        if(root==NULL){
            struct TreeNode* new=malloc(sizeof(struct TreeNode));
            new->val=val;
            new->right=NULL;
            new->left=NULL;
            return new;
        }
        if(root->val<val)root->right=insertIntoBST(root->right,val);
        if(root->val>val)root->left=insertIntoBST(root->left,val);
    return root;
}
