#include <stdio.h>
#include <stdlib.h>

struct Node {
    int data;
    struct Node *left, *right;
};

struct Node* newNode(int data) {
    struct Node* node = (struct Node*)malloc(sizeof(struct Node));
    node->data=data;
    node->left=node->right=NULL;
    return node;
}
struct Node* insert(struct Node* root, int data) 
{
    if (root==NULL)
        return newNode(data);
    if (data<root->data)
        root->left=insert(root->left,data);
    else if (data>root->data)
        root->right=insert(root->right, data);
    return root;
}

int countNodes(struct Node* root) 
{
    if (root==NULL)
        return 0;
    return 1+countNodes(root->left)+countNodes(root->right);
}

void inorder(struct Node* root, int arr[], int *index) 
{
    if (root==NULL)
        return;
    inorder(root->left,arr,index);
    arr[(*index)++]=root->data;
    inorder(root->right, arr, index);
}

void mergeUnique(int a[], int n, int b[], int m) {
    int is=0,j=0;
    int last=-1000000000; 
    while (i<n&&j<m) 
    {
        int val;
        if (a[i]<b[j])
            val=a[i++];
        else if (a[i]>b[j])
            val=b[j++];
        else 
        {
            val=a[i];
            i++;
            j++;
        }
        if (val!=last) 
        {
            printf("%d ",val);
            last=val;
        }
    }
    while (i<n) 
    {
        if (a[i]!=last) 
        {
            printf("%d ",a[i]);
            last=a[i];
        }
        i++;
    }
    while (j < m) 
    {
        if (b[j]!=last) 
        {
            printf("%d ",b[j]);
            last=b[j];
        }
        j++;
    }
}
int main() 
{
    struct Node *tree1 = NULL, *tree2 = NULL;
    tree1 = insert(tree1, 2);
    tree1 = insert(tree1, 1);
    tree1 = insert(tree1, 3);
    tree2 = insert(tree2, 4);
    tree2 = insert(tree2, -1);
    tree2 = insert(tree2, 5);
    int n = countNodes(tree1);
    int m = countNodes(tree2);
    int arr1[n], arr2[m];
    int idx = 0;
    inorder(tree1, arr1, &idx);
    idx = 0;
    inorder(tree2, arr2, &idx);
    printf("Merged Sorted Unique Array:\n");
    mergeUnique(arr1, n, arr2, m);
    return 0;
}