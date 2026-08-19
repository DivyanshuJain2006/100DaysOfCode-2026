class Solution {
public:
    int countSafe(TreeNode* root, int maxAltitude) {
        if (root == nullptr)
            return 0;

        if (root->val >= maxAltitude) {
            maxAltitude = root->val;
        }

        int count = (root->val >= maxAltitude) ? 1 : 0;

        return count
             + countSafe(root->left, maxAltitude)
             + countSafe(root->right, maxAltitude);
    }

    int goodNodes(TreeNode* root) {
        return countSafe(root, INT_MIN);
    }
};