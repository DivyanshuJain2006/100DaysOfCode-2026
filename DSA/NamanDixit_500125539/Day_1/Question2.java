
import java.util.*;

class PartB {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int sum = 1;
        for (int i = 1; i < arr.length; i++) {
            sum += arr[i];
        }
        System.out.println(sum);
    }
}
