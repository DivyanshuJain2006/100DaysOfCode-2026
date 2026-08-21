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
    int rangeSumBST(TreeNode* root, int low, int high) {
        if (!root) return 0;
        
        // Prune the left subtree if current value is too small
        if (root->val < low) {
            return rangeSumBST(root->right, low, high);
        }
        
        // Prune the right subtree if current value is too large
        if (root->val > high) {
            return rangeSumBST(root->left, low, high);
        }
        
        // If within range, add the current value and process both children
        return root->val + 
               rangeSumBST(root->left, low, high) + 
               rangeSumBST(root->right, low, high);
    }
};