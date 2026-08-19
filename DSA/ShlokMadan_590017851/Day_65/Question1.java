import java.util.*;

public class Question1
{
    static TreeNode prev = null;
    static int count = 1;
    static int maxCount = 0;
    static List<Integer> modes = new ArrayList<>();

    static void inorder(TreeNode node)
    {
        if (node == null)
            return;

        inorder(node.left);

        if (prev != null)
        {
            if (node.val == prev.val)
                count++;
            else
                count = 1;
        }

        if (count > maxCount)
        {
            maxCount = count;
            modes.clear();
            modes.add(node.val);
        }
        else if (count == maxCount)
        {
            modes.add(node.val);
        }

        prev = node;
        inorder(node.right);
    }

    static int[] findMode(TreeNode root)
    {
        inorder(root);
        int[] result = new int[modes.size()];
        for (int i = 0; i < modes.size(); i++)
            result[i] = modes.get(i);
        return result;
    }

    public static void main(String[] args)
    {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(2);

        int[] result = findMode(root);
        System.out.println(Arrays.toString(result));
    }
}

class TreeNode
{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val)
    {
        this.val = val;
    }
}