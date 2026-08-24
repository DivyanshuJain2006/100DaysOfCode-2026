import java.util.*;

class Solution {

    public TreeNode[] splitBST(TreeNode root, int K) {

        if (root == null) {
            return new TreeNode[]{null, null};
        }

        if (root.val < K) {

            // Root belongs to the smaller tree
            TreeNode[] result = splitBST(root.right, K);

            root.right = result[0];

            return new TreeNode[]{root, result[1]};
        }

        else {

            // Root belongs to the greater/equal tree
            TreeNode[] result = splitBST(root.left, K);

            root.left = result[1];

            return new TreeNode[]{result[0], root};
        }
    }

    public void preorder(TreeNode root, StringBuilder sb) {

        if (root == null)
            return;

        sb.append(root.val).append(" ");

        preorder(root.left, sb);
        preorder(root.right, sb);
    }
}