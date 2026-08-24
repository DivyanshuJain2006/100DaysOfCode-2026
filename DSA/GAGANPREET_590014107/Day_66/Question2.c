#include <stdio.h>
#include <stdlib.h>

typedef struct Node {
    int data;
    struct Node* left;
    struct Node* right;
} Node;

Node* createNode(int data) {
    Node* newNode = (Node*)malloc(sizeof(Node));
    newNode->data = data;
    newNode->left = NULL;
    newNode->right = NULL;
    return newNode;
}

// Build tree from level-order array
Node* buildTree(int arr[], int n) {
    if (n == 0 || arr[0] == -1)
        return NULL;

    Node** queue = (Node**)malloc(n * sizeof(Node*));
    int front = 0, rear = 0;

    Node* root = createNode(arr[0]);
    queue[rear++] = root;

    int i = 1;

    while (i < n) {
        Node* current = queue[front++];

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

// Inorder traversal → sorted array for BST
void inorder(Node* root, int arr[], int* index) {
    if (root == NULL)
        return;

    inorder(root->left, arr, index);

    arr[(*index)++] = root->data;

    inorder(root->right, arr, index);
}

int main() {
    int n1, n2;

    // First tree
    scanf("%d", &n1);

    int* tree1 = (int*)malloc(n1 * sizeof(int));

    for (int i = 0; i < n1; i++)
        scanf("%d", &tree1[i]);

    // Second tree
    scanf("%d", &n2);

    int* tree2 = (int*)malloc(n2 * sizeof(int));

    for (int i = 0; i < n2; i++)
        scanf("%d", &tree2[i]);

    Node* root1 = buildTree(tree1, n1);
    Node* root2 = buildTree(tree2, n2);

    int arr1[1000], arr2[1000];
    int size1 = 0, size2 = 0;

    // Convert both BSTs into sorted arrays
    inorder(root1, arr1, &size1);
    inorder(root2, arr2, &size2);

    // Merge the two sorted arrays
    int i = 0, j = 0;

    while (i < size1 && j < size2) {

        if (arr1[i] < arr2[j]) {
            printf("%d ", arr1[i]);
            i++;
        }
        else if (arr2[j] < arr1[i]) {
            printf("%d ", arr2[j]);
            j++;
        }
        else {
            // Duplicate → print only once
            printf("%d ", arr1[i]);
            i++;
            j++;
        }
    }

    while (i < size1) {
        printf("%d ", arr1[i]);
        i++;
    }

    while (j < size2) {
        printf("%d ", arr2[j]);
        j++;
    }

    free(tree1);
    free(tree2);

    return 0;
}
