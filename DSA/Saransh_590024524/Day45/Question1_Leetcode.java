class Solution {
    public int searchInsert(int[] nums, int target) 
    {
        //Binary search
        int i,mid,le = 0,ri=nums.length-1;
        while(le<=ri)
        {
            mid = (le+ri)/2;
            if(nums[mid] == target)
                return mid;    
            else if (nums[mid] < target)
                le = mid+1;
            else if (nums[mid] > target)
                ri = mid-1;         
        }
        return le;
    }
}