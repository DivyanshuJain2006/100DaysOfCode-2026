#include <stdio.h>
#include <stdlib.h>

struct TreeNode {
    int val;
    struct TreeNode *left;
    struct TreeNode *right;
};
int find(struct TreeNode* root, int key) 
{
    if (root==NULL)
        return 0;
    if (root->val==key)
        return 1;
    return find(root->left, key) || find(root->right, key);
}
struct TreeNode* LCA(struct TreeNode* root, int a, int b) {
    if (root == NULL)
        return NULL;
    if (root->val == a || root->val == b)
        return root;
    struct TreeNode* left = LCA(root->left, a, b);
    struct TreeNode* right = LCA(root->right, a, b);
    if (left && right)
        return root;
    return (left != NULL) ? left : right;
}
int lowestCommonAncestor(struct TreeNode* root, int a, int b) 
{
    if (!find(root, a) || !find(root, b))
        return -1;
    struct TreeNode* ans = LCA(root,a,b);
    return ans?ans->val:-1;
}