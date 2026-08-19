#include <stdio.h>
#include <stdlib.h>

struct TreeNode {
    int val;
    struct TreeNode* left;
    struct TreeNode* right;
};

struct TreeNode* createNode(int val) {
    struct TreeNode* newNode =
        (struct TreeNode*)malloc(sizeof(struct TreeNode));

    newNode->val = val;
    newNode->left = NULL;
    newNode->right = NULL;

    return newNode;
}

struct TreeNode* buildTree(int arr[], int n, int i) {
    if (i >= n || arr[i] == -1)
        return NULL;

    struct TreeNode* root = createNode(arr[i]);

    root->left = buildTree(arr, n, 2 * i + 1);
    root->right = buildTree(arr, n, 2 * i + 2);

    return root;
}

int countSafe(struct TreeNode* root, int maxValue) {
    if (root == NULL)
        return 0;

    int count = 0;

    // Current node is safe
    if (root->val >= maxValue)
        count = 1;

    // Update maximum value on the path
    if (root->val > maxValue)
        maxValue = root->val;

    count += countSafe(root->left, maxValue);
    count += countSafe(root->right, maxValue);

    return count;
}

int countSafeNodes(struct TreeNode* root) {
    if (root == NULL)
        return 0;

    return countSafe(root, root->val);
}

int main() {
    int n;
    scanf("%d", &n);

    int arr[n];

    for (int i = 0; i < n; i++)
        scanf("%d", &arr[i]);

    struct TreeNode* root = buildTree(arr, n, 0);

    printf("%d\n", countSafeNodes(root));

    return 0;
}
