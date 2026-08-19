bool isCompleteTree(struct TreeNode* root)
{
    struct TreeNode* queue[10000];
    int front = 0, rear = 0;
    int foundNull = 0;

    queue[rear++] = root;

    while(front < rear)
    {
        struct TreeNode* node = queue[front++];

        if(node == NULL)
        {
            foundNull = 1;
        }
        else
        {
            if(foundNull)
                return false;

            queue[rear++] = node->left;
            queue[rear++] = node->right;
        }
    }

    return true;
}