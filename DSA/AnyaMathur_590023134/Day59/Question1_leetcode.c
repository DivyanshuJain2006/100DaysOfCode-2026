// Leetcode Problem 958
// Check Completeness of a Binary Tree

/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     struct TreeNode *left;
 *     struct TreeNode *right;
 * };
 */
bool isCompleteTree(struct TreeNode* root) {
    struct TreeNode* queue[10000];
    int front = 0, rear = 0;
    int foundNull = 0;
    queue[rear++] = root;
    while (front < rear) {
        struct TreeNode* curr = queue[front++];
        if (curr == NULL) {
            foundNull = 1;
        }
        else {
            if (foundNull == 1)
                return false;
            queue[rear++] = curr->left;
            queue[rear++] = curr->right;
        }
    }
    return true;
}