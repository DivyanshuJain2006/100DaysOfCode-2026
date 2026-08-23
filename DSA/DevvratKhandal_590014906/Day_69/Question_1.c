#include <stdio.h>
#include <stdlib.h>
#include <limits.h>

struct Node {
    int data;
    struct Node *left;
    struct Node *right;
};

struct Node* createNode(int value) {
    struct Node* newNode = (struct Node*)malloc(sizeof(struct Node));
    newNode->data = value;
    newNode->left = NULL;
    newNode->right = NULL;
    return newNode;
}

struct Node* buildBST(int preorder[], int n, int *index, int min, int max) {
    if (*index >= n)
        return NULL;

    int value = preorder[*index];

    if (value <= min || value >= max)
        return NULL;

    struct Node* root = createNode(value);
    (*index)++;

    root->left = buildBST(preorder, n, index, min, value);
    root->right = buildBST(preorder, n, index, value, max);

    return root;
}

void printLevelOrder(struct Node* root) {
    if (root == NULL)
        return;

    struct Node* queue[1000];
    int front = 0, rear = 0;

    queue[rear++] = root;

    while (front < rear) {
        struct Node* current = queue[front++];

        if (current == NULL) {
            printf("null ");
            continue;
        }

        printf("%d ", current->data);

        queue[rear++] = current->left;
        queue[rear++] = current->right;
    }
}

int main() {
    int n;

    printf("Enter number of elements: ");
    scanf("%d", &n);

    int preorder[n];

    printf("Enter preorder traversal: ");
    for (int i = 0; i < n; i++) {
        scanf("%d", &preorder[i]);
    }

    int index = 0;

    struct Node* root = buildBST(
        preorder, n, &index, INT_MIN, INT_MAX
    );

    printf("Level order traversal of constructed BST: ");
    printLevelOrder(root);

    return 0;
}