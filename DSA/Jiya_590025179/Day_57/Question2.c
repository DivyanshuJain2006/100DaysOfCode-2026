#include <stdio.h>
#include <stdlib.h>
struct TreeNode {
    int val;
    struct TreeNode *l;
    struct TreeNode *r;
};
struct TreeNode* create(int val) {
    struct TreeNode* newnode=malloc(sizeof(struct TreeNode));
    newnode->val=val;
    newnode->l=NULL;
    newnode->r=NULL;
    return newnode;
}
struct TreeNode* make(int arr[],int n,int index) {
    if(index>=n||arr[index]==-1)
        return NULL;
    struct TreeNode* root=create(arr[index]);
    root->l=make(arr,n,2*index+1);
    root->r=make(arr,n,2*index+2);
    return root;
}
int isMirror(struct TreeNode* r1,struct TreeNode* r2) {
    if(r1==NULL&&r2==NULL)
        return 1;
    if(r1==NULL||r2==NULL)
        return 0;
    if(r1->val!=r2->val)
        return 0;
    return isMirror(r1->l,r2->r)&&
           isMirror(r1->r,r2->l);
}
int main() {
    int k;
    scanf("%d",&k);
    while(k--) {
        int n1,n2;
        int a[1000],b[1000];
        scanf("%d",&n1);
        for(int i=0;i<n1;i++)
            scanf("%d",&a[i]);
        scanf("%d",&n2);
        for(int i=0;i<n2;i++)
            scanf("%d",&b[i]);
        struct TreeNode* r1=make(a,n1,0);
        struct TreeNode* r2=make(b,n2,0);
        if(isMirror(r1,r2))
            printf("YES\n");
        else
            printf("NO\n");
    }
    return 0;
}
