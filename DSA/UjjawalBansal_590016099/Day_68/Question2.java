import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    
    TreeNode(int val) {
        this.val = val;
    }
}

class NodeInfo {
    boolean isBst;
    int size;
    long min;
    long max;

    NodeInfo(boolean isBst, int size, long min, long max) {
        this.isBst = isBst;
        this.size = size;
        this.min = min;
        this.max = max;
    }
}

public class Question2 {
    private static int maxS = 0;
    private static NodeInfo postOrder(TreeNode node) {
        if (node == null) {
            return new NodeInfo(true, 0, Long.MAX_VALUE, Long.MIN_VALUE);
        }
        NodeInfo left = postOrder(node.left);
        NodeInfo right = postOrder(node.right);

        if (left.isBst && right.isBst && node.val > left.max && node.val < right.min) {
            int currSize = left.size + right.size + 1;
            maxS = Math.max(maxS, currSize);
            
            long currMin = Math.min(node.val, left.min);
            long currMax = Math.max(node.val, right.max);
            
            return new NodeInfo(true, currSize, currMin, currMax);
        }
        return new NodeInfo(false, 0, 0, 0);
    }

    public static int largestBSTSubtree(TreeNode root) {
        maxS = 0;
        postOrder(root);
        return maxS;
    }

    public static TreeNode buildTree(int[] arr) {
        if (arr == null || arr.length == 0 || arr[0] == -1) {
            return null;
        }
        
        TreeNode root = new TreeNode(arr[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        int i = 1;
        while (!queue.isEmpty() && i < arr.length) {
            TreeNode current = queue.poll();
            
            if (arr[i] != -1) {
                current.left = new TreeNode(arr[i]);
                queue.offer(current.left);
            }
            i++;
            
            if (i < arr.length && arr[i] != -1) {
                current.right = new TreeNode(arr[i]);
                queue.offer(current.right);
            }
            i++;
        }
        
        return root;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);            
        System.out.println("Enter the number of elements in the tree array:");
        int n = sc.nextInt();
                
        int[] treeArr = new int[n];
        System.out.println("Enter the " + n + " level-order elements (-1 for null):");
        for (int i = 0; i < n; i++) {
            treeArr[i] = sc.nextInt();
        }

        TreeNode root = buildTree(treeArr);
        int result = largestBSTSubtree(root);
                
        System.out.println("Largest BST Subtree Size: " + result);
        sc.close();
        
    }
}