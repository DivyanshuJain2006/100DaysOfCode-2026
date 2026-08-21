class Solution {
public:
    TreeNode* deleteNode(TreeNode* root, int key) {
        TreeNode* parent = nullptr;
        TreeNode* current = root;

        // Find the node.
        while (current && current->val != key) {
            parent = current;

            if (key < current->val)
                current = current->left;
            else
                current = current->right;
        }

        // Key does not exist.
        if (!current)
            return root;

        // If the node has two children, replace its value
        // with its inorder successor's value.
        if (current->left && current->right) {
            TreeNode* successorParent = current;
            TreeNode* successor = current->right;

            while (successor->left) {
                successorParent = successor;
                successor = successor->left;
            }

            current->val = successor->val;
            parent = successorParent;
            current = successor;
        }

        // Current now has at most one child.
        TreeNode* child = current->left
                            ? current->left
                            : current->right;

        if (!parent) {
            root = child;
        } else if (parent->left == current) {
            parent->left = child;
        } else {
            parent->right = child;
        }

        delete current;
        return root;
    }
};