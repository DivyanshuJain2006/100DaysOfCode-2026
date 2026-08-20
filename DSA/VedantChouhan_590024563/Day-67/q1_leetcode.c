#include <stdio.h>
#include <stdlib.h>

struct TreeNode {
    int val;
    struct TreeNode *left;
    struct TreeNode *right;
};

struct TreeNode* createNode(int val) {
    struct TreeNode* node =
        (struct TreeNode*)malloc(sizeof(struct TreeNode));

    node->val = val;
    node->left = NULL;
    node->right = NULL;

    return node;
}

struct TreeNode* insert(struct TreeNode* root, int val) {

    if (root == NULL)
        return createNode(val);

    if (val < root->val)
        root->left = insert(root->left, val);
    else
        root->right = insert(root->right, val);

    return root;
}

/* Find the smallest node in a subtree */
struct TreeNode* findMin(struct TreeNode* root) {

    while (root->left != NULL)
        root = root->left;

    return root;
}

/* Delete a node from BST */
struct TreeNode* deleteNode(struct TreeNode* root, int key) {

    if (root == NULL)
        return NULL;

    /* Search for the key */
    if (key < root->val) {
        root->left = deleteNode(root->left, key);
    }
    else if (key > root->val) {
        root->right = deleteNode(root->right, key);
    }
    else {

        /* Case 1: No left child */
        if (root->left == NULL) {
            struct TreeNode* temp = root->right;
            free(root);
            return temp;
        }

        /* Case 2: No right child */
        if (root->right == NULL) {
            struct TreeNode* temp = root->left;
            free(root);
            return temp;
        }

        /* Case 3: Two children */
        struct TreeNode* temp = findMin(root->right);

        root->val = temp->val;

        root->right = deleteNode(root->right, temp->val);
    }

    return root;
}

void inorder(struct TreeNode* root) {

    if (root == NULL)
        return;

    inorder(root->left);
    printf("%d ", root->val);
    inorder(root->right);
}

int main() {

    struct TreeNode* root = NULL;

    int n;
    scanf("%d", &n);

    for (int i = 0; i < n; i++) {
        int value;
        scanf("%d", &value);
        root = insert(root, value);
    }

    int key;
    scanf("%d", &key);

    root = deleteNode(root, key);

    inorder(root);
    printf("\n");

    return 0;
}