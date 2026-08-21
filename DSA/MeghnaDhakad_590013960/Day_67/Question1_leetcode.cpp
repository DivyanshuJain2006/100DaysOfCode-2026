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
    TreeNode* deleteNode(TreeNode* root, int key) {
        if (!root) return nullptr;
        
        // Search for the node
        if (key < root->val) {
            root->left = deleteNode(root->left, key);
        } else if (key > root->val) {
            root->right = deleteNode(root->right, key);
        } else {
            // Node found!
            
            // Case 1 & 2: Node has one child or no children
            if (!root->left) {
                TreeNode* temp = root->right;
                delete root; // Free memory
                return temp;
            } else if (!root->right) {
                TreeNode* temp = root->left;
                delete root; // Free memory
                return temp;
            }
            
            // Case 3: Node has two children
            // Find the inorder successor (smallest value in the right subtree)
            TreeNode* successor = findMin(root->right);
            
            // Copy successor's value to the current node
            root->val = successor->val;
            
            // Recursively delete the inorder successor
            root->right = deleteNode(root->right, successor->val);
        }
        
        return root;
    }
    
private:
    TreeNode* findMin(TreeNode* node) {
        while (node->left) {
            node = node->left;
        }
        return node;
    }
};