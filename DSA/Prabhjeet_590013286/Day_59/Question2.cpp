//Need to count root to leaf paths whose digits can form a palindrome

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

int countPaths(Node* root, int mask)
{
    if (root == nullptr)
        return 0;

    mask ^= (1 << root->data);

    if (root->left == nullptr && root->right == nullptr)
    {
        // at most one digit can have an odd frequency
        return (mask & (mask - 1)) == 0 ? 1 : 0;
    }

    return countPaths(root->left, mask) +
           countPaths(root->right, mask);
}

int main()
{
    vector<int> tree = {2, 3, 1, 3, 1, -1, 1};

    Node* root = buildTree(tree);

    cout << countPaths(root, 0);

    return 0;
}
