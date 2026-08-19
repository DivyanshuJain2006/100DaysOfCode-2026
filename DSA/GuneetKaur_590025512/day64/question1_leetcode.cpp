class TreeNode {
public:
    int val;
    TreeNode *left;
    TreeNode *right;

    TreeNode(int x) {
        val = x;
        left = right = 0;
    }
};
class Solution {
public:
    int rangeSumBST(TreeNode* root, int low, int high) {

        if(root == 0)
            return 0;

        if(root->val < low)
            return rangeSumBST(root->right, low, high);

        if(root->val > high)
            return rangeSumBST(root->left, low, high);

        return root->val
             + rangeSumBST(root->left, low, high)
             + rangeSumBST(root->right, low, high);
    }
};