package DSA.TanmaySharma_590011578.Day_1;

import java.util.Scanner;

public class Problem2_Leetcode {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Problem2_Leetcode p= new Problem2_Leetcode();
        int[] arr={3,0,1};
        System.out.println(p.MissingNumber(arr));
        in.close();

    }
    public int MissingNumber(int[] arr){
        int  xor_1=0;
        int xor_2=0;
        int n =arr.length;

        for(int i:arr){
            xor_1^=i;
        }
        for(int i=0;i<=n;i++){
            xor_2^=i;

        }
        return xor_1^xor_2;

    }
    
}
