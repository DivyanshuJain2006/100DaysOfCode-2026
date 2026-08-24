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
    private static void inOrderTraverse(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        inOrderTraverse(root.left, list);
        list.add(root.val);
        inOrderTraverse(root.right, list);
    }

    public static List<Integer> mergeLists(List<Integer> l1, List<Integer> l2) {
        List<Integer> ans = new ArrayList<>();
        int i = 0;
        int j = 0;
        
        while (i < l1.size() && j < l2.size()) {
            int val1 = l1.get(i);
            int val2 = l2.get(j);
            int smaller;
            
            if (val1 < val2) {
                smaller = val1;
                i++;
            } 
            else if (val1 > val2) {
                smaller = val2;
                j++;
            } 
            else {
                smaller = val1;
                i++;
                j++;
            }
            
            if (ans.isEmpty() || ans.get(ans.size() - 1) != smaller) {
                ans.add(smaller);
            }
        }
        
        while (i < l1.size()) {
            int val1 = l1.get(i);
            if (ans.isEmpty() || ans.get(ans.size() - 1) != val1) {
                ans.add(val1);
            }
            i++;
        }
        
        while (j < l2.size()) {
            int val2 = l2.get(j);
            if (ans.isEmpty() || ans.get(ans.size() - 1) != val2) {
                ans.add(val2);
            }
            j++;
        }
        
        return ans;
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
            TreeNode curr = queue.poll();
            
            if (arr[i] != -1) {
                curr.left = new TreeNode(arr[i]);
                queue.offer(curr.left);
            }
            i++;
            
            if (i < arr.length && arr[i] != -1) {
                curr.right = new TreeNode(arr[i]);
                queue.offer(curr.right);
            }
            i++;
        }
        
        return root;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter n1 for Tree 1:");
        int n1 = sc.nextInt();
        int[] tree1Arr = new int[n1];
        System.out.println("Enter the " + n1 + " level-order elements for Tree 1:");
        for (int i = 0; i < n1; i++) {
            tree1Arr[i] = sc.nextInt();
        }
                
        System.out.println("Enter n2 for Tree 2:");
        int n2 = sc.nextInt();
        int[] tree2Arr = new int[n2];
        System.out.println("Enter the " + n2 + " level-order elements for Tree 2:");
        for (int i = 0; i < n2; i++) {
            tree2Arr[i] = sc.nextInt();
        }
                
        TreeNode root1 = buildTree(tree1Arr);
        TreeNode root2 = buildTree(tree2Arr);
                
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        inOrderTraverse(root1, list1);
        inOrderTraverse(root2, list2);
                
        List<Integer> result = mergeLists(list1, list2);
        System.out.println("Merged Sorted Unique IDs: " + result);
        sc.close();
    }
}