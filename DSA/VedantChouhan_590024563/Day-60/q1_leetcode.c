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

int max(int a, int b) {
    return a > b ? a : b;
}

int height(struct TreeNode* root, int* diameter) {

    if (root == NULL)
        return 0;

    int leftHeight = height(root->left, diameter);
    int rightHeight = height(root->right, diameter);

    // Diameter passing through this node
    int currentDiameter = leftHeight + rightHeight;

    if (currentDiameter > *diameter)
        *diameter = currentDiameter;

    // Return height of the current node
    return 1 + max(leftHeight, rightHeight);
}

int diameterOfBinaryTree(struct TreeNode* root) {

    int diameter = 0;

    height(root, &diameter);

    return diameter;
}

int main() {

    int n;

    printf("Enter number of nodes: ");
    scanf("%d", &n);

    if (n == 0) {
        printf("Diameter: 0\n");
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

    printf("Diameter: %d\n", diameterOfBinaryTree(root));

    return 0;
}