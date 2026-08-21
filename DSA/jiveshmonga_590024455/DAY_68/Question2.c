#include <stdio.h>
#include <limits.h>
struct Node 
{
    int val;
    struct Node *left;
    struct Node *right;
};
int countNodes(struct Node *root) {
    if (root==NULL)
        return 0;

    return 1+countNodes(root->left)+countNodes(root->right);
}
int isBST(struct Node *root,int min,int max) {
    if (root==NULL)
        return 1;
    if (root->val<=min||root->val>=max)
        return 0;
    return isBST(root->left, min,root->val) &&
           isBST(root->right,root->val, max);
}
int largestBST(struct Node *root) 
{
    if (root == NULL)
        return 0;
    int ans=0;
    if (isBST(root, INT_MIN, INT_MAX))
        ans=countNodes(root);
    int left=largestBST(root->left);
    int right=largestBST(root->right);
    if (left>ans)
        ans=left;
    if (right > ans)
        ans = right;
    return ans;
}