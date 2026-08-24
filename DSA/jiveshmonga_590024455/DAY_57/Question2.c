#include <stdio.h>
#include <stdlib.h>
typedef struct Node 
{
    int data;
    struct Node *left, *right;
} Node;
Node* newNode(int val) 
{
    Node* node = (Node*)malloc(sizeof(Node));
    node->data=val;
    node->left=node->right = NULL;
    return node;
}

int isMirror(Node* t1, Node* t2) 
{
    if (t1==NULL&&t2==NULL)
        return 1;
    if (t1==NULL||t2==NULL)
        return 0;
    return (t1->data==t2->data) &&
           isMirror(t1->left,t2->right) &&
           isMirror(t1->right,t2->left);
}
int main() 
{
    Node* t1=newNode(1);
    t1->left=newNode(2);
    t1->right=newNode(3);
    Node* t2=newNode(1);
    t2->left=newNode(3);
    t2->right=newNode(2);
    if (isMirror(t1, t2))
        printf("YES\n");
    else
        printf("NO\n");
    return 0;
}