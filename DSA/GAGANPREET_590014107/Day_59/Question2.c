#include <stdio.h>
#include <stdlib.h>

typedef struct Node {
    int val;
    struct Node *left;
    struct Node *right;
} Node;

// Create a new node
Node* createNode(int val) {
    Node* newNode = (Node*)malloc(sizeof(Node));
    newNode->val = val;
    newNode->left = NULL;
    newNode->right = NULL;
    return newNode;
}

// Check whether digits can be rearranged into a palindrome
int canFormPalindrome(int mask) {
    // At most one digit can have an odd frequency
    return (mask & (mask - 1)) == 0;
}

// Count valid root-to-leaf paths
int countPaths(Node* root, int mask) {
    if (root == NULL)
        return 0;

    // Toggle the bit for this digit
    mask ^= (1 << root->val);

    // If leaf node, check the path
    if (root->left == NULL && root->right == NULL) {
        return canFormPalindrome(mask);
    }

    return countPaths(root->left, mask) +
           countPaths(root->right, mask);
}

// Build tree from heap-array format
Node* buildTree(int arr[], int n, int index) {
    if (index >= n || arr[index] == -1)
        return NULL;

    Node* root = createNode(arr[index]);

    root->left = buildTree(arr, n, 2 * index + 1);
    root->right = buildTree(arr, n, 2 * index + 2);

    return root;
}

// Free memory
void freeTree(Node* root) {
    if (root == NULL)
        return;

    freeTree(root->left);
    freeTree(root->right);
    free(root);
}

int main() {
    int n;

    printf("Enter number of nodes: ");
    scanf("%d", &n);

    int* arr = (int*)malloc(n * sizeof(int));

    printf("Enter tree elements (-1 for NULL): ");
    for (int i = 0; i < n; i++) {
        scanf("%d", &arr[i]);
    }

    Node* root = buildTree(arr, n, 0);

    int answer = countPaths(root, 0);

    printf("Number of valid root-to-leaf paths: %d\n", answer);

    freeTree(root);
    free(arr);

    return 0;
}
