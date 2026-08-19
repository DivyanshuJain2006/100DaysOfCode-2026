#include <iostream>
#include <vector>
#include <cmath>
using namespace std;

class TreeNode {
public:
    int val;
    TreeNode* left;
    TreeNode* right;

    TreeNode(int x) {
        val = x;
        left = right = NULL;
    }
};

class Solution {
public:

    int minValue;

    void search(TreeNode* root, double target)
    {
        if(root == NULL)
            return;

        double currDiff = abs(root->val - target);
        double minDiff = abs(minValue - target);

        if(currDiff < minDiff)
        {
            minValue = root->val;
        }
        else if(currDiff == minDiff)
        {
            minValue = min(minValue, root->val);
        }

        if(root->val > target)
        {
            search(root->left, target);
        }
        else
        {
            search(root->right, target);
        }
    }

    int closestValue(TreeNode* root, double target)
    {
        minValue = root->val;

        search(root, target);

        return minValue;
    }
};