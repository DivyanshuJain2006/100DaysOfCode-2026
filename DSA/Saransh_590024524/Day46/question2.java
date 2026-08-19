package DSA.Saransh_590024524.Day46;

public class question2 {
    int score(int nums[])
    {
        int max = nums[0];
        int min = nums[0];
        for (int i=0 ; i<nums.length ; i++)
        {
            if(nums[i] > max)
                max = nums[i];
            if(nums[i] < min)
                min = nums[i];
        }
        return (max - min) * (nums.length - 1);
    }
}
