import java.util.*;
public class Question2
{
    static int countSafe(int[] tree)
    {
        if(tree.length==0 || tree[0]==-1)
            return 0;
        int count=0;
        Queue<int[]> q=new LinkedList<>();
        q.add(new int[]{0,tree[0]});
        while(!q.isEmpty())
        {
            int[] current=q.poll();
            int index=current[0];
            int maxSoFar=current[1];
            int value=tree[index];
            if(value>=maxSoFar)
                count++;
            int newMax=Math.max(maxSoFar,value);
            int left=2*index+1;
            int right=2*index+2;
            if(left<tree.length && tree[left]!=-1)
                q.add(new int[]{left,newMax});
            if(right<tree.length && tree[right]!=-1)
                q.add(new int[]{right,newMax});
        }
        return count;
    }
    public static void main(String[] args)
    {
        int[] tree={3,1,4,3,-1,1,5};
        System.out.println(countSafe(tree));
    }
}