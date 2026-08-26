<h2 align="center">Week 10 Day 68 (21/08/2026)</h2>

## 1. Balance a Binary Search Tree (LeetCode #1382)
### Solution
```c
struct TreeNode {
    int val;
    struct TreeNode *left;
    struct TreeNode *right;
};

void inorder(struct TreeNode* root, int* arr, int* idx) {
    if (!root) return;
    inorder(root->left, arr, idx);
    arr[(*idx)++] = root->val;
    inorder(root->right, arr, idx);
}

struct TreeNode* buildBalanced(int* arr, int left, int right) {
    if (left > right) return NULL;
    int mid = left + (right - left) / 2;
    struct TreeNode* node = (struct TreeNode*)malloc(sizeof(struct TreeNode));
    node->val = arr[mid];
    node->left = buildBalanced(arr, left, mid - 1);
    node->right = buildBalanced(arr, mid + 1, right);
    return node;
}

struct TreeNode* balanceBST(struct TreeNode* root) {
    int arr[10001];
    int idx = 0;
    inorder(root, arr, &idx);
    return buildBalanced(arr, 0, idx - 1);
}
```
* Time: O(n) — one pass to collect values in order, one pass to rebuild.
* Space: O(n) for the array plus O(log n) recursion depth for the balanced result.

An in-order traversal of a BST always yields values in sorted order, so recursively picking the middle element as the root at every step guarantees a tree whose left and right subtree depths never differ by more than 1.

---

## 2. The Franchise Audit
### Solution
```cpp
#include <bits/stdc++.h>
using namespace std;

struct Node {
    long long val;
    Node* left;
    Node* right;
};

Node* buildTree(vector<long long>& arr, int i, int n) {
    if (i > n || i < 1 || arr[i] == -1) return nullptr;
    Node* node = new Node{arr[i], nullptr, nullptr};
    node->left = buildTree(arr, 2 * i, n);
    node->right = buildTree(arr, 2 * i + 1, n);
    return node;
}

struct Info {
    bool isBST;
    long long minVal, maxVal;
    int size;
};

Info largestBSTHelper(Node* root, int& best) {
    if (!root) {
        return {true, LLONG_MAX, LLONG_MIN, 0};
    }
    Info left = largestBSTHelper(root->left, best);
    Info right = largestBSTHelper(root->right, best);

    if (left.isBST && right.isBST &&
        root->val > left.maxVal && root->val < right.minVal) {
        int size = left.size + right.size + 1;
        best = max(best, size);
        return {true, min((long long)root->val, left.minVal),
                max((long long)root->val, right.maxVal), size};
    }
    return {false, 0, 0, 0};
}

int largestBSTSubtree(Node* root) {
    int best = 0;
    largestBSTHelper(root, best);
    return best;
}

int main() {
    int t;
    cin >> t;
    while (t--) {
        int n;
        cin >> n;
        vector<long long> arr(n + 1);
        for (int i = 1; i <= n; i++) cin >> arr[i];
        Node* root = buildTree(arr, 1, n);
        cout << largestBSTSubtree(root) << endl;
    }
    return 0;
}
```
* Time: O(n) per test case — a single post-order pass, each node visited once.
* Space: O(n) for the tree plus O(h) recursion depth.

Each node reports back whether its own subtree is a valid BST along with its min, max, and size. A node's subtree is a valid BST only if both children report valid BSTs and the node's value fits strictly between the left subtree's max and the right subtree's min — at which point its size candidate updates the running best.
