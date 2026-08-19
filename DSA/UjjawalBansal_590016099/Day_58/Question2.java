import java.util.Scanner;

public class Question2 {

    private static int findLCA(int idx, int a, int b, int[] tree) {
        if (idx >= tree.length || tree[idx] == -1) {
            return -1;
        }
        
        if (tree[idx] == a || tree[idx] == b) {
            return tree[idx];
        }
        
        int left = findLCA(2 * idx + 1, a, b, tree);
        int right = findLCA(2 * idx + 2, a, b, tree);
        
        if (left != -1 && right != -1) {
            return tree[idx];
        }
        
        return (left != -1) ? left : right;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int t = sc.nextInt();
        
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int[] tree = new int[n];
            
            boolean foundA = false;
            boolean foundB = false;
            
            for (int j = 0; j < n; j++) {
                tree[j] = sc.nextInt();
            }
            
            int a = sc.nextInt();
            int b = sc.nextInt();
            
            for (int j = 0; j < n; j++) {
                if (tree[j] == a) foundA = true;
                if (tree[j] == b) foundB = true;
            }
            
            if (!foundA || !foundB) {
                System.out.println("-1");
            } 
            else {
                System.out.println(findLCA(0, a, b, tree));
            }
        }
        sc.close();
    }
}