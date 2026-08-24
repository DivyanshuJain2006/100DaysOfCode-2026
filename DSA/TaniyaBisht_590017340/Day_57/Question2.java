
import java.util.*;
class TW{
    static class Node{
        int data;
        Node left, right;
        Node(int data) {
            this.data = data;
        }
    }
    static Node buildTree(int[] arr) {
        if(arr.length == 0 || arr[0] == -1)
            return null;
        Node root = new Node(arr[0]);
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        int i = 1;
        while(!q.isEmpty() && i < arr.length){
            Node current = q.poll();
            if(arr[i] != -1) {
                current.left = new Node(arr[i]);
                q.add(current.left);
            }
            i++;
            if(i < arr.length && arr[i] != -1){
                current.right = new Node(arr[i]);
                q.add(current.right);
            }
            i++;
        }
        return root;
    }
    static boolean isMirror(Node root1, Node root2){
        if(root1 == null && root2 == null)
            return true;
        if(root1 == null || root2 == null)
            return false;
        if(root1.data != root2.data)
            return false;
        return isMirror(root1.left, root2.right)
            && isMirror(root1.right, root2.left);
    }
    public static void main(String[] args){
        int[] warehouse1 = {1, 2, 3};
        int[] warehouse2 = {1, 3, 2};
        Node root1 = buildTree(warehouse1);
        Node root2 = buildTree(warehouse2);
        System.out.println(isMirror(root1, root2) ? "YES" : "NO");
    }
}