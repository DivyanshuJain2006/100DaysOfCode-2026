//Need to find the lowest common ancestor in a BST

#include <iostream>
using namespace std;

struct Node
{
    int data;
    Node* left;
    Node* right;
};

Node* findLCA(Node* root, int a, int b)
{
    while (root != nullptr)
    {
        if (a < root->data && b < root->data)
        {
            root = root->left;
        }
        else if (a > root->data && b > root->data)
        {
            root = root->right;
        }
        else
        {
            return root;
        }
    }

    return nullptr;
}

int main()
{
    Node n0{0, nullptr, nullptr};
    Node n4{4, nullptr, nullptr};
    Node n7{7, nullptr, nullptr};
    Node n9{9, nullptr, nullptr};
    Node n2{2, &n0, &n4};
    Node n8{8, &n7, &n9};
    Node n6{6, &n2, &n8};

    int a = 2;
    int b = 8;

    Node* ans = findLCA(&n6, a, b);

    cout << (ans ? ans->data : -1);

    return 0;
}
