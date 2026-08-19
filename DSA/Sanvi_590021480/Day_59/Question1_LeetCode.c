/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     struct TreeNode *left;
 *     struct TreeNode *right;
 * };
 */
bool isCompleteTree(struct TreeNode* root) {
    struct TreeNode* q[10000];
    int f=0,r=0,flag=0;

    q[r++]=root;
    while(f<r){
        struct TreeNode* x=q[f++];
        if(x==NULL) flag=1;
        else{
            if(flag) return 0;
            q[r++]=x->left;
            q[r++]=x->right;
        }
    }
    return 1;
}
