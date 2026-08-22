import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
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

public class Question2 {
    public static TreeNode[] greatDivide(TreeNode root, int K) {
        if (root == null) {
            return new TreeNode[]{null, null};
        }
        if (root.val < K) {
            TreeNode[] rightSide = greatDivide(root.right, K);
            root.right = rightSide[0];
            
            return new TreeNode[]{root, rightSide[1]};
        } 
        else {
            TreeNode[] leftSide = greatDivide(root.left, K);
            
            root.left = leftSide[1];
            return new TreeNode[]{leftSide[0], root};
        }
    }

    private static void preorderTraversal(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        result.add(root.val);
        preorderTraversal(root.left, result);
        preorderTraversal(root.right, result);
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
        System.out.println("Enter the number of nodes in the tree array: ");
        int n = sc.nextInt();
        
        int[] treeArr = new int[n];
        System.out.println("Enter the " + n + " level-order elements (-1 for null):");
        for (int i = 0; i < n; i++) {
            treeArr[i] = sc.nextInt();
        }
            
        System.out.println("Enter the split value (K): ");
        int K = sc.nextInt();
            
        TreeNode root = buildTree(treeArr);
            
        TreeNode[] splitResult = greatDivide(root, K);
        TreeNode branchA = splitResult[0];
        TreeNode branchB = splitResult[1];
            
        List<Integer> preorderA = new ArrayList<>();
        preorderTraversal(branchA, preorderA);
        for (int i = 0; i < preorderA.size(); i++) {
            System.out.print(preorderA.get(i) + (i == preorderA.size() - 1 ? "" : " "));
        }
            
        List<Integer> preorderB = new ArrayList<>();
        preorderTraversal(branchB, preorderB);
        for (int i = 0; i < preorderB.size(); i++) {
            System.out.print(preorderB.get(i) + (i == preorderB.size() - 1 ? "" : " "));
        }
        sc.close();
    }
}