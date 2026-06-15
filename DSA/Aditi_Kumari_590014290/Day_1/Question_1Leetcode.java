package Day_1;
import java.util.*;
public class Question_1Leetcode{
    public static int missing(int[] nums){
    int arr_len = nums.length;
    int actual_sum = 0;

    int sum_expected = (arr_len * (arr_len + 1)) / 2;

    for (int num : nums){
        actual_sum += num;
    }

    return sum_expected - actual_sum;
}
    public static void main(String[]args){
        Scanner scan=new Scanner(System.in);
        int n= scan.nextInt();
        int[] nums=new int[n];

        for (int i=0; i<n; i++){
            nums[i]= scan.nextInt();
            }
            System.out.println("Missing number is:"+missing(nums));
            scan.close();
    }
}