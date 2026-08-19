
#include<iostream>
#include<vector>
using namespace std;

class Solution {
public:
    struct TreeNode {
        int val;
        TreeNode* left;
        TreeNode* right;

        TreeNode(int x) : val(x), left(NULL), right(NULL) {}
    };

  
    TreeNode* buildTree(vector<int>& arr, int i) {
        if (i >= arr.size() || arr[i] == -1)
            return NULL;

        TreeNode* root = new TreeNode(arr[i]);

        root->left = buildTree(arr, 2 * i + 1);
        root->right = buildTree(arr, 2 * i + 2);

        return root;
    }

    int solve(TreeNode* root, vector<int>& freq) {

        if (root == NULL)
            return 0;

        freq[root->val]++;

        if (root->left == NULL && root->right == NULL) {

            int odd = 0;

            for (int i = 0; i <= 9; i++) {
                if (freq[i] % 2 != 0)
                    odd++;
            }

            if (odd <= 1) {
                freq[root->val]--;
                return 1;
            }

            freq[root->val]--;
            return 0;
        }

        int ans = solve(root->left, freq)
                + solve(root->right, freq);

        freq[root->val]--;

        return ans;
    }
};
