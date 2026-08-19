/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     struct TreeNode *left;
 *     struct TreeNode *right;
 * };
 */
int d=0;
int max(int a,int b) { 
    return (a>b)?a:b;
}
int deep(struct TreeNode* node){
    if(node==NULL) return 0;
    int l=deep(node->left),r=deep(node->right);
    d=max(d,l+r);
    return 1+max(l,r);
}
int diameterOfBinaryTree(struct TreeNode* root){
    d=0;
    deep(root);
    return d;
}
