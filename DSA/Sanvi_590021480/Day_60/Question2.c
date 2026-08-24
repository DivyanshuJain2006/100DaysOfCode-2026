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

int max(int a,int b){
    return (a>b)?a:b;
}
int count=0;
void check(struct treenode* root, int maxval){
    if(root==NULL) return;
    if(root->data>=maxval){
        count++;
        maxval=root->data;
    }
    check(root->left,maxval);
    check(root->right,maxval);
}
int goodNodes(struct treenode* root){
count=0;
check(root,root->data);
return count;
}

int main(){

    int n;

    printf("Enter size of tree: ");
    scanf("%d",&n);
    int arr[n];
    printf("Enter nodes: ");
    for(int i=0;i<n;i++)  scanf("%d",&arr[i]);
    
    struct treenode* root=tree(arr,n,0);
    printf("%d",goodNodes(root));

    return 0;
}
