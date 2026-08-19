public class Question1
{
    public static int findJudge(int n,int[][] trust)
    {
        int[] score=new int[n+1];

        for(int[] t:trust)
        {
            score[t[0]]--;
            score[t[1]]++;
        }

        for(int i=1;i<=n;i++)
        {
            if(score[i]==n-1)
                return i;
        }

        return -1;
    }

    public static void main(String[] args)
    {
        int n=3;
        int[][] trust={{1,3},{2,3}};

        System.out.println(findJudge(n,trust));
    }
}