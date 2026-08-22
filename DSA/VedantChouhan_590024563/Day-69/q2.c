#include <stdio.h>
#include <stdlib.h>

struct Node {
    int val;
    struct Node *left;
    struct Node *right;
};

struct Node* createNode(int val) {
    struct Node* node = (struct Node*)malloc(sizeof(struct Node));
    node->val = val;
    node->left = NULL;
    node->right = NULL;
    return node;
}

/* Insert into BST */
struct Node* insert(struct Node* root, int val) {
    if (root == NULL)
        return createNode(val);

    if (val < root->val)
        root->left = insert(root->left, val);
    else
        root->right = insert(root->right, val);

    return root;
}

/* Print preorder traversal */
void preorder(struct Node* root) {
    if (root == NULL)
        return;

    printf("%d ", root->val);
    preorder(root->left);
    preorder(root->right);
}

/* Split BST into values < K and values >= K */
void splitBST(struct Node* root, int k,
              struct Node** smaller,
              struct Node** greaterEqual) {

    if (root == NULL) {
        *smaller = NULL;
        *greaterEqual = NULL;
        return;
    }

    if (root->val < k) {
        *smaller = root;

        splitBST(root->right, k,
                 &((*smaller)->right),
                 greaterEqual);
    }
    else {
        *greaterEqual = root;

        splitBST(root->left, k,
                 smaller,
                 &((*greaterEqual)->left));
    }
}

int main() {
    int n, k;

    printf("Enter number of nodes: ");
    scanf("%d", &n);

    int values[n];

    printf("Enter BST values: ");
    for (int i = 0; i < n; i++)
        scanf("%d", &values[i]);

    printf("Enter K: ");
    scanf("%d", &k);

    struct Node* root = NULL;

    for (int i = 0; i < n; i++)
        root = insert(root, values[i]);

    struct Node* smaller = NULL;
    struct Node* greaterEqual = NULL;

    splitBST(root, k, &smaller, &greaterEqual);

    printf("Values < K: ");

    if (smaller == NULL)
        printf("EMPTY");
    else
        preorder(smaller);

    printf("\n");

    printf("Values >= K: ");

    if (greaterEqual == NULL)
        printf("EMPTY");
    else
        preorder(greaterEqual);

    printf("\n");

    return 0;
}