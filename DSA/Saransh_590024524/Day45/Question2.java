import package DSA.Saransh_590024524.Day45;

public class Question2 {
    int inversion(int ar[] , int n)
    {
        int count = 0;
        for (int i =0 ; i<n-1 ; i++)
        {
            for (int j=i+1 ; j<n ; j++)
            {
                if(ar[i] > ar[j])
                    count += 1;
            }
        }
        return count;
    }
}


