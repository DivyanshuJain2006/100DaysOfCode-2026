#include <stdio.h>
#include <stdlib.h>
struct Node {
    int data;
    struct Node *left;
    struct Node *right;
};
struct Node* createNode(int value) {
    struct Node* newNode = (struct Node*)malloc(sizeof(struct Node));
    newNode->data = value;
    newNode->left = NULL;
    newNode->right = NULL;
    return newNode;
}
struct Node* insert(struct Node* root, int value) {
    if (root == NULL)
        return createNode(value);
    if (value < root->data)
        root->left = insert(root->left, value);
    else if (value > root->data)
        root->right = insert(root->right, value);
    return root;
}
void inorder(struct Node* root, int arr[], int *index) {
    if (root == NULL)
        return;
    inorder(root->left, arr, index);
    arr[*index] = root->data;
    (*index)++;
    inorder(root->right, arr, index);
}
int main() {
    int t;
    scanf("%d", &t);
    while (t--) {
        int n1, n2;
        scanf("%d", &n1);
        struct Node* root1 = NULL;
        for (int i = 0; i < n1; i++) {
            int value;
            scanf("%d", &value);
            if (value != -1)
                root1 = insert(root1, value);
        }
        scanf("%d", &n2);
        struct Node* root2 = NULL;
        for (int i = 0; i < n2; i++) {
            int value;
            scanf("%d", &value);
            if (value != -1)
                root2 = insert(root2, value);
        }
        int arr1[n1], arr2[n2];
        int size1 = 0, size2 = 0;
        inorder(root1, arr1, &size1);
        inorder(root2, arr2, &size2);
        int i = 0, j = 0;
        while (i < size1 && j < size2) {
            if (arr1[i] < arr2[j]) {
                printf("%d ", arr1[i]);
                i++;
            }
            else if (arr2[j] < arr1[i]) {
                printf("%d ", arr2[j]);
                j++;
            }
            else {
                printf("%d ", arr1[i]);
                i++;
                j++;
            }
        }
        while (i < size1) {
            printf("%d ", arr1[i]);
            i++;
        }
        while (j < size2) {
            printf("%d ", arr2[j]);
            j++;
        }
        printf("\n");
    }
    return 0;
}