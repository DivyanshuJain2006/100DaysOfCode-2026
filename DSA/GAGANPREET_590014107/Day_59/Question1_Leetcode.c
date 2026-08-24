bool isCompleteTree(struct TreeNode* root) {
    if (root == NULL)
        return true;

    struct TreeNode* queue[10000];
    int front = 0, rear = 0;

    queue[rear++] = root;

    bool seenNull = false;

    while (front < rear) {
        struct TreeNode* current = queue[front++];

        if (current == NULL) {
            seenNull = true;
        } 
        else {
            // We already found a NULL position,
            // but now found a node -> incomplete
            if (seenNull)
                return false;

            queue[rear++] = current->left;
            queue[rear++] = current->right;
        }
    }

    return true;
}
