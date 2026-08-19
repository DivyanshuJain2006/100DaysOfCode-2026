/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     struct TreeNode *left;
 *     struct TreeNode *right;
 * };
 */
bool isCompleteTree(struct TreeNode* root) {
    if (root == NULL)
        return true;
    struct TreeNode* queue[1000];
    int front = 0;
    int rear = 0;
    queue[rear++] = root;
    int foundNull = 0;
    while (front < rear) {
        struct TreeNode* node = queue[front++];
        if (node == NULL) {
            foundNull = 1;
        }
        else {
            if (foundNull == 1)
                return false;

            queue[rear++] = node->left;
            queue[rear++] = node->right;
        }
    }
    return true;
}