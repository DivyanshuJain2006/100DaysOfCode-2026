#include <stdio.h>
#include <stdlib.h>
struct TreeNode {
    int val;
    struct TreeNode *left;
    struct TreeNode *right;
};
struct TreeNode* createNode(int val) {
    struct TreeNode* newNode = malloc(sizeof(struct TreeNode));
    newNode->val = val;
    newNode->left = NULL;
    newNode->right = NULL;
    return newNode;
}
struct TreeNode* buildTree(int arr[], int n, int index) {
    if (index >= n || arr[index] == -1)
        return NULL;
    struct TreeNode* root = createNode(arr[index]);
    root->left = buildTree(arr, n, 2 * index + 1);
    root->right = buildTree(arr, n, 2 * index + 2);
    return root;
}
int isMirror(struct TreeNode* root1, struct TreeNode* root2) {
    if (root1 == NULL && root2 == NULL)
        return 1;
    if (root1 == NULL || root2 == NULL)
        return 0;
    if (root1->val != root2->val)
        return 0;
    return isMirror(root1->left, root2->right) &&
           isMirror(root1->right, root2->left);
}
int main() {
    int t;
    scanf("%d", &t);
    while (t--) {
        int n1, n2;
        int a[1000], b[1000];
        scanf("%d", &n1);
        for (int i = 0; i < n1; i++)
            scanf("%d", &a[i]);
        scanf("%d", &n2);
        for (int i = 0; i < n2; i++)
            scanf("%d", &b[i]);
        struct TreeNode* root1 = buildTree(a, n1, 0);
        struct TreeNode* root2 = buildTree(b, n2, 0);
        if (isMirror(root1, root2))
            printf("YES\n");
        else
            printf("NO\n");
    }
    return 0;
}