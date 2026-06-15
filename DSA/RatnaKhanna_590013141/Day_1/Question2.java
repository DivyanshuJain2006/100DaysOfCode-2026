import java.util.*;
class Question2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();
        int[] nums = new int[n];
        int sum = 0;
        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
            sum = sum + nums[i];
        }
        System.out.println("Sum of array elements = " + sum);
        sc.close();
    }
}
