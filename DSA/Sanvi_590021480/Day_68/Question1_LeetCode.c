/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     struct TreeNode *left;
 *     struct TreeNode *right;
 * };
 */
struct TreeNode* createnode(int val){
    struct TreeNode* newnode=malloc(sizeof(struct TreeNode));
    newnode->val=val;
    newnode->left=NULL;
    newnode->right=NULL;
    return newnode;
}

void inorder(struct TreeNode* root,int *arr,int *index){
    if(!root) return;
    inorder(root->left,arr,index);
    arr[(*index)++]=root->val;
    inorder(root->right,arr,index);
}
struct TreeNode* build(int *arr,int low,int high){
    if(low>high) return NULL;
    int mid=(low+high)/2;
    struct TreeNode* root=createnode(arr[mid]);
    root->left=build(arr,low,mid-1);
    root->right=build(arr,mid+1,high);
    return root;
}
struct TreeNode* balanceBST(struct TreeNode* root) {
    int arr[10000];
    int index=0;
    inorder(root,arr,&index);
    return build(arr,0,index-1);
}
