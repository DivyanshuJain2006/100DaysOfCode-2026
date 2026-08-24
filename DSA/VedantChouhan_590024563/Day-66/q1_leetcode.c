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

struct TreeNode* insertIntoBST(struct TreeNode* root, int val) {

    if (root == NULL) {
        return createNode(val);
    }

    if (val < root->val) {
        root->left = insertIntoBST(root->left, val);
    }
    else {
        root->right = insertIntoBST(root->right, val);
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

    printf("Enter number of nodes: ");
    scanf("%d", &n);

    printf("Enter BST values: ");

    for (int i = 0; i < n; i++) {
        int value;
        scanf("%d", &value);

        root = insertIntoBST(root, value);
    }

    int val;

    printf("Enter value to insert: ");
    scanf("%d", &val);

    root = insertIntoBST(root, val);

    printf("BST after insertion: ");
    inorder(root);

    printf("\n");

    return 0;
}