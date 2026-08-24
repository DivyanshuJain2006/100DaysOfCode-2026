package Day_57;

import java.util.*;

public class d57question2_technical {
    public static String checkMirror(int[] Arr1, int[] Arr2)
    { if (Arr1.length != Arr2.length) { return "NO";    } 
    Queue<int[]> q = new LinkedList<>();
     q.add(new int[]{0, 0});
    while (!q.isEmpty()) { int[] temp = q.remove();
    int i = temp[0];
    int j = temp[1];
    if (Arr1[i] == -1 && Arr2[j] == -1) { continue;}
    if (Arr1[i] == -1 || Arr2[j] == -1) { return "NO";    } 
    if (Arr1[i] != Arr2[j]) { return "NO";    } 
    int left1 = 2 * i + 1;
    int right1 = 2 * i + 2;
    int left2 = 2 * j + 1;
    int right2 = 2 * j + 2;
    if (left1 < Arr1.length && right2 < Arr2.length) { q.add(new int[]{left1, right2});
    } if (right1 < Arr1.length && left2 < Arr2.length) { q.add(new int[]{right1, left2});
    } } return "YES";
    }
public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Size of Array: ");
        int n1 = sc.nextInt();
        int[] Arr1 = new int[n1];
        for(int i=0;i<n1;i++){
            System.out.print(": ");
            Arr1[i]=sc.nextInt();}
        System.out.print("Enter Size of Array: ");
        int n2 = sc.nextInt();
        sc.nextLine();
        int[] Arr2 = new int[n2];
        for(int i=0;i<n2;i++){
            System.out.print(": ");
            Arr2[i]=sc.nextInt();}
        System.out.println(checkMirror(Arr1,Arr2));
        sc.close();}}
