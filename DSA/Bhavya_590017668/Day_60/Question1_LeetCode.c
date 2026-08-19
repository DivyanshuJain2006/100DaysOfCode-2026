int height(struct TreeNode* root, int* diameter) {
    if (root == NULL)
        return 0;

    int left = height(root->left, diameter);
    int right = height(root->right, diameter);

    if (left + right > *diameter)
        *diameter = left + right;

    return 1 + (left > right ? left : right);
}

int diameterOfBinaryTree(struct TreeNode* root) {
    int diameter = 0;
    height(root, &diameter);
    return diameter;
}