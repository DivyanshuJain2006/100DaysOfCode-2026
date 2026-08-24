<h2 align="center">Week 9 Day 57 (10/08/2026)</h2>

## 1. Sum of Left Leaves

### Approach
Traverse the binary tree recursively. Whenever the current node's left child exists and is a leaf node, add its value to the sum.

### Solution

```cpp
class Solution {
public:
    bool isLeaf(TreeNode* node) {
        return node && node->left == nullptr && node->right == nullptr;
    }

    int sumOfLeftLeaves(TreeNode* root) {
        if (root == nullptr)
            return 0;

        int sum = 0;

        if (isLeaf(root->left))
            sum += root->left->val;

        sum += sumOfLeftLeaves(root->left);
        sum += sumOfLeftLeaves(root->right);

        return sum;
    }
};
```

**Time Complexity:** `O(n)`
**Space Complexity:** `O(h)` due to recursion, where `h` is the tree height.

---

## 2. The Twin Warehouses

### Approach
Since the trees are given in complete-tree indexing:

- Root → index `0`
- Left child → `2*i + 1`
- Right child → `2*i + 2`

For two trees to be mirrors:

- Their current values must be equal.
- Left subtree of the first must match the right subtree of the second.
- Right subtree of the first must match the left subtree of the second.

We can directly compare the arrays recursively.

### Solution

```cpp
#include <bits/stdc++.h>
using namespace std;

bool isMirror(const vector<long long>& a, const vector<long long>& b,
              int i, int j) {
    // If both nodes are missing
    if ((i >= a.size() || a[i] == -1) &&
        (j >= b.size() || b[j] == -1)) {
        return true;
    }

    // If one node is missing
    if (i >= a.size() || a[i] == -1 ||
        j >= b.size() || b[j] == -1) {
        return false;
    }

    // Values must be equal
    if (a[i] != b[j])
        return false;

    // Mirror comparison:
    // left of A <-> right of B
    // right of A <-> left of B
    return isMirror(a, b, 2 * i + 1, 2 * j + 2) &&
           isMirror(a, b, 2 * i + 2, 2 * j + 1);
}

int main() {
    int t;
    cin >> t;

    while (t--) {
        int n1;
        cin >> n1;

        vector<long long> warehouse1(n1);
        for (int i = 0; i < n1; i++)
            cin >> warehouse1[i];

        int n2;
        cin >> n2;

        vector<long long> warehouse2(n2);
        for (int i = 0; i < n2; i++)
            cin >> warehouse2[i];

        if (isMirror(warehouse1, warehouse2, 0, 0))
            cout << "YES\n";
        else
            cout << "NO\n";
    }

    return 0;
}
```
