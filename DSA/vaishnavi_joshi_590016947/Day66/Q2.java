import java.util.*;

public class Main {

    public static int[] mergeBSTs(int[] tree1, int[] tree2) {

        // TreeSet stores unique values in sorted order
        TreeSet<Integer> set = new TreeSet<>();

        // Add values from first tree
        for (int value : tree1) {
            if (value != -1) {
                set.add(value);
            }
        }

        // Add values from second tree
        for (int value : tree2) {
            if (value != -1) {
                set.add(value);
            }
        }

        // Convert TreeSet to int[]
        int[] result = new int[set.size()];

        int index = 0;
        for (int value : set) {
            result[index++] = value;
        }

        return result;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {

            int n1 = sc.nextInt();
            int[] tree1 = new int[n1];

            for (int i = 0; i < n1; i++) {
                tree1[i] = sc.nextInt();
            }

            int n2 = sc.nextInt();
            int[] tree2 = new int[n2];

            for (int i = 0; i < n2; i++) {
                tree2[i] = sc.nextInt();
            }

            int[] result = mergeBSTs(tree1, tree2);

            System.out.print("[");

            for (int i = 0; i < result.length; i++) {
                if (i > 0) {
                    System.out.print(", ");
                }
                System.out.print(result[i]);
            }

            System.out.println("]");
        }

        sc.close();
    }
}