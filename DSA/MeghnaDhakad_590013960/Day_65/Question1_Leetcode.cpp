class Solution {
private:
    int currentVal = 0;
    int currentCount = 0;
    int maxCount = 0;
    vector<int> modes;

    void inorder(TreeNode* root) {
        if (!root) return;
        
        inorder(root->left);
        
        // Process current node
        if (root->val == currentVal) {
            currentCount++;
        } else {
            currentVal = root->val;
            currentCount = 1;
        }
        
        // Update modes
        if (currentCount > maxCount) {
            maxCount = currentCount;
            modes = {currentVal}; // Overwrite with new max
        } else if (currentCount == maxCount) {
            modes.push_back(currentVal); // Add tied mode
        }
        
        inorder(root->right);
    }

public:
    vector<int> findMode(TreeNode* root) {
        inorder(root);
        return modes;
    }
};