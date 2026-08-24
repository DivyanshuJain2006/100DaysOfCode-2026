
int dfs(struct TreeNode* root, int maxSoFar) 
{
    if (root==NULL)
        return 0;
    int count=0;
    if (root->val>=maxSoFar)
        count=1;
    if (root->val>maxSoFar)
        maxSoFar=root->val;
    count+=dfs(root->left,maxSoFar);
    count+=dfs(root->right,maxSoFar);
    return count;
}
int goodNodes(struct TreeNode* root) 
{
    return dfs(root, root->val);
}