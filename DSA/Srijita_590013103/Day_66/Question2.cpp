#include <bits/stdc++.h>
using namespace std;

struct Node {
    int data;
    Node* left;
    Node* right;

    Node(int val) {
        data = val;
        left = right = nullptr;
    }
};


Node* buildTree(vector<int>& a) {
    if (a.empty() || a[0] == -1)
        return nullptr;

    Node* root = new Node(a[0]);
    queue<Node*> q;
    q.push(root);

    int i = 1;

    while (!q.empty() && i < a.size()) {
        Node* curr = q.front();
        q.pop();

        // Left child
        if (i < a.size() && a[i] != -1) {
            curr->left = new Node(a[i]);
            q.push(curr->left);
        }
        i++;

        // Right child
        if (i < a.size() && a[i] != -1) {
            curr->right = new Node(a[i]);
            q.push(curr->right);
        }
        i++;
    }

    return root;
}


void inorder(Node* root, vector<int>& result) {
    if (!root)
        return;

    inorder(root->left, result);
    result.push_back(root->data);
    inorder(root->right, result);
}


vector<int> mergeUnique(vector<int>& a, vector<int>& b) {
    vector<int> ans;

    int i = 0, j = 0;

    while (i < a.size() && j < b.size()) {
        int value;

        if (a[i] < b[j]) {
            value = a[i++];
        }
        else if (b[j] < a[i]) {
            value = b[j++];
        }
        else {
            value = a[i];
            i++;
            j++;
        }

        if (ans.empty() || ans.back() != value)
            ans.push_back(value);
    }

    // Remaining elements
    while (i < a.size()) {
        if (ans.empty() || ans.back() != a[i])
            ans.push_back(a[i]);
        i++;
    }

    while (j < b.size()) {
        if (ans.empty() || ans.back() != b[j])
            ans.push_back(b[j]);
        j++;
    }

    return ans;
}

int main() {
    int t;
    cin >> t;

    while (t--) {
        int n1;
        cin >> n1;

        vector<int> tree1(n1);
        for (int& x : tree1)
            cin >> x;

        int n2;
        cin >> n2;

        vector<int> tree2(n2);
        for (int& x : tree2)
            cin >> x;

        Node* root1 = buildTree(tree1);
        Node* root2 = buildTree(tree2);

        vector<int> a, b;

        inorder(root1, a);
        inorder(root2, b);

        vector<int> ans = mergeUnique(a, b);

        for (int i = 0; i < ans.size(); i++) {
            if (i > 0)
                cout << " ";
            cout << ans[i];
        }

        cout << "\n";
    }

    return 0;
}