
import java.util.*;
class CM{
    static class TreeNode {
        int val; TreeNode left; TreeNode right;
        TreeNode(int val) {
            this.val = val;
        }
    }
    static void inorder(TreeNode root, ArrayList<Integer> list) {
        if (root == null) {
            return;
        }
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }
    static ArrayList<Integer> getSortedUnique(
            TreeNode root1, TreeNode root2) {
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        inorder(root1, list1);
        inorder(root2, list2);
        ArrayList<Integer> ans = new ArrayList<>();
        int i = 0; int j = 0;
        while (i < list1.size() && j < list2.size()) {
            int value;
            if (list1.get(i) < list2.get(j)) {
                value = list1.get(i);
                i++;
            }
            else if (list1.get(i) > list2.get(j)) {
                value = list2.get(j);
                j++;
            }
            else {
                value = list1.get(i);
                i++;
                j++;
            }
            if (ans.isEmpty() ||
                ans.get(ans.size() - 1) != value) {

                ans.add(value);
            }
        }
        while (i < list1.size()) {
            int value = list1.get(i++);
            if (ans.isEmpty() || ans.get(ans.size() - 1) != value) {
                ans.add(value);
            }
        }
        while (j < list2.size()) {
            int value = list2.get(j++);
            if (ans.isEmpty() || ans.get(ans.size() - 1) != value) {
                ans.add(value);
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(2);
        root1.left = new TreeNode(1);
        root1.right = new TreeNode(3);
        TreeNode root2 = new TreeNode(4);
        root2.right = new TreeNode(5);
        ArrayList<Integer> result = getSortedUnique(root1, root2);
        System.out.println(result);
    }
}