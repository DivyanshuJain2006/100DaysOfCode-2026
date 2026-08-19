import java.util.*;

public class Question2 {
    public static int closestValue(int[] p, double t) {
        int i = 0, best = -1;
        double diff = Double.MAX_VALUE;
        while (i < p.length && p[i] != -1) {
            int v = p[i];
            double d = Math.abs(v - t);
            if (d < diff || (d == diff && (best == -1 || v < best))) { 
                best = v; 
                diff = d;
            }
            if (t < v) {
            i = 2*i+1;
            } else if (t > v) {
                i = 2*i+2;
            } else {
                return v;
            }
        }
        return best;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of test cases: ");
        int t = sc.nextInt();
        while (t-- > 0) {
            System.out.print("Enter the number of nodes in the tree: ");
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
            System.out.print("Enter the target value: ");
            double target = sc.nextDouble();
            System.out.println("Tree : " + Arrays.toString(arr));
            System.out.print("The closest value to " + target + " in the BST is: " + closestValue(arr, target));
        }
        sc.close();
    }
}