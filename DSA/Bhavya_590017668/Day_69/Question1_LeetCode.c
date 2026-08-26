struct TreeNode* bstFromPreorder(int* preorder, int preorderSize) {
    int index = 0;

    struct TreeNode* build(int upperBound) {
        if (index >= preorderSize || preorder[index] > upperBound)
            return NULL;

        int val = preorder[index++];

        struct TreeNode* root =
            (struct TreeNode*)malloc(sizeof(struct TreeNode));

        root->val = val;
        root->left = build(val);
        root->right = build(upperBound);

        return root;
    }

    return build(INT_MAX);
}