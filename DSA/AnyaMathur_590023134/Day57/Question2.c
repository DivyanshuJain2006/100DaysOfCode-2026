// Problem 2 
// The Twin Warehouses

#include <stdio.h>
#include <stdlib.h>

struct Node {
    int data;
    struct Node *left;
    struct Node *right;
};

struct Node* createNode(int data) {
    struct Node *newNode = (struct Node*)malloc(sizeof(struct Node));
    newNode->data = data;
    newNode->left = NULL;
    newNode->right = NULL;
    return newNode;
}

struct Node* Tree(int a[], int i, int n) {
    if (i >= n || a[i] == -1)
        return NULL;
    struct Node *root = createNode(a[i]);
    root->left = Tree(a, 2 * i + 1, n);
    root->right = Tree(a, 2 * i + 2, n);
    return root;
}

int mirrorImage(struct Node *a, struct Node *b) {
    if (a == NULL && b == NULL)
        return 1;
    if (a == NULL || b == NULL)
        return 0;
    if (a->data != b->data)
        return 0;
    return mirrorImage(a->left, b->right) &&
           mirrorImage(a->right, b->left);
}

int main() {
    int t;
    printf("Enter number of test cases: ");
    scanf("%d", &t);
    while (t--) {
        int n1, n2;
        printf("Enter n1: ");
        scanf("%d", &n1);
        int a[n1];
        printf("Enter warehouse1: ");
        for (int i = 0; i < n1; i++)
            scanf("%d", &a[i]);
        printf("Enter n2: ");
        scanf("%d", &n2);
        int b[n2];
        printf("Enter warehouse2: ");
        for (int i = 0; i < n2; i++)
            scanf("%d", &b[i]);

        struct Node *root1 = Tree(a, 0, n1);
        struct Node *root2 = Tree(b, 0, n2);

        if (mirrorImage(root1, root2))
            printf("YES\n");
        else
            printf("NO\n");
    }

    return 0;
}