class Solution {
    
    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public TreeNode[] splitBST(TreeNode root, int k) {
        if (root == null) {
            return new TreeNode[]{null, null};
        }

        if (root.val < k) {
            TreeNode[] temp = splitBST(root.right, k);

            root.right = temp[0];

            return new TreeNode[]{root, temp[1]};
        } else {
            TreeNode[] temp = splitBST(root.left, k);

            root.left = temp[1];

            return new TreeNode[]{temp[0], root};
        }
    }

    public void preorder(TreeNode root, StringBuilder ans) {
        if (root == null) {
            return;
        }

        ans.append(root.val).append(" ");
        preorder(root.left, ans);
        preorder(root.right, ans);
    }
}
