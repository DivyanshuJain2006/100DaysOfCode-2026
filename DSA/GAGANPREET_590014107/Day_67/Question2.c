#include <stdio.h>
#include <stdlib.h>

typedef struct Node {
    int val;
    struct Node *left;
    struct Node *right;
} Node;

int count[3];   // count[0] = -1, count[1] = 0, count[2] = +1

Node* createNode(int val) {
    Node* node = (Node*)malloc(sizeof(Node));

    node->val = val;
    node->left = NULL;
    node->right = NULL;

    return node;
}

Node* buildBST(int arr[], int left, int right) {
    if (left > right)
        return NULL;

    // Left-middle for even length
    int mid = (left + right) / 2;

    Node* root = createNode(arr[mid]);

    root->left = buildBST(arr, left, mid - 1);
    root->right = buildBST(arr, mid + 1, right);

    return root;
}

int heightAndCount(Node* root) {
    if (root == NULL)
        return 0;

    int leftHeight = heightAndCount(root->left);
    int rightHeight = heightAndCount(root->right);

    int balance = leftHeight - rightHeight;

    if (balance == -1)
        count[0]++;
    else if (balance == 0)
        count[1]++;
    else if (balance == 1)
        count[2]++;

    return 1 + (leftHeight > rightHeight ? leftHeight : rightHeight);
}

int main() {
    int n;
    scanf("%d", &n);

    int arr[n];

    for (int i = 0; i < n; i++)
        scanf("%d", &arr[i]);

    Node* root = buildBST(arr, 0, n - 1);

    heightAndCount(root);

    printf("[%d, %d, %d]", count[0], count[1], count[2]);

    return 0;
}
