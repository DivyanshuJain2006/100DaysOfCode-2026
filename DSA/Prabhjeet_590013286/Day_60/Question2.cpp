//Need to count nodes that are never smaller than anything before them

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

int countSafe(Node* root, int maxValue)
{
    if (root == nullptr)
        return 0;

    int count = 0;

    if (root->data >= maxValue)
    {
        count = 1;
        maxValue = root->data;
    }

    count += countSafe(root->left, maxValue);
    count += countSafe(root->right, maxValue);

    return count;
}

int main()
{
    vector<int> tree = {3, 1, 4, 3, -1, 1, 5};

    Node* root = buildTree(tree);

    cout << countSafe(root, root->data);

    return 0;
}
