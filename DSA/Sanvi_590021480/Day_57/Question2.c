#include <stdio.h>
#include <stdlib.h>

struct treenode {
    int data;
    struct treenode *left;
    struct treenode *right;
};

struct treenode* create(int data){
    struct treenode* newnode=malloc(sizeof(struct treenode));
    newnode->data=data;
    newnode->left=NULL;
    newnode->right=NULL;
    return newnode;
}

struct treenode* tree(int arr[], int n, int i){
    if(i>=n || arr[i]==-1) return NULL;

    struct treenode* root=create(arr[i]);

    root->left=tree(arr,n,2*i+1);
    root->right=tree(arr,n,2*i+2);
    return root;
}

int isMirror(struct treenode* root1, struct treenode* root2){
    if(root1==NULL && root2==NULL) return 1;
    if(root1==NULL || root2==NULL) return 0;
    if(root1->data!=root2->data) return 0;
    return isMirror(root1->right,root2->left) && isMirror(root1->left,root2->right);
}

int main(){

    int n1,n2;
    int arr1[1000],arr2[1000];

    printf("Enter size of tree1: ");
    scanf("%d",&n1);
    printf("Enter nodes: ");
    for(int i=0;i<n1;i++)  scanf("%d",&arr1[i]);
    printf("Enter size of tree2: ");
    scanf("%d",&n2);
    printf("Enter nodes: ");
    for(int i=0;i<n2;i++)  scanf("%d",&arr2[i]);

    struct treenode* root1=tree(arr1,n1,0);
    struct treenode* root2=tree(arr2,n2,0);

    if(isMirror(root1,root2)) printf("YES");
    else printf("NO");

    return 0;
}
