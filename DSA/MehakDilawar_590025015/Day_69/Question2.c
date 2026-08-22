//Write an efficient function that splits a binary search tree by a value K into two BSTs (values < K and values ≥ K), 
//returning the preorder traversal of each, or "EMPTY" if a branch has no nodes.
//Input: tree = [10, 5, 15, 2, 7, 12, 20], K = 10. Output: ["5 2 7", "10 15 12 20"].
#include <stdio.h>
#include <stdlib.h>

typedef struct Node {
    int data;
    struct Node *left;
    struct Node *right;
} Node;

Node* createNode(int data) {
    Node *newNode = (Node*)malloc(sizeof(Node));
    newNode->data = data;
    newNode->left = NULL;
    newNode->right = NULL;
    return newNode;
}

Node* insert(Node *root, int data) {
    if (root == NULL)
        return createNode(data);
    if (data < root->data)
        root->left = insert(root->left, data);
    else
        root->right = insert(root->right, data);
    return root;
}

void splitBST(Node *root, int K, Node **leftTree, Node **rightTree) {
    if (root == NULL) {
        *leftTree = NULL;
        *rightTree = NULL;
        return;
    }
    if (root->data < K) {
        *leftTree = root;
        splitBST(root->right, K,
                 &root->right, rightTree);
    }
    else {
        *rightTree = root;
        splitBST(root->left, K,
                 leftTree, &root->left);
    }
}

void preorder(Node *root, int *first) {
    if (root == NULL)
        return;
    if (!(*first))
        printf(" ");
    printf("%d", root->data);
    *first = 0;
    preorder(root->left, first);
    preorder(root->right, first);
}

void printTree(Node *root) {
    if (root == NULL) {
        printf("EMPTY");
        return;
    }
    int first = 1;
    preorder(root, &first);
}

int main() {
    Node *root = NULL;
    Node *less = NULL;
    Node *greaterEqual = NULL;
    int n, value, K;
    printf("Enter number of nodes: ");
    scanf("%d", &n);
    printf("Enter %d values: ", n);
    for (int i = 0; i < n; i++) {
        scanf("%d", &value);
        root = insert(root, value);
    }
    printf("Enter K: ");
    scanf("%d", &K);
    splitBST(root, K, &less, &greaterEqual);
    printf("\nValues < %d: ", K);
    printTree(less);
    printf("\nValues >= %d: ", K);
    printTree(greaterEqual);
    printf("\n");

return 0;
}