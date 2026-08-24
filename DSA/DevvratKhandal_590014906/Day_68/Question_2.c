#include <stdio.h>
#include <stdlib.h>
#include <limits.h>

struct Node {
    int data;
    struct Node *left, *right;
};

struct Node* createNode(int data) {
    struct Node* newNode = (struct Node*)malloc(sizeof(struct Node));

    newNode->data = data;
    newNode->left = NULL;
    newNode->right = NULL;

    return newNode;
}

/* Information about a subtree */
struct Info {
    int isBST;
    int size;
    int min;
    int max;
};

int largestBST = 0;

struct Info checkBST(struct Node* root) {

    /* Empty subtree is a BST */
    if (root == NULL) {
        struct Info temp = {1, 0, INT_MAX, INT_MIN};
        return temp;
    }

    struct Info left = checkBST(root->left);
    struct Info right = checkBST(root->right);

    struct Info current;

    /*
       Check BST condition:
       left maximum < root < right minimum
    */
    if (left.isBST && right.isBST &&
        left.max < root->data &&
        root->data < right.min) {

        current.isBST = 1;
        current.size = left.size + right.size + 1;

        /* Minimum value */
        if (left.size == 0)
            current.min = root->data;
        else
            current.min = left.min;

        /* Maximum value */
        if (right.size == 0)
            current.max = root->data;
        else
            current.max = right.max;

        if (current.size > largestBST)
            largestBST = current.size;

    } else {
        current.isBST = 0;
        current.size = 0;
        current.min = INT_MIN;
        current.max = INT_MAX;
    }

    return current;
}

/* Build tree from level-order array */
struct Node* buildTree(int arr[], int n) {

    if (n == 0 || arr[0] == -1)
        return NULL;

    struct Node* nodes[1000];

    for (int i = 0; i < n; i++) {
        if (arr[i] == -1)
            nodes[i] = NULL;
        else
            nodes[i] = createNode(arr[i]);
    }

    for (int i = 0; i < n; i++) {

        if (nodes[i] == NULL)
            continue;

        int leftIndex = 2 * i + 1;
        int rightIndex = 2 * i + 2;

        if (leftIndex < n)
            nodes[i]->left = nodes[leftIndex];

        if (rightIndex < n)
            nodes[i]->right = nodes[rightIndex];
    }

    return nodes[0];
}

int main() {

    int t;

    printf("Enter number of test cases: ");
    scanf("%d", &t);

    while (t--) {

        int n;

        printf("Enter number of nodes: ");
        scanf("%d", &n);

        int arr[1000];

        printf("Enter level-order tree (-1 for NULL): ");
        for (int i = 0; i < n; i++) {
            scanf("%d", &arr[i]);
        }

        struct Node* root = buildTree(arr, n);

        largestBST = 0;

        checkBST(root);

        printf("Largest valid BST size: %d\n", largestBST);
    }

    return 0;
}