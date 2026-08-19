//Write an efficient function that returns the value of the Lowest Common Ancestor of two given room numbers in a binary search tree.
//Input: tree = [6, 2, 8, 0, 4, 7, 9], a = 2, b = 8. Output: 6.
#include <stdio.h>
#include <stdlib.h>

struct Node {
    int data;
    struct Node *left;
    struct Node *right;
};

struct Node* createNode(int data) {
    struct Node* node = (struct Node*)malloc(sizeof(struct Node));
    node->data = data;
    node->left = node->right = NULL;
    return node;
}

struct Node* insert(struct Node* root, int data) {
    if (root == NULL)
        return createNode(data);
    if (data < root->data)
        root->left = insert(root->left, data);
    else
        root->right = insert(root->right, data);
    return root;
}

int findLCA(struct Node* root, int a, int b) {
    while (root != NULL) {
        if (a < root->data && b < root->data) {
            root = root->left;
        }
        else if (a > root->data && b > root->data) {
            root = root->right;
        }
        else {
            return root->data;
        }
    }
    return -1; 
}

int main() {
    struct Node* root = NULL;
    int n, value, a, b;
    printf("Enter number of nodes: ");
    scanf("%d", &n);
    printf("Enter %d room numbers: ", n);
    for (int i = 0; i < n; i++) {
        scanf("%d", &value);
        root = insert(root, value);
    }
    printf("Enter two room numbers: ");
    scanf("%d %d", &a, &b);
    int lca = findLCA(root, a, b);
    if (lca != -1)
        printf("Lowest Common Ancestor = %d\n", lca);
    else
        printf("Lowest Common Ancestor not found.\n");

    return 0;
}