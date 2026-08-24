import java.util.*;

public class Question2 {
    public static int findLCA(int[] tree, int a, int b) {

        int indexA = -1;
        int indexB = -1;
        for (int i = 0; i < tree.length; i++) {
            if (tree[i] == a) indexA = i;

            if (tree[i] == b)  indexB = i;
            
        }
        if (indexA == -1 || indexB == -1) {
            return -1;
        }
        while (indexA != indexB) {

            if (indexA > indexB) {
                indexA = (indexA - 1) / 2;
            } else {
                indexB = (indexB - 1) / 2;
            }
        }
        return tree[indexA];
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of test cases:");
        int t = sc.nextInt();

        while (t-- > 0) {

            System.out.println("Enter the number of employees in the tree:");
            int n = sc.nextInt();

            int[] tree = new int[n];

            System.out.println("Enter the employee IDs in level order (-1 for null nodes):");

            for (int i = 0; i < n; i++) {
                tree[i] = sc.nextInt();
            }

            System.out.println("Tree: " + Arrays.toString(tree));

            System.out.println("Enter the two employees to find their lowest common ancestor:");

            int a = sc.nextInt();
            int b = sc.nextInt();

            int lca = findLCA(tree, a, b);

            if (lca == -1) {
                System.out.println(-1);
                System.out.println("One or both employees do not exist in the tree.");
            } else {
                System.out.println("Lowest Common Ancestor: " + lca);
            }
        }
        sc.close();
    }
}