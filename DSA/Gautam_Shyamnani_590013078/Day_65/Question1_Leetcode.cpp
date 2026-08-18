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
    vector<int> findMode(TreeNode* root) {
        vector<int> ans;

        TreeNode *curr = root;
        int prev = 0,count = 0, maxCount = 0;
        bool first = true;

        while(curr){
            if(!curr -> left){
                if(first || curr -> val != prev){
                    count = 1;
                    prev = curr -> val;
                    first = false;
                }else{
                    count++;
                }
                if(count > maxCount){
                    maxCount = count;
                    ans.clear();
                    ans.push_back(curr -> val);
                }else if(count == maxCount){
                    ans.push_back(curr -> val);
                }
                curr = curr -> right;
            }else{
                TreeNode* pred = curr -> left;
                while(pred -> right && pred -> right != curr)
                    pred = pred -> right;
                
                if(!pred -> right){
                    pred -> right = curr;
                    curr = curr -> left;
                }else{
                    pred -> right = nullptr;
                    if(first || curr -> val != prev){
                        count = 1;
                        prev = curr -> val;
                        first = false;
                    }else{
                        count++;
                    }
                    if(count > maxCount){
                        maxCount = count;
                        ans.clear();
                        ans.push_back(curr -> val);
                    }else if(count == maxCount){
                        ans.push_back(curr -> val);
                    }
                    curr = curr -> right;
                }
            }
        }
        return ans;
    }
};