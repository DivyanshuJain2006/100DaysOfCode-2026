/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     struct TreeNode *left;
 *     struct TreeNode *right;
 * };
 */
int diameter=0;
 int max(int a,int b){
    return (a>b)?a:b;
 }

 int depth(struct TreeNode* node){
    if(node==NULL) return 0;
    int left=depth(node->left);
    int right=depth(node->right);
    if(left+right>diameter) diameter=left+right;

    return 1+max(left,right);
 }
int diameterOfBinaryTree(struct TreeNode* root) {
    diameter=0;
    depth(root);
    return diameter;
}
