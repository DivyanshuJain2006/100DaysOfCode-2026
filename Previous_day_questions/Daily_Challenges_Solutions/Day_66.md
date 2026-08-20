<h2 align="center">Week 10 Day 66 (19/08/2026)</h2>

## 1. Insert into a Binary Search Tree (LeetCode #701)

### Solution

```cpp
#include <bits/stdc++.h>
using namespace std;

struct TreeNode {
    int val;
    TreeNode *left, *right;
    TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
};

const int NIL = INT_MIN;

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

TreeNode* insertIntoBST(TreeNode* root, int val) {
    if (!root) return new TreeNode(val);
    if (val < root->val) root->left = insertIntoBST(root->left, val);
    else root->right = insertIntoBST(root->right, val);
    return root;
}

int main() {
    vector<int> v1 = {4,2,7,1,3};
    TreeNode* r1 = buildTree(v1);
    r1 = insertIntoBST(r1, 5);
    // r1 now serializes to [4,2,7,1,3,5]

    vector<int> v2 = {40,20,60,10,30,50,70};
    TreeNode* r2 = buildTree(v2);
    r2 = insertIntoBST(r2, 25);
    // r2 now serializes to [40,20,60,10,30,50,70,null,null,25]

    return 0;
}
```

How it works: standard BST insertion walks down from the root, comparing `val` against each node's value to decide whether to recurse left or right, and stops the moment it reaches a null spot — that's where the new node gets attached as a leaf. Since the tree allows multiple valid insertion points for any new value (as long as the BST property holds), this always produces a valid result even though it may not match every other accepted answer exactly.

Complexity: O(h) time, where h is the tree height (O(log n) for a balanced tree, O(n) worst case for a skewed one). O(h) extra space for the recursion stack.

---

## 2. The Corporate Merger

### Solution

```cpp
#include <bits/stdc++.h>
using namespace std;

struct TreeNode {
    int val;
    TreeNode *left, *right;
    TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
};

// Standard queue-skip build: -1 entries are skipped, no placeholder children created
TreeNode* buildTree(vector<int>& vals) {
    if (vals.empty() || vals[0] == -1) return nullptr;
    TreeNode* root = new TreeNode(vals[0]);
    queue<TreeNode*> q;
    q.push(root);
    size_t i = 1;
    while (!q.empty() && i < vals.size()) {
        TreeNode* node = q.front(); q.pop();
        if (i < vals.size()) {
            if (vals[i] != -1) { node->left = new TreeNode(vals[i]); q.push(node->left); }
            i++;
        }
        if (i < vals.size()) {
            if (vals[i] != -1) { node->right = new TreeNode(vals[i]); q.push(node->right); }
            i++;
        }
    }
    return root;
}

void collect(TreeNode* node, set<int>& ids) {
    if (!node) return;
    ids.insert(node->val);
    collect(node->left, ids);
    collect(node->right, ids);
}

vector<int> mergeEmployeeIds(vector<int>& tree1, vector<int>& tree2) {
    TreeNode* r1 = buildTree(tree1);
    TreeNode* r2 = buildTree(tree2);

    set<int> ids; // sorted + de-duplicated automatically
    collect(r1, ids);
    collect(r2, ids);

    return vector<int>(ids.begin(), ids.end());
}

int main() {
    vector<int> t1a = {2, 1, 3};
    vector<int> t1b = {4, -1, 5};
    auto r1 = mergeEmployeeIds(t1a, t1b); // [1, 2, 3, 4, 5]

    vector<int> t2a = {10, 5, 15, -1, 7};
    vector<int> t2b = {10, 8, 12};
    auto r2 = mergeEmployeeIds(t2a, t2b); // [5, 7, 8, 10, 12, 15]

    vector<int> t3a = {1};
    vector<int> t3b = {1};
    auto r3 = mergeEmployeeIds(t3a, t3b); // [1]

    return 0;
}
```

How it works: rather than manually merging the two BSTs' sorted inorder sequences, every value from both trees is inserted into a `std::set<int>`, which keeps elements sorted and automatically discards duplicates. A simple recursive `collect()` walks each tree (order doesn't matter here, since the set handles both sorting and de-duplication), and the final answer is just that set copied into a vector.

Complexity: O((n1 + n2) log(n1 + n2)) time (set insertions), O(n1 + n2) extra space.
