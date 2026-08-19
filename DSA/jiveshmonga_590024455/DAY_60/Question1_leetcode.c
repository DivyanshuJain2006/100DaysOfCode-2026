int maxDiameter = 0;

int height(struct TreeNode* root) 
{
    if (root==NULL)
        return 0;
    int left=height(root->left);
    int right=height(root->right);
    if (left+right>maxDiameter)
        maxDiameter=left+right;
    return (left>right?left:right)+1;
}
int diameterOfBinaryTree(struct TreeNode* root) 
{
    maxDiameter=0;
    height(root);
    return maxDiameter;
}