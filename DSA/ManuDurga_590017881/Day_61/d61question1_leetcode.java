package Day_61;

import java.util.*;

public class d61question1_leetcode {
     public static int findJudge(int n, int[][] trust) {
        int[] into = new int[n + 1];
        int[] outof = new int[n + 1];

        for (int[] t : trust) {
            outof[t[0]]++;into[t[1]]++;
        }

        for (int i = 1; i <= n; i++) {
            if (outof[i] == 0 && into[i] == n - 1) return i;
        }
        return -1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n: ");
        int k = sc.nextInt();
        System.out.print("Enter Size of Array: ");
        int n1 = sc.nextInt();
        int[][] Arr1 = new int[2][n1];
        for(int i=0;i<n1;i++){
            for (int j = 0; j < Arr1.length; j++) {
            System.out.print(": ");
            Arr1[j][i]=sc.nextInt();}}
    System.out.println(findJudge(k, Arr1));
    sc.close();
        }
}
