import java.util.*;
public class Question1 
{
    static class TreeNode 
    {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) 
        {
            this.val = val;
        }
    }
    public static boolean isCompleteTree(TreeNode root) 
    {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean foundNull = false;
        while(!queue.isEmpty()) 
            {
            TreeNode current = queue.poll();
            if(current == null) 
                {
                foundNull = true;
                continue;
            }
            if(foundNull)
                return false;
            queue.add(current.left);
            queue.add(current.right);
        }
        return true;
    }
    public static void main(String[] args) 
    {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        System.out.println(isCompleteTree(root));
    }
}