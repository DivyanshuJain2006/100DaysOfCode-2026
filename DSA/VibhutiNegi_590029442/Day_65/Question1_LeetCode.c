/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     struct TreeNode *left;
 *     struct TreeNode *right;
 * };
 */
/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
int* findMode(struct TreeNode* root, int* returnSize) {
    int values[10000];
    int n = 0;
    void inorder(struct TreeNode* node) {
        if (node == NULL)
            return;
        inorder(node->left);
        values[n++] = node->val;
        inorder(node->right);
    }
    inorder(root);
    int maxFreq = 0;
    int i = 0;
    while (i < n) {
        int count = 1;
        int j = i + 1;
        while (j < n && values[j] == values[i]) {
            count++;
            j++;
        }
        if (count > maxFreq)
            maxFreq = count;

        i = j;
    }
    int* answer = (int*)malloc(n * sizeof(int));
    *returnSize = 0;
    i = 0;
    while (i < n) {
        int count = 1;
        int j = i + 1;
        while (j < n && values[j] == values[i]) {
            count++;
            j++;
        }
        if (count == maxFreq) {
            answer[(*returnSize)++] = values[i];
        }

        i = j;
    }
    return answer;
}