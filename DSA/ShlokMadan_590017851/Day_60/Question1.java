public class Question1
{
    static int diameter=0;
    static int height(TreeNode root)
    {
        if(root==null)
            return 0;
        int left=height(root.left);
        int right=height(root.right);
        diameter=Math.max(diameter,left+right);
        return 1+Math.max(left,right);
    }
    public static int diameterOfBinaryTree(TreeNode root)
    {
        diameter=0;
        height(root);
        return diameter;
    }
    public static void main(String[] args)
    {
        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(2);
        root.right=new TreeNode(3);
        root.left.left=new TreeNode(4);
        root.left.right=new TreeNode(5);
        System.out.println(diameterOfBinaryTree(root));
    }
}
class TreeNode
{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val)
    {
        this.val=val;
    }
}