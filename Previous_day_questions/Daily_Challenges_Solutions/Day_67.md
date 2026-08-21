<h2 align="center">Week 10 Day 67 (20/08/2026)</h2>

## 1. Delete Node in a BST (LeetCode #450)

### Solution

```cpp
#include <bits/stdc++.h>
using namespace std;

struct TreeNode {
    int val;
    TreeNode *left, *right;
    TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
};

TreeNode* deleteNode(TreeNode* root, int key) {
    if (!root) return nullptr;

    if (key < root->val) {
        root->left = deleteNode(root->left, key);
    } else if (key > root->val) {
        root->right = deleteNode(root->right, key);
    } else {
        // Found the node to delete
        if (!root->left) return root->right;
        if (!root->right) return root->left;

        // Two children: find in-order successor (smallest in right subtree)
        TreeNode* succParent = root;
        TreeNode* succ = root->right;
        while (succ->left) {
            succParent = succ;
            succ = succ->left;
        }
        if (succParent != root) {
            succParent->left = succ->right;
            succ->right = root->right;
        }
        succ->left = root->left;
        return succ;
    }
    return root;
}

int main() {
    // root = [5,3,6,2,4,null,7], key = 3
    // deleting 3 (two children: 2 and 4) replaces it with its in-order
    // successor 4, giving [5,4,6,2,null,null,7]

    // root = [5,3,6,2,4,null,7], key = 0
    // 0 is not present, tree is returned unchanged

    // root = [], key = 0
    // empty tree stays empty
    return 0;
}
```

How it works: the function recurses down the tree the same way a BST search would, moving left or right depending on how `key` compares to the current node's value. Once the target node is found there are three cases: a missing left child (return the right subtree in its place), a missing right child (return the left subtree in its place), or two children (splice out the in-order successor — the leftmost node of the right subtree — and use it to replace the deleted node, reattaching the successor's own right subtree where it used to sit). This guarantees the BST property is preserved without needing to rebuild the tree.

Complexity: O(h) time, where h is the tree height (O(log n) balanced, O(n) worst case). O(h) extra space for the recursion stack.

---

## 2. The Balance Spectrum

### Solution

```cpp
#include <bits/stdc++.h>
using namespace std;

int cntM1 = 0, cnt0 = 0, cntP1 = 0;

// Recursively builds the minimal-height BST over arr[l..r] and returns
// the subtree's height (-1 for an empty subtree), tallying balance
// factors along the way.
int build(vector<int>& arr, int l, int r) {
    if (l > r) return -1; // empty subtree, height -1

    int mid = l + (r - l) / 2; // picks the left-middle element for even-length segments

    int leftH  = build(arr, l, mid - 1);
    int rightH = build(arr, mid + 1, r);

    int bf = rightH - leftH; // balance factor of this node
    if (bf == -1) cntM1++;
    else if (bf == 0) cnt0++;
    else if (bf == 1) cntP1++;

    return max(leftH, rightH) + 1;
}

vector<int> balanceSpectrum(vector<int>& arr) {
    cntM1 = cnt0 = cntP1 = 0;
    build(arr, 0, (int)arr.size() - 1);
    return {cntM1, cnt0, cntP1};
}

int main() {
    vector<int> arr1 = {1, 2, 3, 4, 5, 6, 7};
    auto r1 = balanceSpectrum(arr1); // 0 7 0

    vector<int> arr2 = {42};
    auto r2 = balanceSpectrum(arr2); // 0 1 0

    return 0;
}
```

How it works: `build` mirrors the array-to-BST construction rule directly — it always splits the current segment at its (left-)middle index, recurses on the two halves, and uses their returned heights to compute the current node's balance factor before returning its own height (one more than the taller child, with an empty subtree treated as height -1). Because the split point is always the middle (or left-middle) element, the two subtree heights at any node differ by at most 1, so the balance factor is always exactly -1, 0, or +1, and every node's contribution is tallied into the matching counter as the recursion unwinds.

Complexity: O(n) time and O(h) extra space for the recursion stack, where h = O(log n) since the construction always yields a balanced tree.
