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
    Node *node = malloc(sizeof(Node));

    node->val = value;
    node->left = NULL;
    node->right = NULL;

    return node;
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

void robTree(Node *root, int result[2])
{
    if (root == NULL)
    {
        result[0] = 0;
        result[1] = 0;
        return;
    }

    int left[2];
    int right[2];

    robTree(root->left, left);
    robTree(root->right, right);

    result[0] = (left[0] > left[1] ? left[0] : left[1])
              + (right[0] > right[1] ? right[0] : right[1]);

    result[1] = root->val + left[0] + right[0];
}

int rob(Node *root)
{
    int result[2];

    robTree(root, result);

    return result[0] > result[1] ? result[0] : result[1];
}

int main()
{
    int tree[] = {3, 2, 3, -1, 3, -1, 1};
    int n = sizeof(tree) / sizeof(tree[0]);

    Node *root = buildTree(tree, n, 0);

    printf("Maximum Money: %d\n", rob(root));

    return 0;
}