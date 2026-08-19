import java.util.Scanner;
import java.util.Arrays;

public class Question2 {
    public static int minGroups(int n, int[] mentor) {
        int[] depth = new int[n];
        int maxG = 0;
        
        for (int i = 0; i < n; i++) {
            int curr = getDepth(i, mentor, depth);
            maxG = Math.max(maxG, curr);
        }
        return maxG;
    }
    
    private static int getDepth(int stdInd, int[] mentor, int[] depth) {
        if (depth[stdInd] != 0) {
            return depth[stdInd];
        }
        
        if (mentor[stdInd] == -1) {
            depth[stdInd] = 1;
        } 
        else {
            int menInd = mentor[stdInd] - 1;
            depth[stdInd] = 1 + getDepth(menInd, mentor, depth);
        }
        
        return depth[stdInd];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of students (n): ");
        int n = sc.nextInt();
            
        int[] mentor = new int[n];
        System.out.println("Enter the " + n + " mentor assignments (use -1 for no mentor):");
        for (int i = 0; i < n; i++) {
            mentor[i] = sc.nextInt();
        }
            
        System.out.println("Mentorship Array: " + Arrays.toString(mentor));
        int result = minGroups(n, mentor);
        System.out.println("Minimum number of groups required: " + result);
        sc.close();
    }
}