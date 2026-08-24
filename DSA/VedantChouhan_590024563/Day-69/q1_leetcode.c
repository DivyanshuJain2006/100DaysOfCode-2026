#include <stdio.h>
#include <stdlib.h>
#include <limits.h>

struct Node {
    int val;
    struct Node *left;
    struct Node *right;
};

struct Node* createNode(int val) {
    struct Node* node =
        (struct Node*)malloc(sizeof(struct Node));

    node->val = val;
    node->left = NULL;
    node->right = NULL;

    return node;
}

/* Build BST from preorder */
struct Node* buildBST(int preorder[], int *index, int n,
                      int min, int max) {

    if (*index >= n)
        return NULL;

    int value = preorder[*index];

    if (value <= min || value >= max)
        return NULL;

    struct Node* root = createNode(value);

    (*index)++;

    root->left = buildBST(preorder, index, n,
                          min, value);

    root->right = buildBST(preorder, index, n,
                           value, max);

    return root;
}

/* Inorder traversal to check the BST */
void inorder(struct Node* root) {

    if (root == NULL)
        return;

    inorder(root->left);

    printf("%d ", root->val);

    inorder(root->right);
}

int main() {

    int n;

    printf("Enter number of elements: ");
    scanf("%d", &n);

    int preorder[n];

    printf("Enter preorder traversal: ");

    for (int i = 0; i < n; i++) {
        scanf("%d", &preorder[i]);
    }

    int index = 0;

    struct Node* root =
        buildBST(preorder, &index, n,
                 INT_MIN, INT_MAX);

    printf("Inorder traversal of BST: ");

    inorder(root);

    printf("\n");

    return 0;
}