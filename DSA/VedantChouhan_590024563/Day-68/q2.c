#include <stdio.h>
#include <stdlib.h>
#include <limits.h>

struct Node {
    int val;
    struct Node *left;
    struct Node *right;
};

struct Node* createNode(int val) {
    struct Node* node =
        (struct Node*)malloc(sizeof(struct Node));

    node->val = val;
    node->left = NULL;
    node->right = NULL;

    return node;
}

/*
    Returns information about the subtree:

    size = number of nodes if it is a BST
    min  = minimum value
    max  = maximum value
    isBST = whether the subtree is a BST
*/
struct Info {
    int size;
    int min;
    int max;
    int isBST;
};

int largestBST = 0;

struct Info findLargestBST(struct Node* root) {

    if (root == NULL) {
        struct Info empty = {
            0,
            INT_MAX,
            INT_MIN,
            1
        };

        return empty;
    }

    struct Info left = findLargestBST(root->left);
    struct Info right = findLargestBST(root->right);

    struct Info current;

    /*
       Current subtree is a BST if:
       left subtree is BST
       right subtree is BST
       root > maximum of left
       root < minimum of right
    */
    if (left.isBST && right.isBST &&
        root->val > left.max &&
        root->val < right.min) {

        current.isBST = 1;

        current.size = left.size + right.size + 1;

        current.min = root->val < left.min
                      ? root->val : left.min;

        current.max = root->val > right.max
                      ? root->val : right.max;

        if (current.size > largestBST)
            largestBST = current.size;
    }
    else {
        current.isBST = 0;
        current.size = 0;
        current.min = INT_MIN;
        current.max = INT_MAX;
    }

    return current;
}

int main() {

    int n;
    scanf("%d", &n);

    /*
       For simplicity, input is given in level order.
       -1 represents a missing node.
    */

    int arr[1000];

    for (int i = 0; i < n; i++)
        scanf("%d", &arr[i]);

    /*
       Build tree using complete-tree indexing:
       left  = 2*i + 1
       right = 2*i + 2
    */

    struct Node* nodes[1000];

    for (int i = 0; i < n; i++) {
        if (arr[i] == -1)
            nodes[i] = NULL;
        else
            nodes[i] = createNode(arr[i]);
    }

    for (int i = 0; i < n; i++) {

        if (nodes[i] == NULL)
            continue;

        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n)
            nodes[i]->left = nodes[left];

        if (right < n)
            nodes[i]->right = nodes[right];
    }

    struct Node* root = nodes[0];

    findLargestBST(root);

    printf("%d\n", largestBST);

    return 0;
}