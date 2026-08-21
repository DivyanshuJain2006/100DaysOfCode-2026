<h2 align="center">Week 10 Day 65 (18/08/2026)</h2>

## 1. Find Mode in Binary Search Tree (LeetCode #501)

### Solution

```c
#include <stdio.h>
#include <stdlib.h>
#include <limits.h>

#define NIL INT_MIN /* sentinel marking a missing node in the input array */
#define MAXN 10000

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

/* Standard LeetCode-style level-order build: NIL entries are skipped. */
TreeNode* buildTree(int *vals, int n) {
    if (n == 0 || vals[0] == NIL) return NULL;

    TreeNode* root = newNode(vals[0]);
    TreeNode* q[MAXN];
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

/* Globals used during the single inorder pass */
int g_hasPrev = 0;
int g_prevVal = 0;
int g_curCount = 0;
int g_maxCount = 0;
int g_modes[MAXN];
int g_modeCount = 0;

void inorder(TreeNode* node) {
    if (!node) return;

    inorder(node->left);

    if (g_hasPrev && node->val == g_prevVal) g_curCount++;
    else g_curCount = 1;

    if (g_curCount > g_maxCount) {
        g_maxCount = g_curCount;
        g_modeCount = 0;
        g_modes[g_modeCount++] = node->val;
    } else if (g_curCount == g_maxCount) {
        g_modes[g_modeCount++] = node->val;
    }

    g_prevVal = node->val;
    g_hasPrev = 1;

    inorder(node->right);
}

void resetState(void) {
    g_hasPrev = 0;
    g_curCount = 0;
    g_maxCount = 0;
    g_modeCount = 0;
}

void printModes(void) {
    printf("[");
    for (int i = 0; i < g_modeCount; i++) {
        printf("%d%s", g_modes[i], (i == g_modeCount - 1) ? "" : ",");
    }
    printf("]\n");
}

int main(void) {
    int v1[] = {1, NIL, 2, 2};
    TreeNode* r1 = buildTree(v1, 4);
    resetState();
    inorder(r1);
    printModes(); // [2]

    int v2[] = {0};
    TreeNode* r2 = buildTree(v2, 1);
    resetState();
    inorder(r2);
    printModes(); // [0]

    return 0;
}
```

How it works: this BST allows duplicates (`left <= node <= right`), which means an inorder traversal — always non-decreasing — groups every occurrence of a value **consecutively**. So a single inorder pass can track a running streak count against the previous value seen: whenever the current streak beats the best-so-far, the mode list is reset to just this value; whenever it ties the best, this value is appended too. No extra pass or hash map is needed, satisfying the O(1)-extra-space follow-up (beyond the recursion stack).

Complexity: O(n) time, O(1) extra space excluding the recursion stack (O(h) for that) and the output array itself.

---

## 2. The Thermostat

### Solution

```c
#include <stdio.h>
#include <stdlib.h>
#include <math.h>

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

/* 1-indexed heap-style build: node at position i (1-indexed) has children
   at positions 2i and 2i+1. tree[] is stored 0-indexed, so position i maps
   to array index i-1. -1 or an out-of-range position means missing. */
TreeNode* build(int *tree, int n, int pos) {
    if (pos > n || tree[pos - 1] == -1) return NULL;

    TreeNode* node = newNode(tree[pos - 1]);
    node->left = build(tree, n, 2 * pos);
    node->right = build(tree, n, 2 * pos + 1);
    return node;
}

int closestValue(TreeNode* root, double target) {
    int best = root->val;
    double bestDiff = fabs(root->val - target);

    TreeNode* cur = root;
    while (cur) {
        double diff = fabs(cur->val - target);
        if (diff < bestDiff || (diff == bestDiff && cur->val < best)) {
            best = cur->val;
            bestDiff = diff;
        }

        if (target < cur->val) cur = cur->left;
        else if (target > cur->val) cur = cur->right;
        else break;
    }
    return best;
}

int main(void) {
    int t1[] = {4, 2, 5, 1, 3, -1, -1};
    TreeNode* r1 = build(t1, 7, 1);
    printf("%d\n", closestValue(r1, 3.0)); // 3

    int t2[] = {4, 2, 5, 1, 3, -1, -1};
    TreeNode* r2 = build(t2, 7, 1);
    printf("%d\n", closestValue(r2, 3.7)); // 4

    int t3[] = {1, -1, 3};
    TreeNode* r3 = build(t3, 3, 1);
    printf("%d\n", closestValue(r3, 2.0)); // 1

    return 0;
}
```

Note the indexing convention here is **1-indexed** (children of position `i` sit at `2i` and `2i+1`), unlike the more common 0-indexed `2i+1`/`2i+2` scheme seen in earlier days' problems — the build function maps 1-indexed positions to the underlying 0-indexed C array accordingly.

How it works: standard BST search, but instead of stopping at an exact match, every node visited along the way is compared against the current best candidate. A node replaces the best if it's strictly closer to `target`, or if it ties on distance and has a smaller value (the required tie-break). Since `target < cur->val` and `target > cur->val` still correctly steer the search toward closer values even while comparisons happen, the walk terminates either at an exact match or a leaf, having checked every node that could possibly be closest along that single root-to-leaf path.

Complexity: O(h) time per query (h = tree height), O(1) extra space (iterative).
