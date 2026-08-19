/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    int countNodes(TreeNode* root) {
        if (!root) return 0;
        
        int leftHeight = 0;
        int rightHeight = 0;
        
        TreeNode* l = root;
        TreeNode* r = root;
        
        // Calculate extreme left depth
        while (l) {
            leftHeight++;
            l = l->left;
        }
        
        // Calculate extreme right depth
        while (r) {
            rightHeight++;
            r = r->right;
        }
        
        // If heights are equal, it is a perfect binary tree
        if (leftHeight == rightHeight) {
            return (1 << leftHeight) - 1; // 2^h - 1
        }
        
        // Otherwise, recursively calculate for left and right
        return 1 + countNodes(root->left) + countNodes(root->right);
    }
};