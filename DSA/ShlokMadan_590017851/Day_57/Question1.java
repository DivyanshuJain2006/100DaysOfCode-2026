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
    public static int sumOfLeftLeaves(TreeNode root) 
    {
        if(root == null)
            return 0;
        int sum = 0;
        if(root.left != null) 
            {
            if(root.left.left == null && root.left.right == null)
                sum += root.left.val;
            else
                sum += sumOfLeftLeaves(root.left);
        }
        sum += sumOfLeftLeaves(root.right);
        return sum;
    }
    public static void main(String[] args) 
    {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(sumOfLeftLeaves(root));
    }
}