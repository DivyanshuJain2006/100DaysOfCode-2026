import java.util.*;

public class Main {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

  
    static TreeNode bstFromPreorder(int[] preorder) {

        if (preorder == null || preorder.length == 0) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[0]);

        TreeNode[] stack = new TreeNode[preorder.length];
        int top = 0;

        stack[top] = root;

        for (int i = 1; i < preorder.length; i++) {

            TreeNode node = new TreeNode(preorder[i]);

            if (preorder[i] < stack[top].val) {

                stack[top].left = node;

            } else {

                TreeNode parent = null;

                while (top >= 0 &&
                       preorder[i] > stack[top].val) {

                    parent = stack[top--];
                }

                parent.right = node;
            }

            stack[++top] = node;
        }

        return root;
    }

    static void inorder(TreeNode root) {

        if (root == null) {
            return;
        }

        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }

    static void preorderPrint(TreeNode root) {

        if (root == null) {
            return;
        }

        System.out.print(root.val + " ");
        preorderPrint(root.left);
        preorderPrint(root.right);
    }

    public static void main(String[] args) {

        int[] preorder = {8, 5, 1, 7, 10, 12};

        TreeNode root = bstFromPreorder(preorder);

        System.out.print("Inorder: ");
        inorder(root);

        System.out.println();

        System.out.print("Preorder: ");
        preorderPrint(root);
    }
}