#include <stdio.h>
#include <stdlib.h>

typedef struct Node
{
    long long data;
    struct Node *left;
    struct Node *right;
} Node;

Node* createNode(long long value)
{
    Node *newNode = (Node *)malloc(sizeof(Node));

    newNode->data = value;
    newNode->left = NULL;
    newNode->right = NULL;

    return newNode;
}

Node* buildTree(long long tree[], int n, int index)
{
    if (index >= n || tree[index] == -1)
        return NULL;

    Node *root = createNode(tree[index]);

    root->left = buildTree(tree, n, 2 * index + 1);
    root->right = buildTree(tree, n, 2 * index + 2);

    return root;
}

int exists(Node *root, long long value)
{
    if (root == NULL)
        return 0;

    if (root->data == value)
        return 1;

    return exists(root->left, value) ||
           exists(root->right, value);
}

Node* findLCA(Node *root, long long a, long long b)
{
    if (root == NULL)
        return NULL;

    if (root->data == a || root->data == b)
        return root;

    Node *leftLCA = findLCA(root->left, a, b);
    Node *rightLCA = findLCA(root->right, a, b);

    if (leftLCA != NULL && rightLCA != NULL)
        return root;

    if (leftLCA != NULL)
        return leftLCA;

    return rightLCA;
}

void freeTree(Node *root)
{
    if (root == NULL)
        return;

    freeTree(root->left);
    freeTree(root->right);

    free(root);
}

int main()
{
    int t;
    scanf("%d", &t);

    while (t--)
    {
        int n;
        scanf("%d", &n);

        long long tree[1000];

        for (int i = 0; i < n; i++)
        {
            scanf("%lld", &tree[i]);
        }

        long long a, b;
        scanf("%lld %lld", &a, &b);

        Node *root = buildTree(tree, n, 0);

        if (!exists(root, a) || !exists(root, b))
        {
            printf("-1\n");
        }
        else
        {
            Node *lca = findLCA(root, a, b);

            if (lca != NULL)
                printf("%lld\n", lca->data);
            else
                printf("-1\n");
        }

        freeTree(root);
    }

    return 0;
}
