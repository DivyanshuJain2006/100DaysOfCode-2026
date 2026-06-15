import java.util.*;

public class Question2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int expectedSum = n * (n + 1) / 2;

        int actualSum = 0;

        for(int i = 0; i < n; i++) {
            actualSum += sc.nextInt();
        }

        System.out.println(expectedSum - actualSum);

        sc.close();
    }
}