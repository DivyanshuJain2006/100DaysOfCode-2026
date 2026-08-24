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

/* Height going through the left side */
int leftHeight(struct TreeNode* root) {

    int height = 0;

    while (root != NULL) {
        height++;
        root = root->left;
    }

    return height;
}

/* Height going through the right side */
int rightHeight(struct TreeNode* root) {

    int height = 0;

    while (root != NULL) {
        height++;
        root = root->right;
    }

    return height;
}

int countNodes(struct TreeNode* root) {

    if (root == NULL)
        return 0;

    int lh = leftHeight(root);
    int rh = rightHeight(root);

    /* Perfect binary tree */
    if (lh == rh) {
        return (1 << lh) - 1;
    }

    return 1 + countNodes(root->left)
             + countNodes(root->right);
}

int main() {

    int n;

    printf("Enter number of nodes: ");
    scanf("%d", &n);

    if (n == 0) {
        printf("Number of nodes: 0\n");
        return 0;
    }

    /*
       Enter nodes in level-order.
       Use -1 for NULL.
    */
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

    printf("Number of nodes: %d\n", countNodes(root));

    return 0;
}