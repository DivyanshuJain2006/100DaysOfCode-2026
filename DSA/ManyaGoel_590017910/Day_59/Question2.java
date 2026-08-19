import java.util.*;

public class Question2 {
    private static long countValidPasscodes(int[] tree, int n) {
        if (n == 0 || tree[0] == -1) {
            return 0;
        }
        long count = 0;
        int[] indexStack = new int[n];
        int[] maskStack = new int[n];
        int top = 0;
        indexStack[top] = 0;
        maskStack[top] = 1 << tree[0];
        top++;
        while (top > 0) {
            --top;
            int idx = indexStack[top];
            int mask = maskStack[top];
            int left = 2 * idx + 1;
            int right = left + 1;
            boolean hasLeft = left < n && tree[left] != -1;
            boolean hasRight = right < n && tree[right] != -1;
            if (!hasLeft && !hasRight) {
                if ((mask & (mask - 1)) == 0) {
                    count++;
                }
                continue;
            }
            if (hasLeft) {
                indexStack[top] = left;
                maskStack[top] = mask ^ (1 << tree[left]);
                top++;
            }
            if (hasRight) {
                indexStack[top] = right;
                maskStack[top] = mask ^ (1 << tree[right]);
                top++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        System.out.print("Enter number of test cases : ");
        int t = sc.nextInt();
        while (t-- > 0) {
            System.out.print("Enter size of array : ");
            int n = sc.nextInt();
            System.out.print("Enter " + n + " tree values: ");
            int[] tree = new int[n];
            for (int i = 0; i < n; i++) {
                tree[i] = sc.nextInt();
            }
            sb.append(countValidPasscodes(tree, n)).append('\n');
            System.out.println("Tree: " + Arrays.toString(tree));
        }
        System.out.println("Output: "+ sb);
    }
}