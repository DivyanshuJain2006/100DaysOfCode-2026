import java.util.Scanner;

public class Question1_Leetcode{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for(int i=0;i < n;i++){
           arr[i] = sc.nextInt();     
        }

    //Main Logic
    int sum = 0;
    for(int i=0;i < arr.length;i++){
        sum += arr[i];
    }
    
    System.out.println(sum);
    sc.close();
    
    }   
}
