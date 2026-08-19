import java.io.*;
import java.util.*;
public class Question2 {
    static int maxRob(int[] tree, int n) {
        if (tree[0] == -1) return 0;
        for (int i = n - 1; i >= 0; i--) {
            if (tree[i] == -1) continue;

            int left = 2 * i + 1;
            int right = left + 1;

            int rob = tree[i];
            int skip = 0;

            if (left < n && tree[left] != -1) {
                skip += tree[left];

                int leftChild = 2 * left + 1;
                int rightChild = leftChild + 1;

                if (leftChild < n && tree[leftChild] != -1)
                    rob += tree[leftChild];

                if (rightChild < n && tree[rightChild] != -1)
                    rob += tree[rightChild];
            }

            if (right < n && tree[right] != -1) {
                skip += tree[right];

                int leftChild = 2 * right + 1;
                int rightChild = leftChild + 1;
                if (leftChild < n && tree[leftChild] != -1) rob += tree[leftChild];
                if (rightChild < n && tree[rightChild] != -1) rob += tree[rightChild];
            }
            tree[i] = Math.max(rob, skip);
        }
        return tree[0];
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter the number of houses : ");
        int n = Integer.parseInt(br.readLine().trim());
        if (n < 1 || n > 1000) {
            System.out.println("Invalid input.");
            return;
        }
        int[] tree = new int[n];
        System.out.println("Enter " + n +" house values (-1 for missing houses):");
        int index = 0;
        while (index < n) {
        String[] values = br.readLine().trim().split("\\s+");
        for (String value : values) {
            if (index == n) break;
            int house = Integer.parseInt(value);
            if (house < -1 || house > 10000) {
            System.out.println("Invalid house value. Enter -1 or a value from 0 to 10000.");
            return;
        }
            tree[index++] = house;
    }
}
        System.out.println("Tree: " + Arrays.toString(tree));
        System.out.println("Maximum amount of money that can be robbed: "+ maxRob(tree, n));
    }
}