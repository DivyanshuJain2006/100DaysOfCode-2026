class Solution {
    public int missingNumber(int[] nums) 
    {
        int a_sum=0;
        int n=nums.length;
        int e_sum=(n*(n+1))/2;
        for(int i=0;i<n;i++)
        {
            a_sum=a_sum+nums[i];
        }
        return (e_sum-a_sum);
    }
}
