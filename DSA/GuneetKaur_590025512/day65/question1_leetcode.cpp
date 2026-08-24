#include<iostream>
#include<vector>
#include<unordered_map>
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

    unordered_map<int, int> freq;

    void Traversal(TreeNode* root)
    {
        if(root == NULL)
        {
            return;
        }

        freq[root->val]++;

        Traversal(root->left);
        Traversal(root->right);
    }

    vector<int> findMode(TreeNode* root)
    {
        Traversal(root);

        int maxfreq = 0;

        for(auto it : freq)
        {
            maxfreq = max(maxfreq, it.second);
        }

        vector<int> ans;

        for(auto it : freq)
        {
            if(it.second == maxfreq)
            {
                ans.push_back(it.first);
            }
        }

        return ans;
    }
};