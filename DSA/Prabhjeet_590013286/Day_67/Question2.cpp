//Need to build a balanced BST and count each balance factor

#include <iostream>
#include <vector>
using namespace std;

struct Node
{
    int data;
    Node* left;
    Node* right;
};

Node* build(vector<int>& arr, int left, int right)
{
    if (left > right)
        return nullptr;

    int mid = left + (right - left) / 2;

    Node* root = new Node{arr[mid], nullptr, nullptr};

    root->left = build(arr, left, mid - 1);
    root->right = build(arr, mid + 1, right);

    return root;
}

int height(Node* root, int& minusOne, int& zero, int& plusOne)
{
    if (root == nullptr)
        return 0;

    int leftHeight = height(root->left, minusOne, zero, plusOne);
    int rightHeight = height(root->right, minusOne, zero, plusOne);

    int balance = leftHeight - rightHeight;

    if (balance == -1)
        minusOne++;
    else if (balance == 0)
        zero++;
    else if (balance == 1)
        plusOne++;

    return 1 + max(leftHeight, rightHeight);
}

int main()
{
    vector<int> arr = {1, 2, 3, 4, 5, 6, 7};

    Node* root = build(arr, 0, arr.size() - 1);

    int minusOne = 0;
    int zero = 0;
    int plusOne = 0;

    height(root, minusOne, zero, plusOne);

    cout << "[" << minusOne << ", "
         << zero << ", "
         << plusOne << "]";

    return 0;
}
