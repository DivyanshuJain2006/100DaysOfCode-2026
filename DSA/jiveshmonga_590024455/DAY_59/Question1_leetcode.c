
#include <stdbool.h>
bool isCompleteTree(struct TreeNode* root) {
    struct TreeNode* queue[105];
    int front=0,rear=0;
    queue[rear++]=root;
    bool seenNull=false;
    while (front < rear) 
    {
        struct TreeNode* curr=queue[front++];
        if (curr == NULL) 
        {
            seenNull=true;
        } 
        else 
        {
            if (seenNull)
                return false;
            queue[rear++]=curr->left;
            queue[rear++]=curr->right;
        }
    }
    return true;
}