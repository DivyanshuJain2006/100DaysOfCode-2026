int robTree(struct TreeNode* root)
{
    if(root == NULL)
        return 0;

    int robRoot = root->val;

    if(root->left)
    {
        robRoot += robTree(root->left->left);
        robRoot += robTree(root->left->right);
    }

    if(root->right)
    {
        robRoot += robTree(root->right->left);
        robRoot += robTree(root->right->right);
    }

    int skipRoot = robTree(root->left) + robTree(root->right);

    return robRoot > skipRoot ? robRoot : skipRoot;
}