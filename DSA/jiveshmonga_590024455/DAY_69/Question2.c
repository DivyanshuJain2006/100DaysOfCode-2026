#include <stdio.h>
struct Node 
{
    int val;
    struct Node *left;
    struct Node *right;
};
void preorder(struct Node *root) 
{
    if (root==NULL)
        return;
    printf("%d ", root->val);
    preorder(root->left);
    preorder(root->right);
}
void splitBST(struct Node *root, int k,
              struct Node **small, struct Node **large) {  
    if (root == NULL) 
    {
        *small=NULL;
        *large=NULL;
        return;
    }
    if (root->val < k) 
    {
        *small=root;
        splitBST(root->right, k, &root->right, large);
    } 
    else 
    {
        *large=root;
        splitBST(root->left, k, small, &root->left);
    }
}
int main() 
{    
    struct Node n2 = {2,NULL,NULL};
    struct Node n7 = {7,NULL,NULL};
    struct Node n5 = {5,&n2,&n7};
    struct Node n12 = {12,NULL,NULL};
    struct Node n20 = {20,NULL,NULL};
    struct Node n15 = {15,&n12,&n20};
    struct Node n10 = {10,&n5,&n15};
    struct Node *small, *large;
    splitBST(&n10,10,&small,&large);
    printf("First BST: ");
    if (small==NULL)
        printf("EMPTY");
    else
        preorder(small);
    printf("\nSecond BST: ");
    if (large==NULL)
        printf("EMPTY");
    else
        preorder(large);
    return 0;
}