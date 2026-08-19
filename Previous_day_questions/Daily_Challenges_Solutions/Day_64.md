<h2 align="center">Week 10 Day 64 (17/08/2026)</h2>

## 1. Range Sum of BST (LeetCode #938)

### Solution

```cpp
#include <bits/stdc++.h>
using namespace std;

struct TreeNode {
    int val;
    TreeNode *left, *right;
    TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
};

const int NIL = INT_MIN; // sentinel for a missing node in the input vector

TreeNode* buildTree(vector<int>& vals) {
    if (vals.empty() || vals[0] == NIL) return nullptr;

    TreeNode* root = new TreeNode(vals[0]);
    queue<TreeNode*> q;
    q.push(root);

    size_t i = 1;
    while (!q.empty() && i < vals.size()) {
        TreeNode* node = q.front(); q.pop();

        if (i < vals.size()) {
            if (vals[i] != NIL) { node->left = new TreeNode(vals[i]); q.push(node->left); }
            i++;
        }
        if (i < vals.size()) {
            if (vals[i] != NIL) { node->right = new TreeNode(vals[i]); q.push(node->right); }
            i++;
        }
    }
    return root;
}

int rangeSumBST(TreeNode* root, int low, int high) {
    if (!root) return 0;

    if (root->val < low) return rangeSumBST(root->right, low, high);  // whole left subtree too small
    if (root->val > high) return rangeSumBST(root->left, low, high);  // whole right subtree too big

    return root->val + rangeSumBST(root->left, low, high) + rangeSumBST(root->right, low, high);
}

int main() {
    vector<int> v1 = {10, 5, 15, 3, 7, NIL, 18};
    TreeNode* r1 = buildTree(v1);
    cout << rangeSumBST(r1, 7, 15) << endl; // 32

    vector<int> v2 = {10, 5, 15, 3, 7, 13, 18, 1, NIL, 6};
    TreeNode* r2 = buildTree(v2);
    cout << rangeSumBST(r2, 6, 10) << endl; // 23

    return 0;
}
```

How it works: the BST property lets us prune entire subtrees instead of visiting every node. If the current node's value is below `low`, every value in its left subtree is too — so skip straight to the right subtree. Symmetrically, if it's above `high`, skip to the left. Otherwise the node itself qualifies, and both subtrees still need checking.

Complexity: O(n) worst case (a degenerate/skewed tree), but typically much better since out-of-range subtrees are pruned entirely. O(h) extra space for the recursion stack.

---

## 2. The Conference Room

### Solution

```cpp
#include <bits/stdc++.h>
using namespace std;

struct TreeNode {
    int val;
    TreeNode *left, *right;
    TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
};

// Builds the tree directly from heap-array indexing: node i's children live
// at 2i+1 and 2i+2; -1 (or an out-of-range index) means missing.
TreeNode* build(vector<int>& tree, int idx) {
    if (idx >= (int)tree.size() || tree[idx] == -1) return nullptr;

    TreeNode* node = new TreeNode(tree[idx]);
    node->left = build(tree, 2 * idx + 1);
    node->right = build(tree, 2 * idx + 2);
    return node;
}

int lowestCommonAncestor(TreeNode* root, int a, int b) {
    TreeNode* cur = root;
    while (cur) {
        if (a < cur->val && b < cur->val) cur = cur->left;
        else if (a > cur->val && b > cur->val) cur = cur->right;
        else return cur->val; // split point, or one of a/b equals cur->val
    }
    return -1; // unreachable given the problem's guarantee
}

int main() {
    vector<int> t1 = {6, 2, 8, 0, 4, 7, 9};
    cout << lowestCommonAncestor(build(t1, 0), 2, 8) << endl; // 6

    vector<int> t2 = {6, 2, 8, 0, 4, 7, 9};
    cout << lowestCommonAncestor(build(t2, 0), 2, 4) << endl; // 2

    vector<int> t3 = {2, 1, 3};
    cout << lowestCommonAncestor(build(t3, 0), 1, 3) << endl; // 2

    return 0;
}
```

How it works: since it's a BST (not just any binary tree), there's no need to search both subtrees to find the LCA. Starting from the root, if both `a` and `b` are smaller than the current node's value, the LCA must be in the left subtree — move there. If both are larger, move right. The first node where this stops being true (either they split, or one of them *is* the current node) is the LCA — a room can be its own ancestor, which this naturally handles since equality falls into the "return" branch.

Complexity: O(h) time per query (h = tree height, so O(log n) for a balanced BST), O(1) extra space (iterative, no recursion stack).
