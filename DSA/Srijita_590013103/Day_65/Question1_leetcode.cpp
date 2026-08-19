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
    vector<int> ans;
    int prevVal = 0, currCount = 0, maxCount = 0;
    bool hasPrev = false;

    void inorder(TreeNode* root) {
        if (!root) return;

        inorder(root->left);

        if (hasPrev && root->val == prevVal)
            currCount++;
        else
            currCount = 1;

        if (currCount > maxCount) {
            maxCount = currCount;
            ans.clear();
            ans.push_back(root->val);
        } 
        else if (currCount == maxCount) {
            ans.push_back(root->val);
        }

        prevVal = root->val;
        hasPrev = true;

        inorder(root->right);
    }

    vector<int> findMode(TreeNode* root) {
        inorder(root);
        return ans;
    }
};
