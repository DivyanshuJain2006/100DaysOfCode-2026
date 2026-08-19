<h2 align="center">Week 9 Day 62 (15/08/2026)</h2>

## 1. Evaluate Boolean Binary Tree (LeetCode #2331)

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

bool evaluateTree(TreeNode* root) {
    if (!root->left && !root->right) return root->val == 1; // leaf: 0=False, 1=True

    bool left = evaluateTree(root->left);
    bool right = evaluateTree(root->right);

    return (root->val == 2) ? (left || right) : (left && right); // 2=OR, 3=AND
}

int main() {
    vector<int> v1 = {2, 1, 3, NIL, NIL, 0, 1};
    TreeNode* r1 = buildTree(v1);
    cout << boolalpha << evaluateTree(r1) << endl; // true

    vector<int> v2 = {0};
    TreeNode* r2 = buildTree(v2);
    cout << boolalpha << evaluateTree(r2) << endl; // false

    return 0;
}
```

How it works: since it's a *full* binary tree, every node has exactly 0 or 2 children, so checking `!left && !right` reliably identifies a leaf. A leaf's own value (0 or 1) is the answer directly. An internal node's value (2 or 3) tells us which boolean operator to apply to its two children's evaluated results, computed recursively bottom-up.

Complexity: O(n) time, O(h) extra space for the recursion stack (h = tree height).

---

## 2. The Heist

### Solution

This is the classic "House Robber III" pattern: for every node, track two possibilities — the best total if this node *is* robbed, and the best total if it *isn't* — and combine them bottom-up.

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

// Returns {maxWithNodeRobbed, maxWithoutNodeRobbed}
pair<int,int> robHelper(TreeNode* node) {
    if (!node) return {0, 0};

    auto [leftWith, leftWithout] = robHelper(node->left);
    auto [rightWith, rightWithout] = robHelper(node->right);

    int withNode = node->val + leftWithout + rightWithout;
    int withoutNode = max(leftWith, leftWithout) + max(rightWith, rightWithout);

    return {withNode, withoutNode};
}

int maxRob(vector<int>& tree) {
    TreeNode* root = build(tree, 0);
    auto [withRoot, withoutRoot] = robHelper(root);
    return max(withRoot, withoutRoot);
}

int main() {
    vector<int> t1 = {3, 2, 3, -1, 3, -1, 1};
    cout << maxRob(t1) << endl; // 7

    vector<int> t2 = {3, 4, 5, 1, 3, -1, 1};
    cout << maxRob(t2) << endl; // 9

    vector<int> t3 = {10};
    cout << maxRob(t3) << endl; // 10

    return 0;
}
```

How it works: if a node is robbed, neither of its children can be (so we add the children's *without* values); if a node isn't robbed, each child is free to be robbed or not — whichever gives the larger contribution (`max(with, without)` per child). The final answer takes the better of robbing or skipping the root itself.

Complexity: O(n) time (each node visited once), O(h) extra space for the recursion stack.
