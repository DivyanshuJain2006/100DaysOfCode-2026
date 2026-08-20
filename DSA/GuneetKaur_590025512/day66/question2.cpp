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
};class Solution {
public:

    void inorder(TreeNode* root, vector<int>& v) {
        if (root == NULL)
            return;

        inorder(root->left, v);
        v.push_back(root->val);
        inorder(root->right, v);
    }

    vector<int> mergeBSTs(TreeNode* root1, TreeNode* root2) {

        vector<int> a, b;
        inorder(root1, a);
        inorder(root2, b);

        vector<int> ans;

        int i = 0;
        int j = 0;

        while (i < a.size() && j < b.size()) {

            if (a[i] < b[j]) {
                if (ans.empty() || ans.back() != a[i])
                    ans.push_back(a[i]);

                i++;
            }
            else if (b[j] < a[i]) {
                if (ans.empty() || ans.back() != b[j])
                    ans.push_back(b[j]);

                j++;
            }
            else {
                if (ans.empty() || ans.back() != a[i])
                    ans.push_back(a[i]);

                i++;
                j++;
            }
        }
        while (i < a.size()) {
            if (ans.empty() || ans.back() != a[i])
                ans.push_back(a[i]);

            i++;
        }
        while (j < b.size()) {
            if (ans.empty() || ans.back() != b[j])
                ans.push_back(b[j]);

            j++;
        }

        return ans;
    }
};