package Day_1;

import java.util.*;
public class Question_2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = scan.nextInt();
        }
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        System.out.println("Sum is: " + sum);
        scan.close();
    }
}
