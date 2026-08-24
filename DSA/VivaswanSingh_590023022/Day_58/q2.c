#include <stdio.h>
#include <stdlib.h>

struct TreeNode
{
    int val;
    struct TreeNode *left;
    struct TreeNode *right;
};

struct TreeNode* newNode(int value)
{
    struct TreeNode* node = malloc(sizeof(struct TreeNode));

    node->val = value;
    node->left = NULL;
    node->right = NULL;

    return node;
}

struct TreeNode* buildTree(int tree[], int n)
{
    if (n == 0 || tree[0] == -1)
        return NULL;

    struct TreeNode* nodes[n];
    int count = 0;

    for (int i = 0; i < n; i++)
    {
        if (tree[i] == -1)
            nodes[i] = NULL;
        else
            nodes[i] = newNode(tree[i]);
    }

    for (int i = 0; i < n; i++)
    {
        if (nodes[i] != NULL)
        {
            int left = 2 * i + 1;
            int right = 2 * i + 2;

            if (left < n)
                nodes[i]->left = nodes[left];

            if (right < n)
                nodes[i]->right = nodes[right];
        }
    }

    return nodes[0];
}

int contains(struct TreeNode* root, int value)
{
    if (root == NULL)
        return 0;

    if (root->val == value)
        return 1;

    return contains(root->left, value) ||
           contains(root->right, value);
}

struct TreeNode* findLCA(struct TreeNode* root, int a, int b)
{
    if (root == NULL)
        return NULL;

    if (root->val == a || root->val == b)
        return root;

    struct TreeNode* left = findLCA(root->left, a, b);
    struct TreeNode* right = findLCA(root->right, a, b);

    if (left != NULL && right != NULL)
        return root;

    if (left != NULL)
        return left;

    return right;
}

int lowestCommonAncestor(int tree[], int n, int a, int b)
{
    struct TreeNode* root = buildTree(tree, n);

    if (!contains(root, a) || !contains(root, b))
        return -1;

    struct TreeNode* lca = findLCA(root, a, b);

    if (lca == NULL)
        return -1;

    return lca->val;
}

int main()
{
    int tree[] = {
        3, 5, 1, 6, 2, 0, 8,
        -1, -1, 7, 4
    };

    int n = sizeof(tree) / sizeof(tree[0]);

    int a = 5;
    int b = 1;

    printf("%d\n", lowestCommonAncestor(tree, n, a, b));

    return 0;
}