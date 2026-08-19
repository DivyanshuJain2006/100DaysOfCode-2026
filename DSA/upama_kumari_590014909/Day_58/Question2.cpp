#include <bits/stdc++.h>
using namespace std;

struct TreeNode {
    int val;
    TreeNode* left;
    TreeNode* right;

    TreeNode(int x) {
        val = x;
        left = NULL;
        right = NULL;
    }
};

TreeNode* buildTree(vector<int>& tree, int i) {

    if (i >= tree.size() || tree[i] == -1)
        return NULL;

    TreeNode* root = new TreeNode(tree[i]);

    root->left = buildTree(tree, 2 * i + 1);
    root->right = buildTree(tree, 2 * i + 2);

    return root;
}

bool exists(TreeNode* root, int x) {

    if (root == NULL)
        return false;

    if (root->val == x)
        return true;

    return exists(root->left, x) ||
           exists(root->right, x);
}

TreeNode* findLCA(TreeNode* root, int a, int b) {

    if (root == NULL)
        return NULL;

    if (root->val == a || root->val == b)
        return root;

    TreeNode* left = findLCA(root->left, a, b);
    TreeNode* right = findLCA(root->right, a, b);

    if (left != NULL && right != NULL)
        return root;

    if (left != NULL)
        return left;

    return right;
}

int main() {

    int t;
    cin >> t;

    while (t--) {

        int n;
        cin >> n;

        vector<int> tree(n);

        for (int i = 0; i < n; i++) {
            cin >> tree[i];
        }

        int a, b;
        cin >> a >> b;

        TreeNode* root = buildTree(tree, 0);

        if (!exists(root, a) || !exists(root, b)) {
            cout << -1 << endl;
            continue;
        }
        TreeNode* ans = findLCA(root, a, b);

        cout << ans->val << endl;
    }

    return 0;
}