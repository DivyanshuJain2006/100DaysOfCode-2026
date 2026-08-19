import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class Question2 {

    static void inorder(TreeNode root, ArrayList<Integer> list) {
        if (root == null) {
            return;
        }

        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }

    static int[] getAllElements(TreeNode root1, TreeNode root2) {
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();

        inorder(root1, list1);
        inorder(root2, list2);

        TreeSet<Integer> set = new TreeSet<>();
        set.addAll(list1);
        set.addAll(list2);

        int[] result = new int[set.size()];
        int i = 0;

        for (int value : set) {
            result[i++] = value;
        }

        return result;
    }

    public static void main(String[] args) {
        TreeNode tree1 = new TreeNode(2);
        tree1.left = new TreeNode(1);
        tree1.right = new TreeNode(3);

        TreeNode tree2 = new TreeNode(4);
        tree2.left = new TreeNode(-1);
        tree2.right = new TreeNode(5);

        int[] result = getAllElements(tree1, tree2);

        System.out.println(Arrays.toString(result));
    }
}