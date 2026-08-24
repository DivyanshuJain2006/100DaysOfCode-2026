// Leetcode Problem 222
//  Count Complete Tree Nodes

/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     struct TreeNode *left;
 *     struct TreeNode *right;
 * };
 */
 
int countNodes(struct TreeNode* root) {
    if (root == NULL)
        return 0;
    int left = 0;
    int right = 0;
    struct TreeNode* l = root;
    struct TreeNode* r = root;
    while (l != NULL) {
        left++;
        l = l->left;
    }
    while (r != NULL) {
        right++;
        r = r->right;
    }
    if (left == right) {
        int total = (1 << left) - 1;
        return total;
    }
    int total = 1 + countNodes(root->left) + countNodes(root->right);
    return total;
}