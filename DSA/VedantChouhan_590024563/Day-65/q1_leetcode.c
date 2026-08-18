#include <stdio.h>
#include <stdlib.h>

#define MAX 10000

struct TreeNode {
    int val;
    struct TreeNode* left;
    struct TreeNode* right;
};

struct TreeNode* createNode(int val) {
    struct TreeNode* node =
        (struct TreeNode*)malloc(sizeof(struct TreeNode));

    node->val = val;
    node->left = NULL;
    node->right = NULL;

    return node;
}

int modes[MAX];
int modeCount = 0;

int previousValue;
int currentCount = 0;
int maxCount = 0;
int firstNode = 1;

void inorder(struct TreeNode* root) {

    if (root == NULL)
        return;

    inorder(root->left);

    // Count current value
    if (firstNode || root->val != previousValue) {
        currentCount = 1;
        previousValue = root->val;
        firstNode = 0;
    }
    else {
        currentCount++;
    }

    // New maximum frequency
    if (currentCount > maxCount) {

        maxCount = currentCount;
        modeCount = 0;

        modes[modeCount++] = root->val;
    }

    // Another value with same maximum frequency
    else if (currentCount == maxCount) {

        modes[modeCount++] = root->val;
    }

    inorder(root->right);
}

void findMode(struct TreeNode* root) {

    modeCount = 0;
    currentCount = 0;
    maxCount = 0;
    firstNode = 1;

    inorder(root);

    printf("Modes: ");

    for (int i = 0; i < modeCount; i++) {
        printf("%d ", modes[i]);
    }

    printf("\n");
}

int main() {

    /*
            1
             \
              2
             /
            2
    */

    struct TreeNode* root = createNode(1);

    root->right = createNode(2);
    root->right->left = createNode(2);

    findMode(root);

    return 0;
}