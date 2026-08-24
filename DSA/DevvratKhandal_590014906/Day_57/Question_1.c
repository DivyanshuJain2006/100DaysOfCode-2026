#include <stdio.h>
#include <stdlib.h>

struct TreeNode {
    int val;
    struct TreeNode *left;
    struct TreeNode *right;
};

struct TreeNode* createNode(int val) {
    struct TreeNode* newNode =
        (struct TreeNode*)malloc(sizeof(struct TreeNode));

    newNode->val = val;
    newNode->left = NULL;
    newNode->right = NULL;

    return newNode;
}

int sumOfLeftLeaves(struct TreeNode* root) {
    if (root == NULL)
        return 0;

    int sum = 0;

    if (root->left != NULL &&
        root->left->left == NULL &&
        root->left->right == NULL) {
        sum += root->left->val;
    }

    sum += sumOfLeftLeaves(root->left);
    sum += sumOfLeftLeaves(root->right);

    return sum;
}

int main() {
    int n;

    printf("Enter number of nodes: ");
    scanf("%d", &n);

    printf("Enter root value: ");
    int rootValue;
    scanf("%d", &rootValue);

    struct TreeNode* root = createNode(rootValue);

    printf("Enter left child of root (-1 for NULL): ");
    int leftValue;
    scanf("%d", &leftValue);

    if (leftValue != -1)
        root->left = createNode(leftValue);

    printf("Enter right child of root (-1 for NULL): ");
    int rightValue;
    scanf("%d", &rightValue);

    if (rightValue != -1)
        root->right = createNode(rightValue);

    printf("Sum of left leaves = %d\n",
           sumOfLeftLeaves(root));

    return 0;
}