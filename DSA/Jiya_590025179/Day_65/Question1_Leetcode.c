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
void inorder(struct TreeNode* root,int* values,int* n){
    if(root==NULL)return;
    inorder(root->left,values,n);
    values[(*n)++]=root->val;
    inorder(root->right,values,n);
}
int* findMode(struct TreeNode* root,int* returnSize){
    int values[10000],n=0;
    inorder(root,values,&n);
    int maxFreq=1,count=1;
    for(int i=1;i<n;i++){
        if(values[i]==values[i-1])count++;
        else count=1;
        if(count>maxFreq)maxFreq=count;
    }
    int* ans=malloc(n*sizeof(int));
    *returnSize=0;
    count=1;
    for(int i=1;i<=n;i++){
        if(i<n&&values[i]==values[i-1])count++;
        else{
            if(count==maxFreq)ans[(*returnSize)++]=values[i-1];
            count=1;
        }
    }
    return ans;
}
