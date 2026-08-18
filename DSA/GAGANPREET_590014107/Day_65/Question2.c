#include <stdio.h>
#include <stdlib.h>
#include <math.h>

typedef struct TreeNode {
    int val;
    struct TreeNode* left;
    struct TreeNode* right;
} TreeNode;

// Create a new node
TreeNode* createNode(int val) {
    TreeNode* newNode = (TreeNode*)malloc(sizeof(TreeNode));
    newNode->val = val;
    newNode->left = NULL;
    newNode->right = NULL;
    return newNode;
}

// Find closest value
int closestValue(TreeNode* root, double target) {

    int closest = root->val;

    while (root != NULL) {

        if (fabs(root->val - target) < fabs(closest - target)) {
            closest = root->val;
        }
        else if (fabs(root->val - target) ==
                 fabs(closest - target)) {

            // Smaller value in case of tie
            if (root->val < closest)
                closest = root->val;
        }

        // BST property
        if (target < root->val)
            root = root->left;
        else
            root = root->right;
    }

    return closest;
}

int main() {


    TreeNode* root = createNode(4);

    root->left = createNode(2);
    root->right = createNode(5);

    root->left->left = createNode(1);
    root->left->right = createNode(3);

    double target = 3;

    int answer = closestValue(root, target);

    printf("Closest value = %d\n", answer);

    return 0;
}
