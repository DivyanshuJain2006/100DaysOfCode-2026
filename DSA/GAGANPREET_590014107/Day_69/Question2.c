#include <stdio.h>
#include <stdlib.h>

struct Node {
    int data;
    struct Node* left;
    struct Node* right;
};

struct Node* createNode(int data) {
    struct Node* node = (struct Node*)malloc(sizeof(struct Node));

    node->data = data;
    node->left = NULL;
    node->right = NULL;

    return node;
}

// Insert into BST
struct Node* insert(struct Node* root, int data) {
    if (root == NULL)
        return createNode(data);

    if (data < root->data)
        root->left = insert(root->left, data);
    else
        root->right = insert(root->right, data);

    return root;
}

// Print preorder traversal
void preorder(struct Node* root, int* first) {
    if (root == NULL)
        return;

    if (!(*first))
        printf(" ");

    printf("%d", root->data);
    *first = 0;

    preorder(root->left, first);
    preorder(root->right, first);
}

// Split BST into two BSTs
void splitBST(struct Node* root, int k,
              struct Node** smaller,
              struct Node** greaterEqual) {

    if (root == NULL)
        return;

    if (root->data < k) {
        // Current node belongs to smaller tree
        *smaller = insert(*smaller, root->data);

        splitBST(root->left, k, smaller, greaterEqual);
        splitBST(root->right, k, smaller, greaterEqual);
    }
    else {
        // Current node belongs to greater/equal tree
        *greaterEqual = insert(*greaterEqual, root->data);

        splitBST(root->left, k, smaller, greaterEqual);
        splitBST(root->right, k, smaller, greaterEqual);
    }
}

int main() {
    int n, k;

    scanf("%d", &n);

    struct Node* root = NULL;

    for (int i = 0; i < n; i++) {
        int value;
        scanf("%d", &value);
        root = insert(root, value);
    }

    scanf("%d", &k);

    struct Node* smaller = NULL;
    struct Node* greaterEqual = NULL;

    splitBST(root, k, &smaller, &greaterEqual);

    // First BST: values < K
    if (smaller == NULL) {
        printf("EMPTY\n");
    } else {
        int first = 1;
        preorder(smaller, &first);
        printf("\n");
    }

    // Second BST: values >= K
    if (greaterEqual == NULL) {
        printf("EMPTY\n");
    } else {
        int first = 1;
        preorder(greaterEqual, &first);
        printf("\n");
    }

    return 0;
}
