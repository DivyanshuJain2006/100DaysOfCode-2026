#include <queue>

class Solution {
public:
    bool isCompleteTree(TreeNode* root) {
        if (!root) return true;
        
        std::queue<TreeNode*> q;
        q.push(root);
        bool nullEncountered = false;
        
        while (!q.empty()) {
            TreeNode* current = q.front();
            q.pop();
            
            if (current == nullptr) {
                nullEncountered = true;
            } else {
                // If we've seen a null before this valid node, it's not complete
                if (nullEncountered) {
                    return false;
                }
                // Push children (even if they are null)
                q.push(current->left);
                q.push(current->right);
            }
        }
        
        return true;
    }
};