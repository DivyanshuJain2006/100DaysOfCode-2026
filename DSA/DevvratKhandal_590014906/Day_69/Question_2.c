#include <stdio.h>
#include <stdlib.h>

struct Node {
    int data;
    struct Node *left;
    struct Node *right;
};

struct Node* createNode(int value) {
    struct Node* newNode = (struct Node*)malloc(sizeof(struct Node));
    newNode->data = value;
    newNode->left = NULL;
    newNode->right = NULL;
    return newNode;
}

/* Build tree from level-order array */
struct Node* buildTree(int tree[], int n) {
    if (n == 0 || tree[0] == -1)
        return NULL;

    struct Node* nodes[n];

    for (int i = 0; i < n; i++) {
        if (tree[i] == -1)
            nodes[i] = NULL;
        else
            nodes[i] = createNode(tree[i]);
    }

    int child = 1;

    for (int i = 0; i < n && child < n; i++) {
        if (nodes[i] != NULL) {

            if (child < n)
                nodes[i]->left = nodes[child++];

            if (child < n)
                nodes[i]->right = nodes[child++];
        }
    }

    return nodes[0];
}

/*
   Split the BST into two BSTs:

   leftTree  -> values < K
   rightTree -> values >= K
*/
void splitBST(struct Node* root, int K,
              struct Node** leftTree,
              struct Node** rightTree) {

    if (root == NULL) {
        *leftTree = NULL;
        *rightTree = NULL;
        return;
    }

    if (root->data < K) {

        *leftTree = root;

        splitBST(root->right, K,
                 &root->right,
                 rightTree);

    } else {

        *rightTree = root;

        splitBST(root->left, K,
                 leftTree,
                 &root->left);
    }
}

/* Preorder traversal */
void preorder(struct Node* root) {
    if (root == NULL)
        return;

    printf("%d ", root->data);
    preorder(root->left);
    preorder(root->right);
}

int main() {
    int n, K;

    printf("Enter number of nodes: ");
    scanf("%d", &n);

    int tree[n];

    printf("Enter level-order tree (-1 for NULL): ");
    for (int i = 0; i < n; i++) {
        scanf("%d", &tree[i]);
    }

    printf("Enter K: ");
    scanf("%d", &K);

    struct Node* root = buildTree(tree, n);

    struct Node* branchA;
    struct Node* branchB;

    splitBST(root, K, &branchA, &branchB);

    printf("Branch A (< K): ");
    if (branchA == NULL)
        printf("EMPTY");
    else
        preorder(branchA);

    printf("\n");

    printf("Branch B (>= K): ");
    if (branchB == NULL)
        printf("EMPTY");
    else
        preorder(branchB);

    return 0;
}