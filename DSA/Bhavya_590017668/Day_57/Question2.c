#include <stdio.h>
#include <stdlib.h>

typedef struct TreeNode {
    int val;
    struct TreeNode *left, *right;
} TreeNode;

int mirror(TreeNode *a, TreeNode *b) {
    if (!a && !b) return 1;
    if (!a || !b || a->val != b->val) return 0;

    return mirror(a->left, b->right) &&
           mirror(a->right, b->left);
}

void printResult(TreeNode *a, TreeNode *b) {
    printf(mirror(a, b) ? "YES" : "NO");
}