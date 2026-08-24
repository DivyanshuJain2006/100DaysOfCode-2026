#include <stdio.h>
#include <stdlib.h>
typedef struct Node {
    int data;
    struct Node *left;
    struct Node *right;
} Node;

Node* createNode(int data) {
    Node* newNode = (Node*)malloc(sizeof(Node));
    newNode->data = data;
    newNode->left = NULL;
    newNode->right = NULL;
    return newNode;
}

void robHelper(Node* root, int result[2]) {
    if (root == NULL) {
        result[0] = 0;
        result[1] = 0;
        return;
    }
    int left[2], right[2];
    robHelper(root->left, left);
    robHelper(root->right, right);
    result[0] = (left[0] > left[1] ? left[0] : left[1])
              + (right[0] > right[1] ? right[0] : right[1]);
    result[1] = root->data + left[0] + right[0];
}

int maxRob(Node* root) {
    int result[2];
    robHelper(root, result);
    return result[0] > result[1] ? result[0] : result[1];
}

int main() {
    int n;
    printf("Enter number of nodes: ");
    scanf("%d", &n);
    if (n <= 0) {
        printf("Maximum money = 0\n");
        return 0;
    }
    Node** nodes = (Node**)malloc(n * sizeof(Node*));
    int value;
    printf("Enter the values of the nodes in level order:\n");
    for (int i = 0; i < n; i++) {
        scanf("%d", &value);
        if (value == -1)
            nodes[i] = NULL;
        else
            nodes[i] = createNode(value);
    }
    for (int i = 0; i < n; i++) {
        if (nodes[i] != NULL) {
            int leftIndex = 2 * i + 1;
            int rightIndex = 2 * i + 2;
            if (leftIndex < n)
                nodes[i]->left = nodes[leftIndex];
            if (rightIndex < n)
                nodes[i]->right = nodes[rightIndex];
        }
    }
    printf("Maximum amount that can be robbed = %d\n", maxRob(nodes[0]));
    free(nodes);
return 0;
}