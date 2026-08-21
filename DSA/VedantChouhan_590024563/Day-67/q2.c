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

/* Build height-balanced BST */
struct Node* buildBST(int arr[], int left, int right) {

    if (left > right)
        return NULL;

    // Left-middle element for even length
    int mid = (left + right) / 2;

    struct Node* root = createNode(arr[mid]);

    root->left = buildBST(arr, left, mid - 1);
    root->right = buildBST(arr, mid + 1, right);

    return root;
}

/* Returns height and counts balance factors */
int calculate(struct Node* root, int count[]) {

    if (root == NULL)
        return 0;

    int leftHeight = calculate(root->left, count);
    int rightHeight = calculate(root->right, count);

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

    struct Node* root = buildBST(arr, 0, n - 1);

   
    int count[3] = {0, 0, 0};

    calculate(root, count);

    printf("[%d, %d, %d]\n",
           count[0], count[1], count[2]);

    return 0;
}