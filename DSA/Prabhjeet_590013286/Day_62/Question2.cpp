//Need to find the maximum money without robbing adjacent houses

#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>
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

pair<int, int> rob(Node* root)
{
    if (root == nullptr)
        return {0, 0};

    auto left = rob(root->left);
    auto right = rob(root->right);

    int take = root->data + left.second + right.second;
    int skip = max(left.first, left.second) +
               max(right.first, right.second);

    return {take, skip};
}

int main()
{
    vector<int> tree = {3, 2, 3, -1, 3, -1, 1};

    Node* root = buildTree(tree);

    auto ans = rob(root);

    cout << max(ans.first, ans.second);

    return 0;
}
