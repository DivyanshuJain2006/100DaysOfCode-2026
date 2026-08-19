class Solution {
public:
    bool evaluateTree(TreeNode* root) {
        // Base cases for leaf nodes
        if (root->val == 0) return false;
        if (root->val == 1) return true;
        
        // Recursively evaluate children
        bool leftVal = evaluateTree(root->left);
        bool rightVal = evaluateTree(root->right);
        
        // Apply operations for non-leaf nodes
        if (root->val == 2) {
            return leftVal || rightVal; // OR
        }
        
        return leftVal && rightVal;     // AND
    }
};