//Need to find the closest temperature in the BST

#include <iostream>
#include <cmath>
using namespace std;

struct Node
{
    int data;
    Node* left;
    Node* right;
};

int closest(Node* root, int target)
{
    int answer = root->data;

    while (root != nullptr)
    {
        int diff = abs(root->data - target);
        int bestDiff = abs(answer - target);

        if (diff < bestDiff || (diff == bestDiff && root->data < answer))
        {
            answer = root->data;
        }

        if (root->data == target)
        {
            return root->data;
        }

        if (target < root->data)
            root = root->left;
        else
            root = root->right;
    }

    return answer;
}

int main()
{
    Node n1{1, nullptr, nullptr};
    Node n3{3, nullptr, nullptr};
    Node n2{2, &n1, &n3};
    Node n5{5, nullptr, nullptr};
    Node n4{4, &n2, &n5};

    int target = 3;

    cout << closest(&n4, target);

    return 0;
}
