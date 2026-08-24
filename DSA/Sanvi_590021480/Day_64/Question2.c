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

int LCA(struct treenode* root,int a, int b){
    while(root!=NULL) {
        if(a<root->data && b<root->data) 
        root=root->left;
        else if(a>root->data && b>root->data)
        root=root->right;
        else 
        return root->data;
    }
    return -1;
}

int main(){

    int n;

    printf("Enter size of tree: ");
    scanf("%d",&n);
    int arr[n];
    printf("Enter nodes: ");
    for(int i=0;i<n;i++)  scanf("%d",&arr[i]);
    
    struct treenode* root=tree(arr,n,0);
    int a,b;
    printf("Enter a: ");
    scanf("%d",&a);
    printf("Enter b: ");
    scanf("%d",&b);

    int ans=LCA(root,a,b);
    printf("%d",ans);

    return 0;
}
