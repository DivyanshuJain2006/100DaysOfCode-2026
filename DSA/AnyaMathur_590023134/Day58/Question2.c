// Problem 2 
// The Dispute Resolution

#include <stdio.h>
#include <stdlib.h>

struct TreeNode {
    int data;
    struct TreeNode *left;
    struct TreeNode *right;
};

struct TreeNode* createTree(int tree[], int n, int index) {
    if (index >= n || tree[index] == -1)
        return NULL;
    struct TreeNode* newNode = (struct TreeNode*)malloc(sizeof(struct TreeNode));
    newNode->data = tree[index];
    newNode->left = createTree(tree, n, 2 * index + 1);
    newNode->right = createTree(tree, n, 2 * index + 2);
    return newNode;
}

int findNode(struct TreeNode* root, int value) {
    if (root == NULL)
        return 0;
    if (root->data == value)
        return 1;
    int left = findNode(root->left, value);
    int right = findNode(root->right, value);
    return left || right;
}

struct TreeNode* LCA(struct TreeNode* root, int a, int b) {
    if (root == NULL)
        return NULL;
    if (root->data == a || root->data == b)
        return root;
    struct TreeNode* left = LCA(root->left, a, b);
    struct TreeNode* right = LCA(root->right, a, b);
    if (left != NULL && right != NULL)
        return root;
    if (left != NULL)
        return left;
    return right;
}

int main() {
    int t;
    printf("Enter number of test cases: ");
    scanf("%d", &t);

    while (t--) {
        int n;
        printf("Enter size of tree: ");
        scanf("%d", &n);

        int tree[n];
        printf("Enter tree elements: ");
        for (int i = 0; i < n; i++)
            scanf("%d", &tree[i]);

        int a, b;
        printf("Enter two employee IDs: ");
        scanf("%d %d", &a, &b);

        struct TreeNode* root = createTree(tree, n, 0);

        int checkA = findNode(root, a);
        int checkB = findNode(root, b);
        if (checkA == 0 || checkB == 0) {
            printf("-1\n");
        }
        else {
            struct TreeNode* answer = LCA(root, a, b);
            if (answer != NULL)
                printf("%d\n", answer->data);
            else
                printf("-1\n");
        }
    }
    return 0;
}