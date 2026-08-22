package Day_69;

import java.util.*;

public class d69question2_technical {
    public TreeNode[] splitBST(TreeNode root, int K) {
        if (root == null) {
            return new TreeNode[]{null, null};
        }

        if (root.val < K) {
            TreeNode[] parts = splitBST(root.right, K);

            root.right = parts[0];

            return new TreeNode[]{root, parts[1]};
        } else {
            TreeNode[] parts = splitBST(root.left, K);

            root.left = parts[1];

            return new TreeNode[]{parts[0], root};
        }
    }
}
