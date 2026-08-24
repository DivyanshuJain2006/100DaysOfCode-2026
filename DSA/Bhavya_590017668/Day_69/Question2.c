#include <stdio.h>
#include <stdlib.h>

struct TreeNode {
    int val;
    struct TreeNode *left;
    struct TreeNode *right;
};

/*
    Splits the BST into:
    leftTree  -> values < K
    rightTree -> values >= K
*/
void splitBST(struct TreeNode* root, int K,
              struct TreeNode** leftTree,
              struct TreeNode** rightTree) {

    if (root == NULL) {
        *leftTree = NULL;
        *rightTree = NULL;
        return;
    }

    if (root->val < K) {
        *leftTree = root;

        splitBST(root->right, K,
                 &root->right,
                 rightTree);
    }
    else {
        *rightTree = root;

        splitBST(root->left, K,
                 leftTree,
                 &root->left);
    }
}

/* Preorder traversal */
void preorder(struct TreeNode* root) {
    if (root == NULL)
        return;

    printf("%d ", root->val);
    preorder(root->left);
    preorder(root->right);
}

/* Print result */
void printTree(struct TreeNode* root) {
    if (root == NULL) {
        printf("EMPTY\n");
        return;
    }

    preorder(root);
    printf("\n");
}