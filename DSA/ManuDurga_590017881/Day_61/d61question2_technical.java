package Day_61;

import java.util.*;

public class d61question2_technical {
   static int minGroups(int[] mentor) {
        int n = mentor.length;
        int[] depth = new int[n];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, dfs(i, mentor, depth));
        }
        return ans;
    }

    static int dfs(int i, int[] mentor, int[] depth) {
        if (depth[i] != 0) return depth[i];
        if (mentor[i] == -1) return depth[i] = 1;
        return depth[i] = 1 + dfs(mentor[i] - 1, mentor, depth);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Size of Array: ");
        int n1 = sc.nextInt();
        int[] Arr1 = new int[n1];
        for(int i=0;i<n1;i++){
            System.out.print(": ");
            Arr1[i]=sc.nextInt();}
            System.out.println(minGroups(Arr1));
        
        sc.close();
    }}