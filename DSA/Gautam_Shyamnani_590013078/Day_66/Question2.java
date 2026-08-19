import java.util.*;

public class Question2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        TreeSet<Integer> employees = new TreeSet<>();

        int n1 = sc.nextInt();

        for (int i = 0; i < n1; i++) {
            int value = sc.nextInt();

            if (value != -1) {
                employees.add(value);
            }
        }

        int n2 = sc.nextInt();

        for (int i = 0; i < n2; i++) {
            int value = sc.nextInt();

            if (value != -1) {
                employees.add(value);
            }
        }

        System.out.print("[");

        boolean first = true;

        for (int value : employees) {
            if (!first) {
                System.out.print(", ");
            }

            System.out.print(value);
            first = false;
        }

        System.out.println("]");

        sc.close();
    }
}