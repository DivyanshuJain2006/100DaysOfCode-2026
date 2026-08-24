import java.util.*;
class Question2 
{
    static class TreeNode 
    {
        int val;
        TreeNode left, right;

        TreeNode(int val) 
        {
            this.val = val;
        }
    }

    static TreeNode buildTree(int[] tree, int n) 
    {
        if (n == 0 || tree[0] == -1)
            return null;

        TreeNode root = new TreeNode(tree[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int i = 1;
        while (i < n) 
        {
            TreeNode current = queue.poll();
            if (i < n && tree[i] != -1) 
            {
                current.left = new TreeNode(tree[i]);
                queue.offer(current.left);
            }
            i++;

            if (i < n && tree[i] != -1) 
            {
                current.right = new TreeNode(tree[i]);
                queue.offer(current.right);
            }
            i++;
        }
        return root;
    }

    static int countSafe(TreeNode root, int maxAltitude) 
    {
        if (root == null)
            return 0;

        int count = 0;
        if (root.val >= maxAltitude)
            count = 1;

        maxAltitude = Math.max(maxAltitude, root.val);
        count += countSafe(root.left, maxAltitude);
        count += countSafe(root.right, maxAltitude);

        return count;
    }

    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) 
        {
            int n = sc.nextInt();
            int[] tree = new int[n];

            for (int i = 0; i < n; i++) 
            {
                tree[i] = sc.nextInt();
            }

            TreeNode root = buildTree(tree, n);
            int answer = countSafe(root, Integer.MIN_VALUE);
            System.out.println(answer);
        }

        sc.close();
    }
}