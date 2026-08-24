#include <stdio.h>
#include <stdlib.h>
struct TreeNode {
    int val;
    struct TreeNode* left;
    struct TreeNode* right;
};
struct TreeNode* createTree(int tree[], int n, int i) {
    if (i >= n || tree[i] == -1)
        return NULL;
    struct TreeNode* node = (struct TreeNode*)malloc(sizeof(struct TreeNode));
    node->val = tree[i];
    node->left = createTree(tree, n, 2 * i + 1);
    node->right = createTree(tree, n, 2 * i + 2);
    return node;
}
int max(int a, int b) {
    return (a > b) ? a : b;
}
void solve(struct TreeNode* root, int* rob, int* skip) {
    if (root == NULL) {
        *rob = 0;
        *skip = 0;
        return;
    }
    int leftRob, leftSkip;
    int rightRob, rightSkip;
    solve(root->left, &leftRob, &leftSkip);
    solve(root->right, &rightRob, &rightSkip);
    *rob = root->val + leftSkip + rightSkip;
    *skip = max(leftRob, leftSkip) +
            max(rightRob, rightSkip);
}
int rob(struct TreeNode* root) {
    int robRoot, skipRoot;
    solve(root, &robRoot, &skipRoot);
    return max(robRoot, skipRoot);
}
int main() {
    int n;
    printf("Enter n: ");
    scanf("%d", &n);
    int tree[n];
    printf("Enter tree values: ");
    for (int i = 0; i < n; i++) {
        scanf("%d", &tree[i]);
    }
    struct TreeNode* root = createTree(tree, n, 0);
    printf("Maximum money = %d\n", rob(root));
    return 0;
}