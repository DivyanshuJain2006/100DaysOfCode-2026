bool isCompleteTree(struct TreeNode* root) {
    if (root == NULL)
        return true;

    struct TreeNode* queue[10000];
    int front = 0, rear = 0;
    bool nullFound = false;

    queue[rear++] = root;

    while (front < rear) {
        struct TreeNode* curr = queue[front++];

        if (curr == NULL) {
            nullFound = true;
        } else {
            if (nullFound)
                return false;

            queue[rear++] = curr->left;
            queue[rear++] = curr->right;
        }
    }

    return true;
}