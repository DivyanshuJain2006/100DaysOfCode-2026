import java.util.*;

class Question2 {
    static ArrayList<Integer> ans = new ArrayList<>();

    static void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        ans.add(root.val);
        inorder(root.right);
    }

    static int[] mergeTrees(TreeNode root1, TreeNode root2) {
        ans.clear();

        inorder(root1);
        inorder(root2);

        Collections.sort(ans);

        ArrayList<Integer> unique = new ArrayList<>();

        for (int x : ans) {
            if (unique.size() == 0 || unique.get(unique.size() - 1) != x) {
                unique.add(x);
            }
        }

        int[] result = new int[unique.size()];

        for (int i = 0; i < unique.size(); i++) {
            result[i] = unique.get(i);
        }

        return result;
    }
}