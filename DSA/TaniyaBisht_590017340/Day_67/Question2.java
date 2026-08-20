
import java.util.*;
class BS{
    static class TreeNode{
        int val;TreeNode left;TreeNode right;
        TreeNode(int val) {
            this.val = val;
        }
    }
    static TreeNode buildBST(int[] arr, int left, int right){
        if(left > right){
            return null;
        }
        int mid = left+ (right - left) / 2;
        TreeNode root = new TreeNode(arr[mid]);
        root.left = buildBST(arr, left, mid - 1);
        root.right = buildBST(arr, mid + 1, right);
        return root;
    }
    static int height(TreeNode root, int[] count){
        if(root == null){
            return 0;
        }
        int leftHeight = height(root.left, count);
        int rightHeight = height(root.right, count);
        int balance = leftHeight - rightHeight;
        if(balance == -1){
            count[0]++;
        }
        else if(balance == 0){
            count[1]++;
        }
        else if(balance == 1){
            count[2]++;
        }
        return 1 + Math.max(leftHeight, rightHeight);
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        TreeNode root = buildBST(arr, 0, arr.length - 1);
        int[] count = new int[3];
        height(root, count);
        System.out.println("[" + count[0] + ", " + count[1] + ", "+ count[2] + "]");
    }
}