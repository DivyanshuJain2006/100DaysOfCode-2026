#include <stdio.h>
#include <stdlib.h>

struct Node {
    int data;
    struct Node *left;
    struct Node *right;
};

struct Node* createNode(int data) {
    struct Node* node = malloc(sizeof(struct Node));

    node->data = data;
    node->left = NULL;
    node->right = NULL;

    return node;
}

struct Node* buildTree(int arr[], int n) {

    if (n == 0 || arr[0] == -1)
        return NULL;

    struct Node* root = createNode(arr[0]);

    struct Node** queue = malloc(n * sizeof(struct Node*));

    int front = 0;
    int rear = 0;

    queue[rear++] = root;

    int i = 1;

    while (i < n && front < rear) {

        struct Node* current = queue[front++];

        if (i < n && arr[i] != -1) {
            current->left = createNode(arr[i]);
            queue[rear++] = current->left;
        }
        i++;

        if (i < n && arr[i] != -1) {
            current->right = createNode(arr[i]);
            queue[rear++] = current->right;
        }
        i++;
    }

    free(queue);

    return root;
}

int exists(struct Node* root, int x) {

    if (root == NULL)
        return 0;

    if (root->data == x)
        return 1;

    return exists(root->left, x) ||
           exists(root->right, x);
}

struct Node* LCA(struct Node* root, int a, int b) {

    if (root == NULL)
        return NULL;

    if (root->data == a || root->data == b)
        return root;

    struct Node* left = LCA(root->left, a, b);
    struct Node* right = LCA(root->right, a, b);

    if (left != NULL && right != NULL)
        return root;

    if (left != NULL)
        return left;

    return right;
}

int main() {

    int n;
    printf("Enter number of nodes: ");
    scanf("%d", &n);

    int arr[n];
    printf("Enter tree (use -1 for NULL): ");

    for (int i = 0; i < n; i++)
        scanf("%d", &arr[i]);

    int a, b;
    printf("Enter a: ");
    scanf("%d", &a);

    printf("Enter b: ");
    scanf("%d", &b);


    struct Node* root = buildTree(arr, n);

    // Check whether both employees exist
    if (!exists(root, a) || !exists(root, b)) {
        printf("-1");
        return 0;
    }

    struct Node* ancestor = LCA(root, a, b);

    if (ancestor != NULL)
        printf("%d", ancestor->data);
    else
        printf("-1");

    return 0;

}
