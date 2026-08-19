int countNodes(struct TreeNode* root)
{
    if(root == NULL)
        return 0;

    int left = 0, right = 0;
    struct TreeNode *l = root, *r = root;

    while(l != NULL)
    {
        left++;
        l = l->left;
    }

    while(r != NULL)
    {
        right++;
        r = r->right;
    }

    if(left == right)
        return (1 << left) - 1;

    return 1 + countNodes(root->left) + countNodes(root->right);
}