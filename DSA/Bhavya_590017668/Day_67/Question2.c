
#include <stdlib.h>

struct TreeNode {
    int val;
    struct TreeNode *left;
    struct TreeNode *right;
};

int count[3];

int build(struct TreeNode* root) {
    if (root == NULL)
        return 0;

    int leftHeight = build(root->left);
    int rightHeight = build(root->right);

    int balance = leftHeight - rightHeight;

    if (balance == -1)
        count[0]++;
    else if (balance == 0)
        count[1]++;
    else if (balance == 1)
        count[2]++;

    return (leftHeight > rightHeight ? leftHeight : rightHeight) + 1;
}

struct TreeNode* createBST(int* nums, int left, int right) {
    if (left > right)
        return NULL;

    int mid = left + (right - left) / 2;

    struct TreeNode* root = malloc(sizeof(struct TreeNode));
    root->val = nums[mid];

    root->left = createBST(nums, left, mid - 1);
    root->right = createBST(nums, mid + 1, right);

    return root;
}

void balanceSpectrum(int* nums, int n, int result[3]) {
    count[0] = count[1] = count[2] = 0;

    struct TreeNode* root = createBST(nums, 0, n - 1);

    build(root);

    result[0] = count[0];
    result[1] = count[1];
    result[2] = count[2];
}