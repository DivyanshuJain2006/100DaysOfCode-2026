
import java.util.*;
class ME{
    static class Node{
        int data; Node left; Node right;
        Node(int data){
            this.data = data;
        }
    }
    static int countSafe(Node root, int maxSoFar){
        if(root == null){
            return 0;
        }
        int count = 0;
        if (root.data >= maxSoFar) {
            count = 1;
        }
        maxSoFar = Math.max(maxSoFar, root.data);
        count += countSafe(root.left, maxSoFar);
        count += countSafe(root.right, maxSoFar);
        return count;
    }
    static Node buildTree(int[] arr){
        if(arr.length == 0 || arr[0] == -1){
            return null;
        }
        Node root = new Node(arr[0]);
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        int i = 1;
        while(!q.isEmpty() && i < arr.length){
            Node current = q.poll();
            if(arr[i] != -1){
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
    public static void main(String[] args){
        int[] tree = {3, 1, 4, 3, 5, 1, 5};
        Node root = buildTree(tree);
        int answer = countSafe(root, root.data);
        System.out.println("Safe Campsites:" + answer);
    }
}