class Solution {
private:
    vector<TreeNode*> sortedNodes;

    // Step 1: Collect nodes in sorted order
    void inorder(TreeNode* root) {
        if (!root) return;
        inorder(root->left);
        sortedNodes.push_back(root);
        inorder(root->right);
    }

    // Step 2: Build balanced BST from sorted nodes
    TreeNode* buildBalancedTree(int left, int right) {
        if (left > right) return nullptr;
        
        int mid = left + (right - left) / 2;
        TreeNode* root = sortedNodes[mid];
        
        root->left = buildBalancedTree(left, mid - 1);
        root->right = buildBalancedTree(mid + 1, right);
        
        return root;
    }

public:
    TreeNode* balanceBST(TreeNode* root) {
        inorder(root);
        return buildBalancedTree(0, sortedNodes.size() - 1);
    }
};