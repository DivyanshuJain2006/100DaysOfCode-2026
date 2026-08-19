import java.util.*;
public class Question2 {
    public static int findLCA(int[] tree, int a, int b) {
        int i = 0;
        while (tree[i] != -1) {
            int current = tree[i];

            if (a < current && b < current) {
                i = 2 * i + 1;
            } 
            else if (a > current && b > current) {
                i = 2 * i + 2;
            } 
            else {
                return current;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of test cases: ");
        int t = sc.nextInt();

        while (t-- > 0) {

            System.out.print("Enter the number of nodes: ");
            int n = sc.nextInt();

            int[] tree = new int[n];

            System.out.println("Enter the level-order representation of the BST:");
            for (int i = 0; i < n; i++) {
                tree[i] = sc.nextInt();
            }

            System.out.print("Enter the value of first node : ");
            int a = sc.nextInt();

            System.out.print("Enter the value of second node : ");
            int b = sc.nextInt();
            System.out.println("Tree: " + Arrays.toString(tree));
            int lca = findLCA(tree, a, b);
          
            System.out.println("Lowest Common Ancestor: " + lca);
            System.out.println();
        }
        sc.close();
    }
}