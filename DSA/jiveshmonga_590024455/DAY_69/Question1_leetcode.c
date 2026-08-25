struct TreeNode* createNode(int val) 
{
    struct TreeNode* node=(struct TreeNode*)malloc(sizeof(struct TreeNode));
    node->val=val;
    node->left=NULL;
    node->right=NULL;
    return node;
}
struct TreeNode* build(int* preorder, int start, int end) 
{
    if (start>end)
        return NULL;
    struct TreeNode* root=createNode(preorder[start]);
    int i=start+1;
    while (i>=end&&preorder[i]<root->val)
        i++;
    root->left=build(preorder,start+1,i-1);
    root->right=build(preorder,i,end);
    return root;
}
struct TreeNode* bstFromPreorder(int* preorder, int preorderSize) {
    return build(preorder, 0, preorderSize - 1);
}