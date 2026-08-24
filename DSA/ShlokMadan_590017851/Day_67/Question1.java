class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val=val;
    }
}

public class Question1 {

    public static TreeNode deleteNode(TreeNode root, int key) {
        if(root==null)
            return null;

        if(key<root.val)
            root.left=deleteNode(root.left,key);

        else if(key>root.val)
            root.right=deleteNode(root.right,key);

        else {
            if(root.left==null)
                return root.right;

            if(root.right==null)
                return root.left;

            TreeNode temp=root.right;

            while(temp.left!=null)
                temp=temp.left;

            root.val=temp.val;
            root.right=deleteNode(root.right,temp.val);
        }

        return root;
    }

    public static void main(String[] args) {
        TreeNode root=new TreeNode(5);

        root.left=new TreeNode(3);
        root.right=new TreeNode(6);
        root.left.left=new TreeNode(2);
        root.left.right=new TreeNode(4);
        root.right.right=new TreeNode(7);

        int key=3;

        root=deleteNode(root,key);

        System.out.println("Node "+key+" deleted successfully.");
    }
}