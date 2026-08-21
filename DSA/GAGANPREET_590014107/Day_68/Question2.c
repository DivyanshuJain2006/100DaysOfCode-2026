#include <stdio.h>
#include <stdlib.h>
#include <limits.h>

typedef struct TreeNode {
    int val;
    struct TreeNode *left;
    struct TreeNode *right;
} TreeNode;

typedef struct {
    int isBST;
    int size;
    int min;
    int max;
} Info;

// Create a new node
TreeNode* createNode(int val) {
    TreeNode* newNode = (TreeNode*)malloc(sizeof(TreeNode));
    newNode->val = val;
    newNode->left = NULL;
    newNode->right = NULL;
    return newNode;
}

// Build tree from level-order input
TreeNode* buildTree(int arr[], int n) {
    if (n == 0 || arr[0] == -1)
        return NULL;

    TreeNode** queue = (TreeNode**)malloc(n * sizeof(TreeNode*));

    TreeNode* root = createNode(arr[0]);

    int front = 0, rear = 0;
    queue[rear++] = root;

    int i = 1;

    while (i < n) {
        TreeNode* current = queue[front++];

        // Left child
        if (i < n && arr[i] != -1) {
            current->left = createNode(arr[i]);
            queue[rear++] = current->left;
        }
        i++;

        // Right child
        if (i < n && arr[i] != -1) {
            current->right = createNode(arr[i]);
            queue[rear++] = current->right;
        }
        i++;
    }

    free(queue);
    return root;
}

// Find largest BST subtree
Info largestBST(TreeNode* root, int* answer) {

    // Empty tree is a BST
    if (root == NULL) {
        Info temp = {1, 0, INT_MAX, INT_MIN};
        return temp;
    }

    Info left = largestBST(root->left, answer);
    Info right = largestBST(root->right, answer);

    Info current;

    // Check if current subtree is BST
    if (left.isBST &&
        right.isBST &&
        root->val > left.max &&
        root->val < right.min) {

        current.isBST = 1;

        current.size = left.size + right.size + 1;

        current.min = (root->left != NULL)
                        ? left.min
                        : root->val;

        current.max = (root->right != NULL)
                        ? right.max
                        : root->val;

        if (current.size > *answer)
            *answer = current.size;

    } else {
        current.isBST = 0;
        current.size = 0;
        current.min = INT_MIN;
        current.max = INT_MAX;
    }

    return current;
}

// Main function
int main() {

    int n;

    printf("Enter number of nodes: ");
    scanf("%d", &n);

    int* arr = (int*)malloc(n * sizeof(int));

    printf("Enter level-order traversal (-1 for NULL):\n");

    for (int i = 0; i < n; i++) {
        scanf("%d", &arr[i]);
    }

    TreeNode* root = buildTree(arr, n);

    int answer = 0;

    largestBST(root, &answer);

    printf("Largest BST subtree size = %d\n", answer);

    free(arr);

    return 0;
}
