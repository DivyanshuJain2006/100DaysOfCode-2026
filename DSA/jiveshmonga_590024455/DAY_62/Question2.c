
int max(int a,int b) 
{
    return (a > b) ? a : b;
}
void dfs(struct TreeNode* root,int res[2]) 
{
    if (root==NULL) 
    {
        res[0]=0;
        res[1]=0;
        return;
    }
    int left[2],right[2];
    dfs(root->left,left);
    dfs(root->right,right);
    res[0] = root->val + left[1]+right[1];
    res[1]=max(left[0],left[1]) +max(right[0],right[1]);
}
int rob(struct TreeNode* root) 
{
    int ans[2];
    dfs(root,ans);
    return max(ans[0], ans[1]);
}