import java.util.*;
class Question2 
{
    static int countValidPaths(int[] tree) 
    {
        if (tree.length == 0 || tree[0] == -1) 
        {
            return 0;
        }

        int count = 0;
        Stack<long[]> stack = new Stack<>();
        stack.push(new long[]{0, 1L << tree[0]});

        while (!stack.isEmpty()) 
        {
            long[] current = stack.pop();
            int index = (int) current[0];
            long mask = current[1];

            int left = 2 * index + 1;
            int right = 2 * index + 2;

            boolean hasLeft = left < tree.length && tree[left] != -1;
            boolean hasRight = right < tree.length && tree[right] != -1;

            if (!hasLeft && !hasRight) 
            {
                if ((mask & (mask - 1)) == 0) 
                {
                    count++;
                }
                continue;
            }

            if (hasLeft) 
            {
                long newMask = mask ^ (1L << tree[left]);
                stack.push(new long[]{left, newMask});
            }

            if (hasRight) 
            {
                long newMask = mask ^ (1L << tree[right]);
                stack.push(new long[]{right, newMask});
            }
        }
        return count;
    }

    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) 
        {
            int n = sc.nextInt();
            int[] tree = new int[n];

            for (int i = 0; i < n; i++) 
            {
                tree[i] = sc.nextInt();
            }
            System.out.println(countValidPaths(tree));
        }
        sc.close();
    }
}