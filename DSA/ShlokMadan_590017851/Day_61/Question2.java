public class Question2
{
    public static int findGroups(int n,int[] mentor)
    {
        int[] depth=new int[n];

        for(int i=0;i<n;i++)
        {
            if(depth[i]!=0)
                continue;

            int current=i;
            int count=0;

            while(current!=-1 && depth[current]==0)
            {
                count++;

                if(mentor[current]==-1)
                {
                    current=-1;
                }
                else
                {
                    current=mentor[current]-1;
                }
            }

            int value=count;
            current=i;

            while(current!=-1 && depth[current]==0)
            {
                depth[current]=value;
                value--;

                if(mentor[current]==-1)
                {
                    current=-1;
                }
                else
                {
                    current=mentor[current]-1;
                }
            }
        }

        int answer=0;

        for(int i=0;i<n;i++)
        {
            answer=Math.max(answer,depth[i]);
        }

        return answer;
    }

    public static void main(String[] args)
    {
        int n=5;
        int[] mentor={-1,1,2,1,-1};

        System.out.println(findGroups(n,mentor));
    }
}