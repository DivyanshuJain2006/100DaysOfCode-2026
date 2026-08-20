import java.util.*;

public class Question2 {

    static int minus=0;
    static int zero=0;
    static int plus=0;

    static int solve(int n) {
        if(n==0)
            return -1;

        int left=(n-1)/2;
        int right=n-1-left;

        int leftHeight=solve(left);
        int rightHeight=solve(right);

        int balance=rightHeight-leftHeight;

        if(balance==-1)
            minus++;

        else if(balance==0)
            zero++;

        else
            plus++;

        return 1+Math.max(leftHeight,rightHeight);
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        int n=sc.nextInt();

        for(int i=0;i<n;i++)
            sc.nextInt();

        solve(n);

        System.out.println(minus+" "+zero+" "+plus);
    }
}