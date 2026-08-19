import java.util.*;
public class Question2 {
    public static int closestValue(int[] tree, double target) {
        int i = 0;
        int best = -1;
        double bestDiff = Double.MAX_VALUE;
        while (i < tree.length && tree[i] != -1) {
            int curr = tree[i];
            double diff = Math.abs(curr - target);
            if (diff < bestDiff ||
                (diff == bestDiff && (best == -1 || curr < best))) {
                best = curr;
                bestDiff = diff;
            }
            if (target < curr) {
                i = 2 * i + 1;
            } else if (target > curr) {
                i = 2 * i + 2;
            } else {
                return curr;
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
            int[] tree = new int[n];
            for (int i = 0; i < n; i++) {
                tree[i] = sc.nextInt();
            }
            System.out.print("Enter the target value: ");
            double target = sc.nextDouble();
            System.out.println("Tree : " + Arrays.toString(tree));
            System.out.print("The closest value to " + target + " in the BST is: " + closestValue(tree, target));

        }
        sc.close();
    }
}