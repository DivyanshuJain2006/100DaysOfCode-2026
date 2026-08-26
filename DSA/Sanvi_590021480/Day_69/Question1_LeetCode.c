/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     struct TreeNode *left;
 *     struct TreeNode *right;
 * };
 */
 struct TreeNode* createnode(int val){
    struct TreeNode* newnode=malloc(sizeof(struct TreeNode));
    newnode->val=val;
    newnode->left=NULL;
    newnode->right=NULL;
    return newnode;
 }

void build(struct TreeNode* head, int val){
    if(val<head->val && head->left==NULL)
    head->left=createnode(val);
    else if(val<head->val)
    build(head->left,val);
    else if(head->right==NULL)
    head->right=createnode(val);
    else
    build(head->right,val);
}
struct TreeNode* bstFromPreorder(int* preorder, int preorderSize) {
    struct TreeNode* head=createnode(preorder[0]);
    for(int i=1;i<preorderSize;i++)
    build(head,preorder[i]);

    return head;
}
