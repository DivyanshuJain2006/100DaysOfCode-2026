//Need to find the lowest common ancestor of two employees

#include <iostream>
#include <vector>
#include <queue>
using namespace std;

struct Node
{
    int data;
    Node* left;
    Node* right;

    Node(int value)
    {
        data = value;
        left = nullptr;
        right = nullptr;
    }
};

Node* buildTree(vector<int>& arr)
{
    if (arr.empty() || arr[0] == -1)
        return nullptr;

    Node* root = new Node(arr[0]);
    queue<Node*> q;
    q.push(root);

    int i = 1;

    while (!q.empty() && i < arr.size())
    {
        Node* curr = q.front();
        q.pop();

        if (i < arr.size() && arr[i] != -1)
        {
            curr->left = new Node(arr[i]);
            q.push(curr->left);
        }
        i++;

        if (i < arr.size() && arr[i] != -1)
        {
            curr->right = new Node(arr[i]);
            q.push(curr->right);
        }
        i++;
    }

    return root;
}

bool exists(Node* root, int value)
{
    if (root == nullptr)
        return false;

    if (root->data == value)
        return true;

    return exists(root->left, value) || exists(root->right, value);
}

Node* lca(Node* root, int a, int b)
{
    if (root == nullptr || root->data == a || root->data == b)
        return root;

    Node* left = lca(root->left, a, b);
    Node* right = lca(root->right, a, b);

    if (left != nullptr && right != nullptr)
        return root;

    return left != nullptr ? left : right;
}

int main()
{
    vector<int> tree = {3, 5, 1, 6, 2, 0, 8, -1, -1, 7, 4};

    int a = 5;
    int b = 1;

    Node* root = buildTree(tree);

    if (!exists(root, a) || !exists(root, b))
    {
        cout << -1;
        return 0;
    }

    cout << lca(root, a, b)->data;

    return 0;
}
