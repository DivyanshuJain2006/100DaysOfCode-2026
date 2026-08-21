#include <stdio.h>
#include <stdlib.h>

struct Node {
    int val;
    struct Node *left;
    struct Node *right;
};

struct Node* createNode(int val) {
    struct Node* newNode =
        (struct Node*)malloc(sizeof(struct Node));

    newNode->val = val;
    newNode->left = NULL;
    newNode->right = NULL;

    return newNode;
}

/* Insert values into BST */
struct Node* insert(struct Node* root, int val) {
    if (root == NULL)
        return createNode(val);

    if (val < root->val)
        root->left = insert(root->left, val);
    else
        root->right = insert(root->right, val);

    return root;
}

/* Store BST values in sorted order */
void inorder(struct Node* root, int arr[], int* index) {
    if (root == NULL)
        return;

    inorder(root->left, arr, index);

    arr[(*index)++] = root->val;

    inorder(root->right, arr, index);
}

/* Build balanced BST from sorted array */
struct Node* buildBalanced(int arr[], int left, int right) {
    if (left > right)
        return NULL;

    int mid = left + (right - left) / 2;

    struct Node* root = createNode(arr[mid]);

    root->left = buildBalanced(arr, left, mid - 1);
    root->right = buildBalanced(arr, mid + 1, right);

    return root;
}

/* Print inorder traversal */
void printInorder(struct Node* root) {
    if (root == NULL)
        return;

    printInorder(root->left);
    printf("%d ", root->val);
    printInorder(root->right);
}

int main() {
    int n;

    printf("Enter number of nodes: ");
    scanf("%d", &n);

    struct Node* root = NULL;

    printf("Enter BST values: ");

    for (int i = 0; i < n; i++) {
        int value;
        scanf("%d", &value);
        root = insert(root, value);
    }

    int arr[10000];
    int index = 0;

    // Step 1: BST -> sorted array
    inorder(root, arr, &index);

    // Step 2: Sorted array -> balanced BST
    struct Node* balancedRoot =
        buildBalanced(arr, 0, index - 1);

    printf("Balanced BST (inorder): ");

    printInorder(balancedRoot);

    printf("\n");

    return 0;
}