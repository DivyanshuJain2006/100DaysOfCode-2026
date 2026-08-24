#include <algorithm>

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
    int diameterOfBinaryTree(TreeNode* root) {
        int maxDiameter = 0;
        calculateHeight(root, maxDiameter);
        return maxDiameter;
    }
    
private:
    int calculateHeight(TreeNode* node, int& maxDiameter) {
        if (node == nullptr) {
            return 0; // Base case: height of a null node is 0
        }
        
        // Recursively find the height of left and right subtrees
        int leftHeight = calculateHeight(node->left, maxDiameter);
        int rightHeight = calculateHeight(node->right, maxDiameter);
        
        // The diameter through this node is the sum of left and right heights
        maxDiameter = std::max(maxDiameter, leftHeight + rightHeight);
        
        // Return the height of the tree rooted at this node
        return 1 + std::max(leftHeight, rightHeight);
    }
};