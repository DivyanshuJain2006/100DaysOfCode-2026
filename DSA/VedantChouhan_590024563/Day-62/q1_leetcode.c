#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

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

bool evaluateTree(struct TreeNode* root) {

    if (root == NULL)
        return false;

    // Leaf node
    if (root->left == NULL && root->right == NULL) {
        return root->val == 1;
    }

    bool left = evaluateTree(root->left);
    bool right = evaluateTree(root->right);

    // 2 = OR
    if (root->val == 2)
        return left || right;

    // 3 = AND
    return left && right;
}

int main() {

    int n;

    printf("Enter number of nodes: ");
    scanf("%d", &n);

    int values[n];

    printf("Enter level-order values (-1 for NULL): ");

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

    bool result = evaluateTree(root);

    printf("Result: %s\n", result ? "true" : "false");

    return 0;
}