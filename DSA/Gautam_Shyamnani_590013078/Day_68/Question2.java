import java.util.*; 
 
public class Question2 { 
 
    static long[] tree; 
 
    static class Info { 
        boolean isBST; 
        int size; 
        long minVal; 
        long maxVal; 
 
        Info(boolean isBST, int size, long minVal, long maxVal) { 
            this.isBST = isBST; 
            this.size = size; 
            this.minVal = minVal; 
            this.maxVal = maxVal; 
        } 
    } 
 
    static Info findLargestBST(int i, int n) { 
 
        if (i >= n || tree[i] == -1) { 
            return new Info(true, 0, Long.MAX_VALUE, Long.MIN_VALUE); 
        } 

        Info left = findLargestBST(2 * i + 1, n); 
        Info right = findLargestBST(2 * i + 2, n); 
 
        long value = tree[i]; 

        if (left.isBST && right.isBST && 
            left.maxVal < value && 
            value < right.minVal) { 
 
            return new Info( 
                true, 
                left.size + right.size + 1, 
                Math.min(value, left.minVal), 
                Math.max(value, right.maxVal) 
            ); 
        } 

        return new Info( 
            false, 
            Math.max(left.size, right.size), 
            Long.MIN_VALUE, 
            Long.MAX_VALUE 
        ); 
    } 
 
    public static void main(String[] args) { 
 
        Scanner sc = new Scanner(System.in); 
 
        int n = sc.nextInt(); 
 
        tree = new long[n]; 
 
        for (int i = 0; i < n; i++) { 
            tree[i] = sc.nextLong(); 
        } 
 
        Info answer = findLargestBST(0, n); 
 
        System.out.println(answer.size); 
 
        sc.close(); 
    } 
}