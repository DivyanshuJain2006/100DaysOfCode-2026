    #include <stdio.h>
#include <stdlib.h>

typedef struct Node
{
    int val;
    struct Node *left;
    struct Node *right;
} Node;

Node* createNode(int value)
{
    Node *newNode = malloc(sizeof(Node));

    newNode->val = value;
    newNode->left = NULL;
    newNode->right = NULL;

    return newNode;
}

Node* buildTree(int tree[], int n, int index)
{
    if (index >= n || tree[index] == -1)
        return NULL;

    Node *root = createNode(tree[index]);

    root->left = buildTree(tree, n, 2 * index + 1);
    root->right = buildTree(tree, n, 2 * index + 2);

    return root;
}

int countSafe(Node *root, int maxValue)
{
    if (root == NULL)
        return 0;

    int count = 0;

    if (root->val >= maxValue)
        count = 1;

    if (root->val > maxValue)
        maxValue = root->val;

    count += countSafe(root->left, maxValue);
    count += countSafe(root->right, maxValue);

    return count;
}

int main()
{
    int tree[] = {3, 1, 4, 3, -1, 1, 5};
    int n = 7;

    Node *root = buildTree(tree, n, 0);

    int result = countSafe(root, root->val);

    printf("Safe Campsites: %d\n", result);

    return 0;
}