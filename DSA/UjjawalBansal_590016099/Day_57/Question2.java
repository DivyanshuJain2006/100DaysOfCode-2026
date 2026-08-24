import java.util.Scanner;

public class Question2 {
    
    public static boolean isMirror(int idx1, int idx2, int[] arr1, int[] arr2) {
        if (idx1 >= arr1.length && idx2 >= arr2.length) {
            return true;
        }
        
        int val1 = (idx1 < arr1.length) ? arr1[idx1] : -1;
        int val2 = (idx2 < arr2.length) ? arr2[idx2] : -1;
        
        if (val1 == -1 && val2 == -1) {
            return true;
        }
        
        if (val1 != val2) {
            return false;
        }
        
        return isMirror(2 * idx1 + 1, 2 * idx2 + 2, arr1, arr2) && 
               isMirror(2 * idx1 + 2, 2 * idx2 + 1, arr1, arr2);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        if (!scanner.hasNextInt()) {
            scanner.close();
            return;
        }
        
        int t = scanner.nextInt();
        
        for (int i = 0; i < t; i++) {
            int n1 = scanner.nextInt();
            int[] arr1 = new int[n1];
            for (int j = 0; j < n1; j++) {
                arr1[j] = scanner.nextInt();
            }
            
            int n2 = scanner.nextInt();
            int[] arr2 = new int[n2];
            for (int j = 0; j < n2; j++) {
                arr2[j] = scanner.nextInt();
            }
            
            if (isMirror(0, 0, arr1, arr2)) {
                System.out.println("YES");
            } 
            else {
                System.out.println("NO");
            }
        }
        
        scanner.close();
    }
}