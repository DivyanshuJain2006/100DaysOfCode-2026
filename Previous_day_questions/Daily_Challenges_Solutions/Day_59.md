<h2 align="center">Week 9 Day 59 (10/08/2026)</h2>

## 1. Check Completeness of a Binary Tree (LeetCode #958)

### Solution

```c
#include <stdio.h>
#include <stdlib.h>
#include <limits.h>

#define NIL INT_MIN /* sentinel marking a missing node in the input array */

typedef struct TreeNode {
    int val;
    struct TreeNode *left, *right;
} TreeNode;

TreeNode* newNode(int v) {
    TreeNode* n = malloc(sizeof(TreeNode));
    n->val = v;
    n->left = n->right = NULL;
    return n;
}

/* Standard LeetCode-style level-order build: NIL entries are simply
   skipped (no node created), matching how root = [1,2,3,4,5,null,7] is read. */
TreeNode* buildTree(int *vals, int n) {
    if (n == 0 || vals[0] == NIL) return NULL;

    TreeNode* root = newNode(vals[0]);
    TreeNode* q[1000];
    int qh = 0, qt = 0;
    q[qt++] = root;

    int i = 1;
    while (qh < qt && i < n) {
        TreeNode* node = q[qh++];
        if (i < n) {
            if (vals[i] != NIL) { node->left = newNode(vals[i]); q[qt++] = node->left; }
            i++;
        }
        if (i < n) {
            if (vals[i] != NIL) { node->right = newNode(vals[i]); q[qt++] = node->right; }
            i++;
        }
    }
    return root;
}

int isCompleteTree(TreeNode* root) {
    if (!root) return 1;

    TreeNode* q[1000];
    int qh = 0, qt = 0;
    q[qt++] = root;
    int seenNull = 0;

    while (qh < qt) {
        TreeNode* node = q[qh++];

        if (!node) {
            seenNull = 1;
            continue;
        }
        if (seenNull) return 0; // a real node showed up after a gap -> not complete

        q[qt++] = node->left;
        q[qt++] = node->right;
    }
    return 1;
}

int main(void) {
    int v1[] = {1, 2, 3, 4, 5, 6};
    TreeNode* r1 = buildTree(v1, 6);
    printf("%s\n", isCompleteTree(r1) ? "true" : "false"); // true

    int v2[] = {1, 2, 3, 4, 5, NIL, 7};
    TreeNode* r2 = buildTree(v2, 7);
    printf("%s\n", isCompleteTree(r2) ? "true" : "false"); // false

    return 0;
}
```

How it works: run a level-order BFS, but instead of skipping missing children, push `NULL` into the queue for every gap. Track whether a `NULL` has been dequeued yet — once it has, any subsequent *real* node dequeued proves the tree isn't left-packed, so it's not complete. If the traversal finishes without that happening, the tree is complete.

Complexity: O(n) time, O(n) extra space for the queue.

---

## 2. The Secret Passcodes

### Solution

```c
#include <stdio.h>
#include <stdlib.h>

typedef struct TreeNode {
    int val;
    struct TreeNode *left, *right;
} TreeNode;

TreeNode* newNode(int v) {
    TreeNode* n = malloc(sizeof(TreeNode));
    n->val = v;
    n->left = n->right = NULL;
    return n;
}

/* Builds the tree directly from heap-array indexing: node i's children live
   at 2i+1 and 2i+2; -1 (or an out-of-range index) means missing. */
TreeNode* build(int *tree, int n, int idx) {
    if (idx >= n || tree[idx] == -1) return NULL;

    TreeNode* node = newNode(tree[idx]);
    node->left = build(tree, n, 2 * idx + 1);
    node->right = build(tree, n, 2 * idx + 2);
    return node;
}

int countPopcount(unsigned mask) {
    int c = 0;
    while (mask) { c += mask & 1; mask >>= 1; }
    return c;
}

/* mask has one bit per digit (0-9); a set bit means that digit's count
   is currently odd along the path so far. */
int countValidPaths(TreeNode* root, unsigned mask) {
    if (!root) return 0;

    mask ^= (1u << root->val);

    if (!root->left && !root->right) {
        return countPopcount(mask) <= 1 ? 1 : 0; // leaf: check palindrome-rearrangeable
    }

    return countValidPaths(root->left, mask) + countValidPaths(root->right, mask);
}

int main(void) {
    int t1[] = {2, 3, 1, 3, 1, -1, 1};
    TreeNode* r1 = build(t1, 7, 0);
    printf("%d\n", countValidPaths(r1, 0)); // 2

    int t2[] = {1, 1, 1};
    TreeNode* r2 = build(t2, 3, 0);
    printf("%d\n", countValidPaths(r2, 0)); // 2

    int t3[] = {5};
    TreeNode* r3 = build(t3, 1, 0);
    printf("%d\n", countValidPaths(r3, 0)); // 1

    return 0;
}
```

How it works: a digit sequence can be rearranged into a palindrome exactly when at most one digit has an odd count — so instead of tracking full counts, a 10-bit mask (one bit per digit) is XORed along the path: flipping a digit's bit each time it's seen keeps that bit set precisely when the digit's running count is odd. At each leaf, `popcount(mask) <= 1` answers the palindrome question directly, with no need to store the actual path or its digit counts.

Complexity: O(n) time (every node visited once), O(h) extra space for the recursion stack, where `h` is the tree height.
