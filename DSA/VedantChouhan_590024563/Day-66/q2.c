#include <stdio.h>
#include <stdlib.h>

#define MAX 2000

struct TreeNode {
    int val;
    struct TreeNode* left;
    struct TreeNode* right;
};

struct TreeNode* createNode(int val) {
    struct TreeNode* node =
        (struct TreeNode*)malloc(sizeof(struct TreeNode));

    node->val = val;
    node->left = NULL;
    node->right = NULL;

    return node;
}

/* Insert into BST */
struct TreeNode* insert(struct TreeNode* root, int val) {

    if (root == NULL)
        return createNode(val);

    if (val < root->val)
        root->left = insert(root->left, val);
    else
        root->right = insert(root->right, val);

    return root;
}

/* Inorder traversal */
void inorder(struct TreeNode* root, int arr[], int* size) {

    if (root == NULL)
        return;

    inorder(root->left, arr, size);

    arr[(*size)++] = root->val;

    inorder(root->right, arr, size);
}

/* Merge two sorted arrays and remove duplicates */
int mergeArrays(int a[], int n1, int b[], int n2, int result[]) {

    int i = 0;
    int j = 0;
    int k = 0;

    while (i < n1 && j < n2) {

        if (a[i] < b[j]) {
            result[k++] = a[i++];
        }
        else if (b[j] < a[i]) {
            result[k++] = b[j++];
        }
        else {
            // Same value in both trees
            result[k++] = a[i];
            i++;
            j++;
        }
    }

    while (i < n1) {
        result[k++] = a[i++];
    }

    while (j < n2) {
        result[k++] = b[j++];
    }

    return k;
}

int main() {

    int t;
    scanf("%d", &t);

    while (t--) {

        int n1, n2;

        scanf("%d", &n1);

        struct TreeNode* root1 = NULL;

        /*
         * Input is level-order, but for a BST we can
         * insert the values one by one to construct it.
         */
        for (int i = 0; i < n1; i++) {
            int value;
            scanf("%d", &value);

            if (value != -1)
                root1 = insert(root1, value);
        }

        scanf("%d", &n2);

        struct TreeNode* root2 = NULL;

        for (int i = 0; i < n2; i++) {
            int value;
            scanf("%d", &value);

            if (value != -1)
                root2 = insert(root2, value);
        }

        int arr1[MAX];
        int arr2[MAX];
        int result[MAX];

        int size1 = 0;
        int size2 = 0;

        inorder(root1, arr1, &size1);
        inorder(root2, arr2, &size2);

        int resultSize =
            mergeArrays(arr1, size1, arr2, size2, result);

        for (int i = 0; i < resultSize; i++) {
            printf("%d", result[i]);

            if (i < resultSize - 1)
                printf(" ");
        }

        printf("\n");
    }

    return 0;
}