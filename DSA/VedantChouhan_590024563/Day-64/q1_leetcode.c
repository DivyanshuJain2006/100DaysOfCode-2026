#include <stdio.h>
#include <stdlib.h>

struct TreeNode {
    int val;
    struct TreeNode *left;
    struct TreeNode *right;
};

struct TreeNode* createNode(int value) {

    struct TreeNode* node =
        (struct TreeNode*)malloc(sizeof(struct TreeNode));

    node->val = value;
    node->left = NULL;
    node->right = NULL;

    return node;
}

int rangeSumBST(struct TreeNode* root, int low, int high) {

    if (root == NULL)
        return 0;

    // Value is inside the range
    if (root->val >= low && root->val <= high) {

        return root->val
             + rangeSumBST(root->left, low, high)
             + rangeSumBST(root->right, low, high);
    }

    if (root->val < low) {

        return rangeSumBST(root->right, low, high);
    }

    // Current value is greater than high
    return rangeSumBST(root->left, low, high);
}

int main() {

    int n;

    printf("Enter number of nodes: ");
    scanf("%d", &n);

    int values[n];

    printf("Enter BST in level-order (-1 for NULL): ");

    for (int i = 0; i < n; i++) {
        scanf("%d", &values[i]);
    }

    struct TreeNode* nodes[n];

    for (int i = 0; i < n; i++) {

        if (values[i] == -1)
            nodes[i] = NULL;
        else
            nodes[i] = createNode(values[i]);
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

    struct TreeNode* root = nodes[0];

    int low, high;

    printf("Enter low and high: ");
    scanf("%d %d", &low, &high);

    int result = rangeSumBST(root, low, high);

    printf("Range Sum: %d\n", result);

    return 0;
}