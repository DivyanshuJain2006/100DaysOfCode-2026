#include <stdio.h>
#include <stdlib.h>
struct TreeNode {
    int val;
    struct TreeNode *left, *right;
};
struct TreeNode* newNode(int x) {
    struct TreeNode* p = malloc(sizeof(struct TreeNode));
    p->val = x;
    p->left = p->right = NULL;
    return p;
}
int countSafe(struct TreeNode* root, int max) {
    if (root == NULL)
        return 0;
    int count = 0;
    if (root->val >= max)
        count = 1;
    if (root->val > max)
        max = root->val;
    return count + countSafe(root->left, max)
                 + countSafe(root->right, max);
}
int main() {
    int n;
    scanf("%d", &n);
    int a[n];
    for (int i = 0; i < n; i++)
        scanf("%d", &a[i]);
    struct TreeNode* node[n];
    for (int i = 0; i < n; i++)
        node[i] = (a[i] == -1) ? NULL : newNode(a[i]);
    int j = 1;
    for (int i = 0; i < n && j < n; i++) {
        if (node[i]) {
            if (j < n) node[i]->left = node[j++];
            if (j < n) node[i]->right = node[j++];
        }
    }
    printf("%d", countSafe(node[0], node[0]->val));
    return 0;
}