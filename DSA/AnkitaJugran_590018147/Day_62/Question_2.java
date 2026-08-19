public class MaxRobbing {

    //class of tree node
    static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    static int rob( TreeNode root ){

        if( root == null ){
            return 0;
        }

        //if you rob the current node, you cannot rob its children

        int robRoot = root.val;

        if( root.left != null ){

            robRoot += rob( root.left.left );
            robRoot +=rob( root.left.right );
        }

        if( root.right != null ){

            robRoot += rob( root.right.left ); 
            robRoot += rob( root.right.right );
        }

        //if you don't rob the current node, you can rob its children
        int skipcurrentnode = rob( root.left ) + rob( root.right );

        return Math.max( robRoot, skipcurrentnode );
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(3);
        
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(1);

        System.out.println("Maximum amount that can be robbed: " + rob(root));
    }

}
