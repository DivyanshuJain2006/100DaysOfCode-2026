/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     struct TreeNode *left;
 *     struct TreeNode *right;
 * };
 */
struct TreeNode* insertIntaoBST(struct TreeNode* root, int val) {
        if(root==NULL){
            struct TreeNode* newnode=malloc(sizeof(struct TreeNode));
            newnode->val=val;
            newnode->left=NULL;
            newnode->right=NULL;
            return newnode;
        }
        if(root->val<val)
        root->right=insertIntoBST(root->right,val);
        if(root->val>val)
        root->left=insertIntoBST(root->left,val);

    
    return root;
}
