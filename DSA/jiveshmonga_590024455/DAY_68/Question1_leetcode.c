void inorder(struct TreeNode *root, int arr[], int *i) 
{
    if (root==NULL)
        return;
    inorder(root->left,arr,i);
    arr[(*i)++]=root->val;
    inorder(root->right,arr,i);
}
struct TreeNode* makeTree(int arr[], int left, int right) {
    if (left > right)
        return NULL;

    int mid = (left + right) / 2;

    struct TreeNode *node=(struct TreeNode*)malloc(sizeof(struct TreeNode));
    node->val=arr[mid];
    node->left=makeTree(arr,left,mid-1);
    node->right=makeTree(arr, mid + 1, right);
    return node;
}

struct TreeNode* balanceBST(struct TreeNode* root) {
    int arr[10000];
    int i=0;
    inorder(root,arr,&i);
    return makeTree(arr, 0, i - 1);
}