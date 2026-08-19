#include <stdio.h>
#include <stdlib.h>
struct TreeNode {
    int val;
    struct TreeNode *left;
    struct TreeNode *right;
};
struct TreeNode* createNode(int value) {
    struct TreeNode* newNode = (struct TreeNode*)malloc(sizeof(struct TreeNode));
    newNode->val = value;
    newNode->left = NULL;
    newNode->right = NULL;
    return newNode;
}
struct TreeNode* buildTree(int tree[], int n) {
    if (n == 0 || tree[0] == -1) {
        return NULL;
    }
    struct TreeNode* nodes[1000];
    for (int i = 0; i < n; i++) {
        if (tree[i] != -1) {
            nodes[i] = createNode(tree[i]);
        } else {
            nodes[i] = NULL;
        }
    }
    for (int i = 0; i < n; i++) {
        if (nodes[i] != NULL) {
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            if (left < n) {
                nodes[i]->left = nodes[left];
            }
            if (right < n) {
                nodes[i]->right = nodes[right];
            }
        }
    }
    return nodes[0];
}
struct TreeNode* lowestCommonAncestor(struct TreeNode* root, int a, int b) {
    if (a < root->val && b < root->val) {
        return lowestCommonAncestor(root->left, a, b);
    }
    if (a > root->val && b > root->val) {
        return lowestCommonAncestor(root->right, a, b);
    }
    return root;
}
int main() {
    int t;
    printf("Enter number of test cases: ");
    scanf("%d", &t);
    while (t--) {
        int n;
        printf("Enter number of nodes: ");
        scanf("%d", &n);
        int tree[1000];
        printf("Enter level-order tree (-1 for NULL):\n");
        for (int i = 0; i < n; i++) {
            scanf("%d", &tree[i]);
        }
        int a, b;
        printf("Enter a and b: ");
        scanf("%d %d", &a, &b);
        struct TreeNode* root = buildTree(tree, n);
        struct TreeNode* answer = lowestCommonAncestor(root, a, b);
        printf("LCA = %d\n", answer->val);
    }
    return 0;
}