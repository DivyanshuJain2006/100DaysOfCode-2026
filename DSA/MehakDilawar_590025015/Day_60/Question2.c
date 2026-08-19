//Write an efficient function that counts the number of "safe" campsites in a binary tree, where a node is safe if its value 
//is greater than or equal to every node on the path from the root to it.
//Input: n=7 tree = [3, 1, 4, 3, -1, 1, 5]. Output: 4.
#include <stdio.h>
#include <stdlib.h>

typedef struct Node {
    int value;
    struct Node *left;
    struct Node *right;
} Node;

Node* createNode(int value) {
    Node *newNode = (Node*)malloc(sizeof(Node));
    newNode->value = value;
    newNode->left = NULL;
    newNode->right = NULL;
    return newNode;
}

Node* buildTree(int arr[], int n) {
    if (n == 0 || arr[0] == -1)
        return NULL;
    Node **queue = (Node**)malloc(n * sizeof(Node*));
    Node *root = createNode(arr[0]);
    queue[0] = root;
    int front = 0, rear = 1;
    int i = 1;
    while (front < rear && i < n) {
        Node *current = queue[front++];

        if (i < n && arr[i] != -1) {
            current->left = createNode(arr[i]);
            queue[rear++] = current->left;
        }
        i++;

        if (i < n && arr[i] != -1) {
            current->right = createNode(arr[i]);
            queue[rear++] = current->right;
        }
        i++;
    }
    free(queue);
    return root;
}

int countSafe(Node *root, int maxValue) {
    if (root == NULL)
        return 0;
    int count = 0;
    if (root->value >= maxValue)
        count = 1;
    if (root->value > maxValue)
        maxValue = root->value;
    count += countSafe(root->left, maxValue);
    count += countSafe(root->right, maxValue);
    return count;
}

int main() {
    int n;
    printf("Enter number of nodes: ");
    scanf("%d", &n);
    int *arr = (int*)malloc(n * sizeof(int));
    printf("Enter tree values in level order (-1 for NULL):\n");
    for (int i = 0; i < n; i++) {
        scanf("%d", &arr[i]);
    }
    Node *root = buildTree(arr, n);
    if (root != NULL)
        printf("Number of safe campsites: %d\n",
               countSafe(root, root->value));
    else
        printf("Number of safe campsites: 0\n");
    free(arr);
return 0;
}