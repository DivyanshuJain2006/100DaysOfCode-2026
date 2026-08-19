
int dfs(struct TreeNode* root, int freq[]) 
{
    if (root==NULL)
        return 0;
    freq[root->val]++;
    int ans=0;
    if (root->left==NULL&&root->right==NULL) {
        int odd=0;
        for (int i=1;i<=9;i++) {
            if (freq[i]%2!=0)
                odd++;
        }
        if (odd<=1)
            ans=1;
    } 
    else 
    {
        ans = dfs(root->left, freq)+dfs(root->right, freq);
    }

    freq[root->val]--;
    return ans;
}
int pseudoPalindromicPaths(struct TreeNode* root) {
    int freq[10] = {0};
    return dfs(root, freq);
}