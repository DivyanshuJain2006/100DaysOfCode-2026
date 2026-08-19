#include <stdio.h>
#include <stdlib.h>

struct TreeNode
{
    int val;
    struct TreeNode *left;
    struct TreeNode *right;
};

struct TreeNode* createNode(int value)
{
    struct TreeNode *node = malloc(sizeof(struct TreeNode));

    node->val = value;
    node->left = NULL;
    node->right = NULL;

    return node;
}

void inorder(struct TreeNode *root, int arr[], int *index)
{
    if (root == NULL)
        return;

    inorder(root->left, arr, index);
    arr[(*index)++] = root->val;
    inorder(root->right, arr, index);
}

int* getAllElements(struct TreeNode *root1,
                    struct TreeNode *root2,
                    int *returnSize)
{
    int a[10000], b[10000];
    int n1 = 0, n2 = 0;

    inorder(root1, a, &n1);
    inorder(root2, b, &n2);

    int *result = malloc((n1 + n2) * sizeof(int));

    int i = 0, j = 0, k = 0;

    while (i < n1 && j < n2)
    {
        int value;

        if (a[i] < b[j])
            value = a[i++];
        else if (b[j] < a[i])
            value = b[j++];
        else
        {
            value = a[i];
            i++;
            j++;
        }

        if (k == 0 || result[k - 1] != value)
            result[k++] = value;
    }

    while (i < n1)
    {
        if (k == 0 || result[k - 1] != a[i])
            result[k++] = a[i];

        i++;
    }

    while (j < n2)
    {
        if (k == 0 || result[k - 1] != b[j])
            result[k++] = b[j];

        j++;
    }

    *returnSize = k;
    return result;
}

int main()
{
    struct TreeNode *tree1 = createNode(2);
    tree1->left = createNode(1);
    tree1->right = createNode(3);

    struct TreeNode *tree2 = createNode(4);
    tree2->right = createNode(5);

    int size;
    int *result = getAllElements(tree1, tree2, &size);

    printf("[");
    for (int i = 0; i < size; i++)
    {
        printf("%d", result[i]);

        if (i < size - 1)
            printf(", ");
    }
    printf("]\n");

    free(result);

    return 0;
}