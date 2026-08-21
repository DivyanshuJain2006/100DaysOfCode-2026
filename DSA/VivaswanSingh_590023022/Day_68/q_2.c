#include <limits.h>

typedef struct
{
    int isBST;
    int min;
    int max;
    int size;
} Info;

Info findLargestBST(struct TreeNode* root, int* answer)
{
    if (root == NULL)
    {
        Info empty = {1, INT_MAX, INT_MIN, 0};
        return empty;
    }

    Info left = findLargestBST(root->left, answer);
    Info right = findLargestBST(root->right, answer);

    Info current;

    if (left.isBST && right.isBST &&
        root->val > left.max &&
        root->val < right.min)
    {
        current.isBST = 1;
        current.size = left.size + right.size + 1;

        current.min = (left.size == 0) ? root->val : left.min;
        current.max = (right.size == 0) ? root->val : right.max;

        if (current.size > *answer)
            *answer = current.size;
    }
    else
    {
        current.isBST = 0;
        current.size = 0;
        current.min = INT_MIN;
        current.max = INT_MAX;
    }

    return current;
}

int largestBSTSubtree(struct TreeNode* root)
{
    int answer = 0;

    findLargestBST(root, &answer);

    return answer;
}