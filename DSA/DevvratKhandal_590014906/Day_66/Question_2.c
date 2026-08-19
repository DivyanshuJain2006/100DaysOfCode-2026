#include <stdio.h>
#include <stdlib.h>

struct Node {
    int data;
    struct Node *left;
    struct Node *right;
};

struct Node* createNode(int data) {
    struct Node* newNode = (struct Node*)malloc(sizeof(struct Node));
    newNode->data = data;
    newNode->left = NULL;
    newNode->right = NULL;
    return newNode;
}

/* Build tree from level order */
struct Node* buildTree(int arr[], int n) {
    if (n == 0 || arr[0] == -1)
        return NULL;

    struct Node* root = createNode(arr[0]);

    struct Node* queue[2000];
    int front = 0, rear = 0;

    queue[rear++] = root;

    int i = 1;

    while (i < n) {
        struct Node* current = queue[front++];

        if (i < n && arr[i] != -1) {
            current->left = createNode(arr[i]);
            queue[rear++] = current->left;
        }
        i++;

        if (i < n && arr[i] != -1) {
            current->right = createNode(arr[i]);
            queue[rear++] = current->right;
        }
        i++;
    }

    return root;
}

/* Inorder traversal */
void inorder(struct Node* root, int result[], int *index) {
    if (root == NULL)
        return;

    inorder(root->left, result, index);

    result[(*index)++] = root->data;

    inorder(root->right, result, index);
}

/* Merge two sorted arrays and remove duplicates */
int mergeArrays(int a[], int n1, int b[], int n2, int result[]) {
    int i = 0, j = 0, k = 0;

    while (i < n1 && j < n2) {
        int value;

        if (a[i] < b[j]) {
            value = a[i++];
        }
        else if (a[i] > b[j]) {
            value = b[j++];
        }
        else {
            value = a[i];
            i++;
            j++;
        }

        if (k == 0 || result[k - 1] != value)
            result[k++] = value;
    }

    while (i < n1) {
        int value = a[i++];

        if (k == 0 || result[k - 1] != value)
            result[k++] = value;
    }

    while (j < n2) {
        int value = b[j++];

        if (k == 0 || result[k - 1] != value)
            result[k++] = value;
    }

    return k;
}

int main() {
    int t;

    printf("Enter number of test cases: ");
    scanf("%d", &t);

    while (t--) {
        int n1, n2;

        printf("\nEnter number of nodes in tree 1: ");
        scanf("%d", &n1);

        int tree1[n1];

        printf("Enter tree 1 in level order (-1 for NULL): ");
        for (int i = 0; i < n1; i++)
            scanf("%d", &tree1[i]);

        printf("Enter number of nodes in tree 2: ");
        scanf("%d", &n2);

        int tree2[n2];

        printf("Enter tree 2 in level order (-1 for NULL): ");
        for (int i = 0; i < n2; i++)
            scanf("%d", &tree2[i]);

        struct Node* root1 = buildTree(tree1, n1);
        struct Node* root2 = buildTree(tree2, n2);

        int arr1[1000], arr2[1000], result[2000];

        int index1 = 0;
        int index2 = 0;

        inorder(root1, arr1, &index1);
        inorder(root2, arr2, &index2);

        int size = mergeArrays(
            arr1, index1,
            arr2, index2,
            result
        );

        printf("Merged sorted array: [");

        for (int i = 0; i < size; i++) {
            if (i > 0)
                printf(", ");
            printf("%d", result[i]);
        }

        printf("]\n");
    }

    return 0;
}