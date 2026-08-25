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
    TreeNode* insertIntoBST(TreeNode* root, int val) {
        // If the tree is empty, the new node becomes the root
        if (!root) {
            return new TreeNode(val);
        }
        
        TreeNode* curr = root;
        
        while (true) {
            if (val < curr->val) {
                // If left child is missing, insert here
                if (!curr->left) {
                    curr->left = new TreeNode(val);
                    break;
                }
                curr = curr->left; // Otherwise, keep moving left
            } else {
                // If right child is missing, insert here
                if (!curr->right) {
                    curr->right = new TreeNode(val);
                    break;
                }
                curr = curr->right; // Otherwise, keep moving right
            }
        }
        
        return root;
    }
};