#include <stdio.h>
#include <stdlib.h>

struct TreeNode {
    int val;
    struct TreeNode *left;
    struct TreeNode *right;
};

int max(int a, int b) {
    return (a > b) ? a : b;
}

}
void solve(struct TreeNode* root, int result[2]) {
    if (root == NULL) {
        result[0] = 0; // rob
        result[1] = 0; // skip
        return;
    }

    int left[2], right[2];

    solve(root->left, left);
    solve(root->right, right);

    // If we rob current house, we cannot rob its children
    result[0] = root->val + left[1] + right[1];

    // If we skip current house, we can either rob or skip each child
    result[1] = max(left[0], left[1]) +
                max(right[0], right[1]);
}

// Main function
int rob(struct TreeNode* root) {
    int result[2];

    solve(root, result);

    return max(result[0], result[1]);
}

// Create a new node
struct TreeNode* createNode(int val) {
    struct TreeNode* node =
        (struct TreeNode*)malloc(sizeof(struct TreeNode));

    node->val = val;
    node->left = NULL;
    node->right = NULL;

    return node;
}

int main() {


    struct TreeNode* root = createNode(3);

    root->left = createNode(2);
    root->right = createNode(3);

    root->left->right = createNode(3);
    root->right->right = createNode(1);

    printf("Maximum money that can be robbed: %d\n", rob(root));

    return 0;
}
