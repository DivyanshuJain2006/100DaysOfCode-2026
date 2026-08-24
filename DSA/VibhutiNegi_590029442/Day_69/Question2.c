#include <stdio.h>
#include <stdlib.h>
struct Node {
    int data;
    struct Node* left;
    struct Node* right;
};
void splitBST(struct Node* root, int K,
              struct Node** A, struct Node** B) {
    if (root == NULL) {
        *A = NULL;
        *B = NULL;
        return;
    }
    if (root->data < K) {
        *A = root;
        splitBST(root->right, K, &root->right, B);
    }
    else {
        *B = root;
        splitBST(root->left, K, A, &root->left);
    }
}
void preorder(struct Node* root) {
    if (root == NULL)
        return;
    printf("%d ", root->data);
    preorder(root->left);
    preorder(root->right);
}