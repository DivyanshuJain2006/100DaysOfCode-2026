#include <stdbool.h>
#include <stdlib.h>

//Definition for a binary tree node.
struct TreeNode {
    int val;
    struct TreeNode *left;
    struct TreeNode *right;
};

bool isCompleteTree(struct TreeNode* root) {
    if (root == NULL)
        return true;
    struct TreeNode* queue[10000];
    int front = 0;
    int rear = 0;
    queue[rear++] = root;
    bool foundNull = false;
    while (front < rear) {
        struct TreeNode* node = queue[front++];
        if (node == NULL) {
            foundNull = true;
        } else {
            if (foundNull)
                return false;
            queue[rear++] = node->left;
            queue[rear++] = node->right;
        }
    }
    return true;
}