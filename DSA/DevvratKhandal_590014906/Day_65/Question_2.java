import java.util.*;

public class Question_2 {

    static double findClosest(int[] tree, double target) {

        int index = 0;
        double closest = tree[0];

        while (index < tree.length && tree[index] != -1) {

            double current = tree[index];

            if (Math.abs(current - target) < Math.abs(closest - target)) {
                closest = current;
            } 
            else if (Math.abs(current - target) == Math.abs(closest - target)
                    && current < closest) {
                closest = current;
            }

            if (current == target) {
                return current;
            }

            if (target < current) {
                index = 2 * index + 1;
            } else {
                index = 2 * index + 2;
            }
        }

        return closest;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of test cases:");
        int T = sc.nextInt();

        while (T-- > 0) {

            System.out.println("Enter number of nodes:");
            int n = sc.nextInt();

            int[] tree = new int[n];

            System.out.println("Enter tree elements (-1 for null):");

            for (int i = 0; i < n; i++) {
                tree[i] = sc.nextInt();
            }

            System.out.println("Enter target temperature:");
            double target = sc.nextDouble();

            double answer = findClosest(tree, target);

            System.out.println("Closest preset temperature:");

            if (answer == (int) answer)
                System.out.println((int) answer);
            else
                System.out.println(answer);
        }

        sc.close();
    }
}