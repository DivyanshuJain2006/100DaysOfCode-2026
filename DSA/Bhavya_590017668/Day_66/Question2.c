#include <stdio.h>
#include <stdlib.h>

void inorder(struct TreeNode* root, int* arr, int* index) {
    if (root == NULL)
        return;

    inorder(root->left, arr, index);
    arr[(*index)++] = root->val;
    inorder(root->right, arr, index);
}

int* getAllElements(struct TreeNode* root1, struct TreeNode* root2, int* returnSize) {
    int* a = malloc(10000 * sizeof(int));
    int* b = malloc(10000 * sizeof(int));
    int* result = malloc(20000 * sizeof(int));

    int n1 = 0, n2 = 0, k = 0;

    inorder(root1, a, &n1);
    inorder(root2, b, &n2);

    int i = 0, j = 0;

    while (i < n1 && j < n2) {
        if (a[i] < b[j])
            result[k++] = a[i++];
        else if (b[j] < a[i])
            result[k++] = b[j++];
        else {
            result[k++] = a[i++];
            j++;
        }
    }

    while (i < n1)
        result[k++] = a[i++];

    while (j < n2)
        result[k++] = b[j++];

    free(a);
    free(b);

    *returnSize = k;
    return result;
}