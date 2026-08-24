/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     struct TreeNode *left;
 *     struct TreeNode *right;
 * };
 */
bool isCompleteTree(struct TreeNode* root)
{
    if (root == NULL)
        return true;

    struct TreeNode* queue[200];
    int front = 0;
    int rear = 0;

    queue[rear++] = root;

    bool foundNull = false;

    while (front < rear)
    {
        struct TreeNode* current = queue[front++];

        if (current == NULL)
        {
            foundNull = true;
            continue;
        }

        if (foundNull)
            return false;

        queue[rear++] = current->left;
        queue[rear++] = current->right;
    }

    return true;
}