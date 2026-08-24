//Write an efficient function that determines whether two binary trees (given in level-order representation, with -1 for missing children)
//are mirror images of each other, printing "YES" or "NO".
//Input: warehouse1 = [1, 2, 3], warehouse2 = [1, 3, 2]. Output: "YES".
#include <stdio.h>
#include <stdlib.h>

typedef struct TreeNode {
    int val;
    struct TreeNode *left;
    struct TreeNode *right;
} TreeNode;

TreeNode* buildTree(int arr[], int n, int index) {
    if (index >= n || arr[index] == -1)
        return NULL;
    TreeNode *root = (TreeNode *)malloc(sizeof(TreeNode));
    root->val = arr[index];
    root->left = buildTree(arr, n, 2 * index + 1);
    root->right = buildTree(arr, n, 2 * index + 2);
    return root;
}

int areMirror(TreeNode *a, TreeNode *b) {
    if (a == NULL && b == NULL)
        return 1;
    if (a == NULL || b == NULL)
        return 0;
    return (a->val == b->val) &&
           areMirror(a->left, b->right) &&
           areMirror(a->right, b->left);
}

int main() {
    int n, m;
    scanf("%d", &n);
    int *arr1 = malloc(n * sizeof(int));
    for (int i = 0; i < n; i++)
        scanf("%d", &arr1[i]);
    scanf("%d", &m);
    int *arr2 = malloc(m * sizeof(int));
    for (int i = 0; i < m; i++)
        scanf("%d", &arr2[i]);
    TreeNode *root1 = buildTree(arr1, n, 0);
    TreeNode *root2 = buildTree(arr2, m, 0);
    if (areMirror(root1, root2))
        printf("YES\n");
    else
        printf("NO\n");
    free(arr1);
    free(arr2);
return 0;
}