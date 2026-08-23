/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     struct TreeNode *left;
 *     struct TreeNode *right;
 * };
 */
struct TreeNode* bstFromPreorder(int* preorder,int preorderSize){
    if(preorderSize==0)return NULL;
    struct TreeNode* root=malloc(sizeof(struct TreeNode));
    root->val=preorder[0];
    root->left=NULL;
    root->right=NULL;
    int i=1;
    while(i<preorderSize && preorder[i]<preorder[0])i++;
    root->left=bstFromPreorder(preorder+1,i-1);
    root->right=bstFromPreorder(preorder+i,preorderSize-i);

    return root;
}
