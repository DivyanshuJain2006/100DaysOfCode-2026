int maxDepth(int student, int mentor[]) 
{
    int depth=0;
    while(student!=-1) 
    {
        depth++;
        student=mentor[student-1];   
    }
    return depth;
}
int minGroups(int n,int mentor[]) 
{
    int ans=0;
    for (int i=1;i<=n;i++) 
    {
        int depth=maxDepth(i,mentor);
        if (depth>ans)
            ans=depth;
    }
    return ans;
}