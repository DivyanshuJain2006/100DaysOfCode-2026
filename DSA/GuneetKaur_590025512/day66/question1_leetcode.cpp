#include<iostream>
#include<vector>
using namespace std;
class TreeNode
{
    public:
       int val;
       TreeNode *left;
       TreeNode *right;
    
       TreeNode(int x)
       {
       val=x;
       left=right=NULL;
}
};
    class Solution {
public:
    TreeNode* insertIntoBST(TreeNode* root, int val) {

        if (root == NULL) {
            return new TreeNode(val);
        }

        if (val < root->val) {
            root->left = insertIntoBST(root->left, val);
        }
        else {
            root->right = insertIntoBST(root->right, val);
        }

        return root;
    }
};