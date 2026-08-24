import java.util.Scanner;

public class Question2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int t = sc.nextInt();
        
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int[] tree = new int[n];
            
            for (int j = 0; j < n; j++) {
                tree[j] = sc.nextInt();
            }
            
            if (n == 0 || tree[0] == -1) {
                System.out.println(0);
            } 
            else {
                System.out.println(countSafe(0, tree[0], tree, n));
            }
        }
        
        sc.close();
    }
    
    static int countSafe(int idx, int maxSoFar, int[] tree, int n) {
        if (idx >= n || tree[idx] == -1) {
            return 0;
        }
        
        int count = 0;
        
        if (tree[idx] >= maxSoFar) {
            count = 1;
            maxSoFar = tree[idx];
        }
        
        int left = 2 * idx + 1;
        int right = 2 * idx + 2;
        
        count += countSafe(left, maxSoFar, tree, n);
        count += countSafe(right, maxSoFar, tree, n);
        
        return count;
    }
}