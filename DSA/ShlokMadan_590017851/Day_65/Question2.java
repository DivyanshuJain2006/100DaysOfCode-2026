
public class Question2
{
    static TreeNode buildTree(int[] arr, int i, int n)
    {
        if (i > n || arr[i - 1] == -1)
            return null;

        TreeNode node = new TreeNode(arr[i - 1]);
        node.left = buildTree(arr, 2 * i, n);
        node.right = buildTree(arr, 2 * i + 1, n);
        return node;
    }

    static int closestValue(TreeNode root, double target)
    {
        int best = root.val;
        double bestDiff = Math.abs(root.val - target);
        TreeNode curr = root;

        while (curr != null)
        {
            double diff = Math.abs(curr.val - target);
            if (diff < bestDiff || (diff == bestDiff && curr.val < best))
            {
                bestDiff = diff;
                best = curr.val;
            }

            if (target < curr.val)
                curr = curr.left;
            else if (target > curr.val)
                curr = curr.right;
            else
                break;
        }

        return best;
    }

    public static void main(String[] args)
    {
        int[] arr = {4, 2, 5, 1, 3, -1, -1};
        TreeNode root = buildTree(arr, 1, arr.length);

        System.out.println(closestValue(root, 3));
        System.out.println(closestValue(root, 3.7));

        int[] arr2 = {1, -1, 3};
        TreeNode root2 = buildTree(arr2, 1, arr2.length);
        System.out.println(closestValue(root2, 2));
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