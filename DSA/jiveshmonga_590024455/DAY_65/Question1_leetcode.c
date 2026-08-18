
#include <stdlib.h>
int count, maxCount, modeCount;
struct TreeNode *prev;
int *modes;
void inorder(struct TreeNode *root, int collect)
{
    if (root==NULL)
        return;
    inorder(root->left,collect);
    if (prev==NULL)
        count=1;
    else if (prev->val==root->val)
        count++;
    else
        count=1;
    if (count>maxCount)
    {
        maxCount=count;
        modeCount=1;
        if (collect)
            modes[0]=root->val;
    }
    else if(count==maxCount)
    {
        if (collect)
            modes[modeCount]=root->val;
        modeCount++;
    }
    prev=root;
    inorder(root->right,collect);
}

int* findMode(struct TreeNode* root, int* returnSize)
{
    count=0;
    maxCount=0;
    modeCount=0;
    prev=NULL;
    inorder(root,0);
    modes=(int *)malloc(modeCount * sizeof(int));
    count=0;
    modeCount=0;
    prev=NULL;
    inorder(root,1);
    *returnSize=modeCount;
    return modes;
}