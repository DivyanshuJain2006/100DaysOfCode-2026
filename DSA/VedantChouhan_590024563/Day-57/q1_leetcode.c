#include <stdio.h>
#include <stdlib.h>

struct TreeNode {
    int val;
    struct TreeNode *left;
    struct TreeNode *right;
};

struct TreeNode* createNode(int value) {
    struct TreeNode* newNode =
        (struct TreeNode*)malloc(sizeof(struct TreeNode));

    newNode->val = value;
    newNode->left = NULL;
    newNode->right = NULL;

    return newNode;
}

int sumOfLeftLeaves(struct TreeNode* root) {

    if (root == NULL)
        return 0;

    int sum = 0;

    if (root->left != NULL) {

        // Check if left child is a leaf
        if (root->left->left == NULL &&
            root->left->right == NULL) {

            sum += root->left->val;
        }
        else {
            sum += sumOfLeftLeaves(root->left);
        }
    }

    sum += sumOfLeftLeaves(root->right);

    return sum;
}

int main() {

    int n;

    printf("Enter number of nodes: ");
    scanf("%d", &n);

    if (n <= 0) {
        printf("Sum of left leaves: 0\n");
        return 0;
    }

    int values[n];

    printf("Enter level-order values (-1 for NULL): ");

    for (int i = 0; i < n; i++) {
        scanf("%d", &values[i]);
    }

    struct TreeNode* nodes[n];

    // Create nodes
    for (int i = 0; i < n; i++) {

        if (values[i] == -1)
            nodes[i] = NULL;
        else
            nodes[i] = createNode(values[i]);
    }

    // Connect nodes
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

    printf("Sum of left leaves: %d\n",
           sumOfLeftLeaves(root));

    return 0;
}