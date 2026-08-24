#include <stdio.h>
#include <stdlib.h>

struct TreeNode {
    int val;
    struct TreeNode *left;
    struct TreeNode *right;
};

struct TreeNode* createNode(int val) {
    struct TreeNode* node =
        (struct TreeNode*)malloc(sizeof(struct TreeNode));

    node->val = val;
    node->left = NULL;
    node->right = NULL;

    return node;
}

int areMirror(struct TreeNode* root1, struct TreeNode* root2) {

    
    if (root1 == NULL && root2 == NULL)
        return 1;

    if (root1 == NULL || root2 == NULL)
        return 0;

  
    if (root1->val != root2->val)
        return 0;


    return areMirror(root1->left, root2->right) &&
           areMirror(root1->right, root2->left);
}

int main() {

    struct TreeNode* root1 = createNode(1);
    root1->left = createNode(2);
    root1->right = createNode(3);

    struct TreeNode* root2 = createNode(1);
    root2->left = createNode(3);
    root2->right = createNode(2);

    if (areMirror(root1, root2))
        printf("YES\n");
    else
        printf("NO\n");

    return 0;
}
