Class Solution{
public:
    int LowestCommonAncestor(TreeNode* root, int a, int b){
        while (root)
        {
            if(a< root->val && b< root->val) root=root->left;

            if(a> root->val && b> root->val) root=root->right;

            else  return root->val;
        }
        return -1;
    }
};