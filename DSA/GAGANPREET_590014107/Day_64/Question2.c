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

// Insert into BST
struct TreeNode* insert(struct TreeNode* root, int val) {
    if (root == NULL)
        return createNode(val);

    if (val < root->val)
        root->left = insert(root->left, val);
    else
        root->right = insert(root->right, val);

    return root;
}

// Find LCA in BST
struct TreeNode* lowestCommonAncestor(
    struct TreeNode* root,
    int a,
    int b) {

    if (root == NULL)
        return NULL;

    // Both values are smaller than root
    if (a < root->val && b < root->val)
        return lowestCommonAncestor(root->left, a, b);

    // Both values are greater than root
    if (a > root->val && b > root->val)
        return lowestCommonAncestor(root->right, a, b);

    // Values are on different sides,
    // or root is one of the values
    return root;
}

int main() {
    int n;
    scanf("%d", &n);

    struct TreeNode* root = NULL;

    for (int i = 0; i < n; i++) {
        int x;
        scanf("%d", &x);
        root = insert(root, x);
    }

    int a, b;
    scanf("%d %d", &a, &b);

    struct TreeNode* lca =
        lowestCommonAncestor(root, a, b);

    printf("%d\n", lca->val);

    return 0;
}
