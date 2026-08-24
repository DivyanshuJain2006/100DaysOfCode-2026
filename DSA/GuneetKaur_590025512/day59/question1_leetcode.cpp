#include<iostream>
#include<vector>
#include<queue>
using namespace std;

class Node{
    public:
    int data;
    Node* left;
    Node* right;

    Node(int val){
        data = val;
        left = NULL;
        right = NULL;
    }
    
    bool complete(Node* root){
        queue<Node*> q;
        q.push(root);
        bool found=false;
        while(!q.empty()){
        Node* curr=q.front();
        q.pop();
        if(curr==NULL){
            found=true;
        }
        else{
            if(found==true){
                return false;
            }
            q.push(curr->left);
            q.push(curr->right);
        

        }
        return true;
    }
    }
};