package DSA.TanmaySharma_590011578.Day_1;

import java.util.Scanner;

public class Problem1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr ={12,35,1,10,34,1};
        Problem1 s= new Problem1();
        System.out.println(s.SumOfArray(arr));
        sc.close();

    }
    public int SumOfArray(int[] arr){
        int sum=0;
        for(int i:arr){
            sum+=i;
        }
        return sum;
    }
}
