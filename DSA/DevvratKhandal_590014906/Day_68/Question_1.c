#include <stdio.h>
#include <stdlib.h>

struct Node {
    int data;
    struct Node *left, *right;
};

struct Node* createNode(int data) {
    struct Node* newNode = (struct Node*)malloc(sizeof(struct Node));
    newNode->data = data;
    newNode->left = NULL;
    newNode->right = NULL;
    return newNode;
}

/* Insert into BST */
struct Node* insert(struct Node* root, int data) {
    if (root == NULL)
        return createNode(data);

    if (data < root->data)
        root->left = insert(root->left, data);
    else
        root->right = insert(root->right, data);

    return root;
}

/* Store inorder traversal */
void inorder(struct Node* root, int arr[], int *index) {
    if (root == NULL)
        return;

    inorder(root->left, arr, index);
    arr[(*index)++] = root->data;
    inorder(root->right, arr, index);
}

/* Create balanced BST from sorted array */
struct Node* buildBalanced(int arr[], int start, int end) {
    if (start > end)
        return NULL;

    int mid = (start + end) / 2;

    struct Node* root = createNode(arr[mid]);

    root->left = buildBalanced(arr, start, mid - 1);
    root->right = buildBalanced(arr, mid + 1, end);

    return root;
}

/* Level order traversal */
void printLevelOrder(struct Node* root) {
    if (root == NULL)
        return;

    struct Node* queue[10000];
    int front = 0, rear = 0;

    queue[rear++] = root;

    while (front < rear) {
        struct Node* temp = queue[front++];

        printf("%d ", temp->data);

        if (temp->left != NULL)
            queue[rear++] = temp->left;

        if (temp->right != NULL)
            queue[rear++] = temp->right;
    }
}

int main() {
    int n;

    printf("Enter number of nodes: ");
    scanf("%d", &n);

    struct Node* root = NULL;

    printf("Enter BST elements: ");
    for (int i = 0; i < n; i++) {
        int x;
        scanf("%d", &x);
        root = insert(root, x);
    }

    int arr[10000];
    int index = 0;

    inorder(root, arr, &index);

    struct Node* balancedRoot = buildBalanced(arr, 0, index - 1);

    printf("Balanced BST (level order): ");
    printLevelOrder(balancedRoot);

    return 0;
}