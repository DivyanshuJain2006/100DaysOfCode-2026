#include <stdio.h>
#include <stdlib.h>

struct Node {
    int data;
    struct Node *left;
    struct Node *right;
};

struct Node* createNode(int data) {
    struct Node* newNode = (struct Node*)malloc(sizeof(struct Node));
    newNode->data = data;
    newNode->left = NULL;
    newNode->right = NULL;
    return newNode;
}

int isComplete(struct Node* root) {
    if (root == NULL)
        return 1;

    struct Node* queue[1000];
    int front = 0, rear = 0;
    int nullFound = 0;

    queue[rear++] = root;

    while (front < rear) {
        struct Node* current = queue[front++];

        if (current == NULL) {
            nullFound = 1;
        } 
        else {
            // If a NULL was already found,
            // a non-NULL node means tree is incomplete
            if (nullFound)
                return 0;

            queue[rear++] = current->left;
            queue[rear++] = current->right;
        }
    }

    return 1;
}

int main() {
    int n;

    printf("Enter number of nodes: ");
    scanf("%d", &n);

    int arr[n];

    printf("Enter elements (-1 for NULL): ");
    for (int i = 0; i < n; i++)
        scanf("%d", &arr[i]);

    if (n == 0) {
        printf("true\n");
        return 0;
    }

    struct Node* nodes[n];

    for (int i = 0; i < n; i++) {
        if (arr[i] == -1)
            nodes[i] = NULL;
        else
            nodes[i] = createNode(arr[i]);
    }

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

    struct Node* root = nodes[0];

    if (isComplete(root))
        printf("true\n");
    else
        printf("false\n");

    return 0;
}