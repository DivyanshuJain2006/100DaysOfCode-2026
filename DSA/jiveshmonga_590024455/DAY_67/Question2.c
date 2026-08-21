#include <stdio.h>
#include <stdlib.h>
struct Node
{
    int val;
    struct Node *left;
    struct Node *right;
};
struct Node* createNode(int val)
{
    struct Node *node=(struct Node*)malloc(sizeof(struct Node));
    node->val=val;
    node->left=NULL;
    node->right=NULL;
    return node;
}
int buildBST(int arr[], int low, int high, int count[])
{
    if(low > high)
        return 0;
   int mid=(low+high)/2;
    struct Node *root=createNode(arr[mid]);
    int leftHeight=buildBST(arr,low,mid-1,count);
    int rightHeight=buildBST(arr,mid+1,high,count);

    root->left=NULL;   
    root->right=NULL;
    int bf=leftHeight-rightHeight;
    if(bf==-1)
        count[0]++;
    else if(bf==0)
        count[1]++;
    else if(bf==1)
        count[2]++;
    free(root);
    return (leftHeight>rightHeight?leftHeight:rightHeight)+1;
}
void balanceSpectrum(int arr[], int n, int result[])
{
    result[0]=result[1]=result[2]=0;
    buildBST(arr,0,n-1,result);
}
int main()
{
    int arr[]={1,2,3,4,5,6,7};
    int n=sizeof(arr)/sizeof(arr[0]);
    int result[3];
    balanceSpectrum(arr,n,result);
    printf("[%d, %d, %d]\n",result[0],result[1],result[2]);
    return 0;
}