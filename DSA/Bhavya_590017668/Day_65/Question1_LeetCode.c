int prev;
int count;
int maxCount;
int first;

void inorderCount(struct TreeNode* root) {
    if (root == NULL)
        return;

    inorderCount(root->left);

    if (first || root->val != prev) {
        count = 1;
        prev = root->val;
        first = 0;
    } else {
        count++;
    }

    if (count > maxCount)
        maxCount = count;

    inorderCount(root->right);
}

void inorderResult(struct TreeNode* root, int* result, int* size) {
    if (root == NULL)
        return;

    inorderResult(root->left, result, size);

    if (first || root->val != prev) {
        count = 1;
        prev = root->val;
        first = 0;
    } else {
        count++;
    }

    if (count == maxCount) {
        result[*size] = root->val;
        (*size)++;
    }

    inorderResult(root->right, result, size);
}

int* findMode(struct TreeNode* root, int* returnSize) {
    int* result = malloc(10000 * sizeof(int));

    count = 0;
    maxCount = 0;
    first = 1;

    inorderCount(root);

    count = 0;
    first = 1;

    int size = 0;

    inorderResult(root, result, &size);

    *returnSize = size;

    return result;
}