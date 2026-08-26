struct TreeNode* balanceBST(struct TreeNode* root) {
    int arr[10000];
    int n = 0;
    void inorder(struct TreeNode* node) {
        if (node == NULL)
            return;
        inorder(node->left);
        arr[n++] = node->val;
        inorder(node->right);
    }
    struct TreeNode* build(int start, int end) {
        if (start > end)
            return NULL;
        int mid = (start + end) / 2;
        struct TreeNode* newNode =
            (struct TreeNode*)malloc(sizeof(struct TreeNode));
        newNode->val = arr[mid];
        newNode->left = build(start, mid - 1);
        newNode->right = build(mid + 1, end);
        return newNode;
    }
    inorder(root);
    return build(0, n - 1);
}