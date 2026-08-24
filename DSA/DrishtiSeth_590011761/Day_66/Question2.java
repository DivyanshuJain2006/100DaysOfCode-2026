import java.util.*;

class Solution {

    // Inorder traversal
    static void inorder(TreeNode root, ArrayList<Integer> list) {

        if (root == null) {
            return;
        }

        inorder(root.left, list);

        list.add(root.val);

        inorder(root.right, list);
    }

    static ArrayList<Integer> corporateMerger(
            TreeNode root1,
            TreeNode root2) {

        ArrayList<Integer> list = new ArrayList<>();

        // Store elements of first BST
        inorder(root1, list);

        // Store elements of second BST
        inorder(root2, list);

        // Sort all elements
        Collections.sort(list);

        // Remove duplicates
        ArrayList<Integer> ans = new ArrayList<>();

        for (int x : list) {

            if (ans.size() == 0 ||
                ans.get(ans.size() - 1) != x) {

                ans.add(x);
            }
        }

        return ans;
    }
}
