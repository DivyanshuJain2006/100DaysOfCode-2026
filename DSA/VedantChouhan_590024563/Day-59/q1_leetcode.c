#include <stdio.h>
#include <stdlib.h>

struct TreeNode {
    int val;
    struct TreeNode *left;
    struct TreeNode *right;
};

struct TreeNode* createNode(int value) {
    struct TreeNode* node =
        (struct TreeNode*)malloc(sizeof(struct TreeNode));

    node->val = value;
    node->left = NULL;
    node->right = NULL;

    return node;
}

int isCompleteTree(struct TreeNode* root) {

    if (root == NULL)
        return 1;

    struct TreeNode* queue[100];

    int front = 0;
    int rear = 0;

    queue[rear++] = root;

    int foundNull = 0;

    while (front < rear) {

        struct TreeNode* current = queue[front++];

        if (current == NULL) {
            foundNull = 1;
        }
        else {

            // After NULL, no actual node is allowed
            if (foundNull)
                return 0;

            queue[rear++] = current->left;
            queue[rear++] = current->right;
        }
    }

    return 1;
}

int main() {

    int n;

    printf("Enter number of nodes in level order: ");
    scanf("%d", &n);

    int values[n];

    printf("Enter values (-1 for NULL): ");

    for (int i = 0; i < n; i++) {
        scanf("%d", &values[i]);
    }

    struct TreeNode* nodes[n];

    // Create nodes
    for (int i = 0; i < n; i++) {

        if (values[i] == -1)
            nodes[i] = NULL;
        else
            nodes[i] = createNode(values[i]);
    }

    // Connect nodes using complete-tree indexing
    for (int i = 0; i < n; i++) {

        if (nodes[i] != NULL) {

            int left = 2 * i + 1;
            int right = 2 * i + 2;

            if (left < n)
                nodes[i]->left = nodes[left];

            if (right < n)
                nodes[i]->right = nodes[right];
        }
    }

    struct TreeNode* root = nodes[0];

    if (isCompleteTree(root))
        printf("true\n");
    else
        printf("false\n");

    return 0;
}