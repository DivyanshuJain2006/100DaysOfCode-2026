#include <stdio.h>
#include <stdlib.h>

typedef struct Node
{
    int value;
    struct Node *left;
    struct Node *right;
} Node;

Node* buildTree(int arr[], int left, int right)
{
    if (left > right)
        return NULL;

    int mid = (left + right) / 2;

    Node *root = malloc(sizeof(Node));
    root->value = arr[mid];

    root->left = buildTree(arr, left, mid - 1);
    root->right = buildTree(arr, mid + 1, right);

    return root;
}

int heightAndCount(Node *root, int count[3])
{
    if (root == NULL)
        return 0;

    int leftHeight = heightAndCount(root->left, count);
    int rightHeight = heightAndCount(root->right, count);

    int balance = leftHeight - rightHeight;

    if (balance == -1)
        count[0]++;
    else if (balance == 0)
        count[1]++;
    else if (balance == 1)
        count[2]++;

    return 1 + (leftHeight > rightHeight ? leftHeight : rightHeight);
}

int main()
{
    int arr[] = {1, 2, 3, 4, 5, 6, 7};
    int n = sizeof(arr) / sizeof(arr[0]);

    Node *root = buildTree(arr, 0, n - 1);

    int count[3] = {0, 0, 0};

    heightAndCount(root, count);

    printf("[%d, %d, %d]\n", count[0], count[1], count[2]);

    return 0;
}