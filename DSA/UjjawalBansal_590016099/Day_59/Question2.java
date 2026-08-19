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
            
            int validPaths = dfs(0, 0, tree, n);
            System.out.println(validPaths);
        }
        sc.close();
    }
    
    static int dfs(int u, int mask, int[] tree, int n) {

        mask ^= (1 << tree[u]);
        
        int left = 2 * u + 1;
        int right = 2 * u + 2;
        
        boolean isLeftNull = (left >= n || tree[left] == -1);
        boolean isRightNull = (right >= n || tree[right] == -1);
        
        if (isLeftNull && isRightNull) {
            if ((mask & (mask - 1)) == 0) {
                return 1;
            } 
            else {
                return 0;
            }
        }
        return dfs(left, mask, tree, n) + dfs(right, mask, tree, n);
    }
}