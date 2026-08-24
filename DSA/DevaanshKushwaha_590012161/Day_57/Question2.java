import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int val) { this.val = val; }
}

public class Main {

    // Builds a binary tree from a level-order array where -1 marks a missing child
    static TreeNode buildTree(int[] arr) {
        if (arr.length == 0 || arr[0] == -1) return null;

        TreeNode root = new TreeNode(arr[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int i = 1;

        while (!queue.isEmpty() && i < arr.length) {
            TreeNode curr = queue.poll();

            if (i < arr.length) {
                int leftVal = arr[i++];
                if (leftVal != -1) {
                    curr.left = new TreeNode(leftVal);
                    queue.add(curr.left);
                }
            }
            if (i < arr.length) {
                int rightVal = arr[i++];
                if (rightVal != -1) {
                    curr.right = new TreeNode(rightVal);
                    queue.add(curr.right);
                }
            }
        }
        return root;
    }

    // Checks whether tree 'a' is the mirror image of tree 'b'
    static boolean isMirror(TreeNode a, TreeNode b) {
        if (a == null && b == null) return true;   // both empty -> mirrors
        if (a == null || b == null) return false;   // one empty, one not -> not mirrors
        return a.val == b.val
            && isMirror(a.left, b.right)   // a's left must mirror b's right
            && isMirror(a.right, b.left);  // a's right must mirror b's left
    }

    public static void main(String[] args) {
        int[] warehouse1 = {1, 2, 3};
        int[] warehouse2 = {1, 3, 2};

        TreeNode root1 = buildTree(warehouse1);
        TreeNode root2 = buildTree(warehouse2);

        System.out.println(isMirror(root1, root2) ? "YES" : "NO");
    }
}
