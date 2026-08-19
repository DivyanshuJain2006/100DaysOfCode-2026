//Need one sorted list containing all unique values from both BSTs

#include <iostream>
#include <vector>
#include <set>
using namespace std;

struct Node
{
    int data;
    Node* left;
    Node* right;
};

void inorder(Node* root, set<int>& values)
{
    if (root == nullptr)
        return;

    inorder(root->left, values);
    values.insert(root->data);
    inorder(root->right, values);
}

int main()
{
    Node n1{1, nullptr, nullptr};
    Node n3{3, nullptr, nullptr};
    Node n2{2, &n1, &n3};

    Node n5{5, nullptr, nullptr};
    Node n4{4, nullptr, &n5};

    set<int> values;

    inorder(&n2, values);
    inorder(&n4, values);

    for (int value : values)
    {
        cout << value << " ";
    }

    return 0;
}
